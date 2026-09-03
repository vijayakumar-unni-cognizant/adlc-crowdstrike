package com.adlccrowdstrike.aem.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/** Presentation model for the single, authorable site-header surface. */
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SiteHeaderModel {
    @ValueMapValue private String logoReference;
    @ValueMapValue private String logoAlt;
    @ValueMapValue private String homeUrl;
    @ValueMapValue private String navigationLabel;
    @ValueMapValue private String menuLabel;
    @ValueMapValue private String closeLabel;
    @ValueMapValue private String teamLabel;
    @ValueMapValue private String teamUrl;
    @ChildResource private Resource teamItems;
    @ChildResource private Resource primaryItems;
    @SlingObject private SlingHttpServletRequest request;
    private List<NavigationItem> teamItemList = Collections.emptyList();
    private List<NavigationItem> primaryItemList = Collections.emptyList();
    private String currentPath = "";

    @PostConstruct
    private void init() {
        currentPath = request == null ? "" : StringUtils.defaultString(request.getRequestPathInfo().getResourcePath());
        teamItemList = toItems(teamItems);
        primaryItemList = toItems(primaryItems);
    }

    private List<NavigationItem> toItems(Resource parent) {
        if (parent == null) return Collections.emptyList();
        List<NavigationItem> items = new ArrayList<>();
        for (Resource child : parent.getChildren()) {
            String label = child.getValueMap().get("label", String.class);
            String url = child.getValueMap().get("url", String.class);
            if (StringUtils.isNotBlank(label) && StringUtils.isNotBlank(url)) {
                items.add(new NavigationItem(label, url, child.getValueMap().get("openInNewTab", false), child.getValueMap().get("active", false)));
            }
        }
        return Collections.unmodifiableList(items);
    }

    public String getLogoReference() { return logoReference; }
    public String getLogoAlt() { return logoAlt; }
    public String getHomeUrl() { return homeUrl; }
    public String getNavigationLabel() { return StringUtils.defaultIfBlank(navigationLabel, "Primary navigation"); }
    public String getMenuLabel() { return StringUtils.defaultIfBlank(menuLabel, "Menu"); }
    public String getCloseLabel() { return StringUtils.defaultIfBlank(closeLabel, "Close menu"); }
    public String getTeamLabel() { return teamLabel; }
    public String getTeamUrl() { return teamUrl; }
    public List<NavigationItem> getTeamItems() { return teamItemList; }
    public List<NavigationItem> getPrimaryItems() { return primaryItemList; }
    public String getCurrentPath() { return currentPath; }

    public final class NavigationItem {
        private final String label; private final String url; private final boolean external; private final boolean active;
        private NavigationItem(String label, String url, boolean external, boolean active) { this.label = label; this.url = url; this.external = external; this.active = active; }
        public String getLabel() { return label; }
        public String getUrl() { return url; }
        public boolean isExternal() { return external; }
        /**
         * Navigation is authored with public URLs while Sling exposes the current
         * repository resource path.  A public route is therefore current when it
         * is the terminal route of the internal page path as well as when both
         * values are already identical.
         */
        public boolean isCurrent() {
            String navigationPath = normalizePath(url);
            String requestPath = normalizePath(currentPath);
            return active || (StringUtils.isNotBlank(navigationPath)
                    && (StringUtils.equals(navigationPath, requestPath)
                    || StringUtils.endsWith(requestPath, navigationPath)));
        }

        private String normalizePath(String value) {
            if (StringUtils.isBlank(value) || value.startsWith("http://") || value.startsWith("https://")) {
                return "";
            }
            String path = StringUtils.substringBefore(StringUtils.substringBefore(value, "?"), "#");
            path = StringUtils.removeEnd(path, ".html");
            path = StringUtils.removeEnd(path, "/");
            return StringUtils.defaultIfBlank(path, "/");
        }
    }
}
