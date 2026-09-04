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
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/** Presentation model for the grouped, authorable site-footer surface. */
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SiteFooterModel {
    @ValueMapValue private String logoReference; @ValueMapValue private String logoAlt; @ValueMapValue private String homeUrl;
    @ValueMapValue private String racingGroupTitle; @ValueMapValue private String whyGroupTitle; @ValueMapValue private String socialGroupTitle;
    @ValueMapValue private String copyrightText; @ValueMapValue private String falconReference; @ValueMapValue private boolean falconDecorative;
    @ChildResource private Resource racingLinks; @ChildResource private Resource whyLinks; @ChildResource private Resource legalLinks; @ChildResource private Resource socialLinks;
    private List<FooterLink> racingLinkList = Collections.emptyList(), whyLinkList = Collections.emptyList(), legalLinkList = Collections.emptyList();
    private List<SocialLink> socialLinkList = Collections.emptyList();
    @PostConstruct private void init() { racingLinkList = links(racingLinks); whyLinkList = links(whyLinks); legalLinkList = links(legalLinks); socialLinkList = social(socialLinks); }
    private List<FooterLink> links(Resource parent) { List<FooterLink> result = new ArrayList<>(); if (parent != null) for (Resource child : parent.getChildren()) { String label = child.getValueMap().get("label", String.class), url = child.getValueMap().get("url", String.class); if (StringUtils.isNotBlank(label) && StringUtils.isNotBlank(url)) result.add(new FooterLink(label, url, child.getValueMap().get("openInNewTab", false))); } return Collections.unmodifiableList(result); }
    private List<SocialLink> social(Resource parent) { List<SocialLink> result = new ArrayList<>(); if (parent != null) for (Resource child : parent.getChildren()) { String label = child.getValueMap().get("label", String.class), url = child.getValueMap().get("url", String.class); if (StringUtils.isNotBlank(label) && StringUtils.isNotBlank(url)) result.add(new SocialLink(label, url, child.getValueMap().get("iconReference", String.class), child.getValueMap().get("openInNewTab", true))); } return Collections.unmodifiableList(result); }
    public String getLogoReference() { return logoReference; } public String getLogoAlt() { return logoAlt; } public String getHomeUrl() { return homeUrl; } public String getRacingGroupTitle() { return racingGroupTitle; } public String getWhyGroupTitle() { return whyGroupTitle; } public String getSocialGroupTitle() { return socialGroupTitle; } public String getCopyrightText() { return copyrightText; } public String getFalconReference() { return falconReference; } public boolean isFalconDecorative() { return falconDecorative; } public List<FooterLink> getRacingLinks() { return racingLinkList; } public List<FooterLink> getWhyLinks() { return whyLinkList; } public List<FooterLink> getLegalLinks() { return legalLinkList; } public List<SocialLink> getSocialLinks() { return socialLinkList; }
    public static class FooterLink { private final String label, url; private final boolean external; FooterLink(String label, String url, boolean external) { this.label=label; this.url=url; this.external=external; } public String getLabel() { return label; } public String getUrl() { return url; } public boolean isExternal() { return external; } }
    public static final class SocialLink extends FooterLink { private final String iconReference; SocialLink(String label, String url, String iconReference, boolean external) { super(label,url,external); this.iconReference=iconReference; } public String getIconReference() { return iconReference; } }
}
