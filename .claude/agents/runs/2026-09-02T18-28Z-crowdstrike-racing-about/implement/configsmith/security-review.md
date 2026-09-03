# Configsmith security review

Run: `2026-09-02T18-28Z-crowdstrike-racing-about`  
Scope: approved About page implementation, configuration, policy definitions, and any Dispatcher/CDN source present in the repository.

## Result

No high-severity finding was identified in the reviewed application/configuration sources. No service user, external API, secret, vanity route, or Dispatcher customization is required by the approved design.

| Severity | Finding | Disposition |
| --- | --- | --- |
| High | Administrative resolver, unsafe session write, plaintext application secret, missing service-user mapping | None found |
| Medium | Absolute canonical host cannot be provisioned from source | Pending environment-owned publish-domain configuration; no hostname was invented |
| Low | Existing UI-test files reference `AEM_*_PASSWORD` as environment variables and use archetype example values | Existing test harness behavior; not a deployed credential or a new configuration change |

## Evidence

| Check | Evidence/result |
| --- | --- |
| Configuration identifiers | `.aem-skills-config.yaml` is absent. The dispatch-approved fallback is root POM identifiers `adlc-crowdstrike` / `com.adlccrowdstrike`. |
| Administrative APIs | Static scan of `core/src`, `ui.apps/src`, `ui.config/src`, `ui.content/src`, `ui.frontend/src`, `ui.tests`, and `it.tests` found no `loginAdministrative`, `getAdministrativeResourceResolver`, `ResourceResolverFactory.SUBSERVICE`, or `getServiceResourceResolver` use. |
| Secrets | No plaintext secret/password/API-key configuration was found in the shipped AEM application/config sources. Existing UI-test password references are environment variable names or documentation examples. |
| Service users | The existing Repoinit file only creates/configures the project DAM path. No new service user was requested or introduced; therefore no ServiceUserMapper entry is required. |
| Least privilege | Racing container policies use explicit component paths, never wildcard groups. No ACL changes were made. |
| Canonical delivery | No `ExternalizerImpl` configuration is present. A publish hostname is deployment-owned and unknown, so adding an Externalizer file would fabricate an endpoint. Core Page v3 remains the sole canonical emitter; no duplicate canonical markup was added. |

## Required environment follow-up

Before Publish SEO sign-off, configure the actual author and publish domains through environment-owned OSGi configuration (for example, the Cloud Manager run-mode Externalizer configuration) and verify the Core Page canonical is absolute. This is a deployment input, not source-code content; record the configured host and Sentinel result after deployment.

## Policy hardening

The consolidated policy definitions in `ui.content/.../settings/wcm/policies/.content.xml` provide the following narrowly scoped targets for Blockwright mappings:

- `page/racing-page` with `adlc-crowdstrike.dependencies` and `adlc-crowdstrike.site` clientlibs.
- Structural `container/racing-root` and `container/racing-main`, hero/editorial slots, and editorial bands with explicit allowed component paths.
- `teaser/racing-hero` with the only h1 and numeric style ID `20260902001`.
- `teaser/racing-editorial` with all five approved editorial styles consolidated in one policy and numeric IDs `20260902002` through `20260902006`.
- Experience Fragment wrapper policies and XF-root policies that permit only the respective atomic header/footer component.

Final pointer resolution is rechecked after Blockwright materializes its template/XF mapping files.

