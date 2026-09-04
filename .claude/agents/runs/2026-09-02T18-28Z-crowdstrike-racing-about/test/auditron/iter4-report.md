# Auditron Extended Local SDK Validation — CrowdStrike Racing About

- **status:** FAIL
- **run:** 2026-09-02T18-28Z-crowdstrike-racing-about
- **url:** 

> Human-authorized extension consumed two additional Maven calls. Package/unit and integration reports pass, but live Author rendering fails because the core bundle is **Installed**, not Active; HTL cannot resolve the custom header/footer Sling Models.

## Track matrix

| Track | Verdict | Detail |
|---|---|---|
| Extended Build #3 | PARTIAL PASS | All-package ZIP 7,661,144 bytes; 8 Surefire tests pass; captured process exit/log unavailable |
| Extended Integration #4 | PASS | Failsafe 5 tests, 0 failures/errors using local profile |
| Author live render | FAIL | HTTP 200 but zero custom header/footer DOM nodes; HTL model-resolution exception |
| Publish live render | NOT AVAILABLE | http://localhost:4503 unreachable |

## Findings

### [HIGH] LCL-OSGI-001 — Core bundle is Installed rather than Active, preventing custom chrome rendering
- **Issue:** The Author page includes both XF wrappers but neither custom header nor footer renders. Each XF contains an HTL compilation exception resolving SiteHeaderModel/SiteFooterModel.
- **Evidence:** Author bundles.json reports bundle 653 ‘ADLC Crowdstrike - Core’ state Installed. GET About page: header=0, footer=0, and exception ‘SiteHeaderModel cannot be resolved to a type’.
- **Cause:** The application bundle has unresolved runtime activation/dependency state; package creation and unit tests do not prove OSGi activation.
- **Recommended fix:** Inspect bundle 653’s unresolved imports/activation diagnostics, correct the core bundle manifest/dependency issue, deploy, and verify the bundle is Active plus one rendered header/footer on Author and Publish.
- **Route:** blockwright
- **Status:** open — release-blocking

### [MEDIUM] LCL-PUB-001 — Local Publish endpoint is unavailable
- **Issue:** Publish route validation could not run.
- **Evidence:** GET http://localhost:4503/content/adlc-crowdstrike/us/en/about-us.html failed to connect.
- **Cause:** No local Publish process is listening on 4503.
- **Recommended fix:** Start/configure local Publish before rerunning tier-specific validation.
- **Route:** environment owner
- **Status:** open
