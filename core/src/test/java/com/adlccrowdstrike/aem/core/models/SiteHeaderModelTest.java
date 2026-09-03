package com.adlccrowdstrike.aem.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.adlccrowdstrike.aem.core.testcontext.AppAemContext;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AemContextExtension.class)
class SiteHeaderModelTest {
  private final AemContext context = AppAemContext.newAemContext();
  @BeforeEach void setUp() { context.addModelsForClasses(SiteHeaderModel.class); context.create().resource("/content/site/about", "sling:resourceType", "adlc-crowdstrike/components/site-header", "teamLabel", "The Team", "teamUrl", "/content/site/team", "navigationLabel", "Primary navigation"); context.create().resource("/content/site/about/teamItems/item0", "label", "Drivers", "url", "/content/site/drivers"); context.create().resource("/content/site/about/primaryItems/item0", "label", "About", "url", "/content/site/about"); }
  @Test void mapsOnlyCompleteLinksAndCurrentPath() { SiteHeaderModel model = context.resourceResolver().getResource("/content/site/about").adaptTo(SiteHeaderModel.class); assertEquals(1, model.getTeamItems().size()); assertEquals("About", model.getPrimaryItems().get(0).getLabel()); }

  @Test void marksPublicRouteCurrentForInternalAemPath() {
    context.create().resource("/content/adlc-crowdstrike/us/en/about-us", "sling:resourceType", "adlc-crowdstrike/components/site-header");
    context.create().resource("/content/adlc-crowdstrike/us/en/about-us/primaryItems/item0", "label", "About", "url", "/about-us/");
    context.request().setResource(context.resourceResolver().getResource("/content/adlc-crowdstrike/us/en/about-us"));
    context.requestPathInfo().setResourcePath("/content/adlc-crowdstrike/us/en/about-us");
    SiteHeaderModel model = context.request().adaptTo(SiteHeaderModel.class);
    assertTrue(model.getPrimaryItems().get(0).isCurrent());
  }
}
