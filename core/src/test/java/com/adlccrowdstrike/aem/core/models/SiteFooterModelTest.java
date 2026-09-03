package com.adlccrowdstrike.aem.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.adlccrowdstrike.aem.core.testcontext.AppAemContext;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AemContextExtension.class)
class SiteFooterModelTest {
  private final AemContext context = AppAemContext.newAemContext();
  @BeforeEach void setUp() { context.addModelsForClasses(SiteFooterModel.class); context.create().resource("/content/footer", "sling:resourceType", "adlc-crowdstrike/components/site-footer", "racingGroupTitle", "Racing"); context.create().resource("/content/footer/racingLinks/item0", "label", "About", "url", "/content/site/about"); context.create().resource("/content/footer/socialLinks/item0", "label", "LinkedIn", "url", "https://example.com", "openInNewTab", true); }
  @Test void mapsIndependentLinkLists() { SiteFooterModel model = context.resourceResolver().getResource("/content/footer").adaptTo(SiteFooterModel.class); assertEquals(1, model.getRacingLinks().size()); assertEquals("LinkedIn", model.getSocialLinks().get(0).getLabel()); assertEquals(0, model.getWhyLinks().size()); }
}
