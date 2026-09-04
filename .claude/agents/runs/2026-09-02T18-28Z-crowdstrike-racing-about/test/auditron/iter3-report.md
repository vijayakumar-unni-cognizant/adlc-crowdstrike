# Auditron Final Build Gate Report — CrowdStrike Racing About

- **status:** FAIL
- **run:** 2026-09-02T18-28Z-crowdstrike-racing-about
- **url:** 

> Both permitted Maven calls were consumed and failed. Call #1 found an unsupported request API; call #2 compiled but its new header-route unit test failed. Integration was not run. Maven budget: **2/2 used**.

## Track matrix

| Track | Verdict | Detail |
|---|---|---|
| Static re-review | PASS | Route normalization and current-state logic are present |
| Build #1 | FAIL | Unsupported getRequestPath() API |
| Build #2 | FAIL | 8 tests, 1 failure: marksPublicRouteCurrentForInternalAemPath |
| Integration | NOT RUN | No Maven capacity remains; local Publish 4503 is unavailable |

## Findings

### [HIGH] BLD-HDR-002 — Public-route current-state regression test fails
- **Issue:** The model test expects /about-us/ to be current for the internal page path, but the adapted model returns false.
- **Evidence:** /tmp/aem-build-2.log: SiteHeaderModelTest.marksPublicRouteCurrentForInternalAemPath line 23, expected true but was false; Surefire: 8 run, 1 failure.
- **Cause:** The test request/resource setup does not supply the model with the intended request resource path, or the model must derive the path from the adaptable resource when request path info is unavailable.
- **Recommended fix:** Correct the test setup and/or safely fall back to the adaptable Resource path; add both positive and negative route cases. Start a new Auditron run for validation because this run exhausted its Maven budget.
- **Route:** blockwright
- **Status:** open — terminal gate failure
