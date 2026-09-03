# Auditron Iteration 2 Report — CrowdStrike Racing About

- **status:** FAIL
- **run:** 2026-09-02T18-28Z-crowdstrike-racing-about
- **url:** 

> The static header-route remediation cleared `AUD-HDR-001`; Maven Build Validation Gate call #1 then failed at compile time on **BLD-HDR-001**. Integration did not run. Maven budget: **1/2 used**.

## Track matrix

| Track | Verdict | Detail |
|---|---|---|
| Static re-review | PASS | Public/internal About-route comparison and its unit coverage are present |
| Local SDK discovery | WARN | Author 4502 reachable as admin/admin; Publish 4503 unreachable |
| Build Validation Gate #1 | FAIL | core compilation failure: SlingHttpServletRequest has no getRequestPath() |
| Integration #2 | NOT RUN | Forbidden after build failure; one Maven call remains |

## Findings

### [HIGH] BLD-HDR-001 — Unsupported Sling request API prevents compilation
- **Issue:** The remediated current-path initialization invokes request.getRequestPath().getResourcePath(), but this project's SlingHttpServletRequest API does not provide getRequestPath().
- **Evidence:** Maven build log /tmp/aem-build.log: SiteHeaderModel.java:[36,79] cannot find symbol method getRequestPath().
- **Cause:** The remediation targeted an unavailable request API.
- **Recommended fix:** Use a request/path API available in the configured AEM SDK (for example the supported request-path-info/resource path accessor), retain public-route normalization, and extend the model unit test. Re-run Auditron; only Build Gate call #2 remains in this run.
- **Route:** blockwright
- **Status:** open — blocks build and integration

### [INFO] AUD-HDR-001 — Public-route current-state defect remediated
- **Issue:** Previous public/internal route mismatch.
- **Evidence:** normalizePath plus terminal-route comparison and marksPublicRouteCurrentForInternalAemPath test are present.
- **Cause:** Remediated.
- **Recommended fix:** Keep coverage when changing the supported path accessor.
- **Route:** blockwright
- **Status:** fixed, pending successful compilation
