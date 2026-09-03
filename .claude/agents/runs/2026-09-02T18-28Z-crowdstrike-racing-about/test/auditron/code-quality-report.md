# Auditron Code Quality Report — CrowdStrike Racing About

- **status:** FAIL
- **run:** 2026-09-02T18-28Z-crowdstrike-racing-about
- **url:** 

> Review gate failed before Maven: **AUD-HDR-001** prevents the required active About navigation state. Maven budget remains **0/2**.

## Scores

- Static review: **0** (1 high finding)

## Track matrix

| Track | Verdict | Detail |
|---|---|---|
| Cross-file review | FAIL | One unaccepted high correctness finding |
| FileVault/XML/DAM | PASS | 222 XML files parse; namespace/protected-property checks pass |
| Policy/template/content | PASS | Template mappings, explicit allowlists, numeric style IDs and DAM paths resolve statically |
| Playwright migration | WARN | Source/lockfile use Playwright; stale Cypress module coordinates remain in ui.tests/pom.xml |
| Build gate | NOT RUN | Blocked by review gate; Maven 0/2 |

## Findings

### [HIGH] AUD-HDR-001 — Current-page comparison cannot match public navigation URLs
- **Issue:** The model returns request.getRequestPath().getResourcePath() (the internal AEM resource path) while seeded URLs are public paths such as /about-us/. isCurrent strips only .html, so /about-us/ cannot equal /content/adlc-crowdstrike/us/en/about-us.
- **Evidence:** SiteHeaderModel.java:29,56 and header master .content.xml public URL /about-us/; HTL consumes item.current and model.currentPath.
- **Cause:** No resource mapping or public-path normalization occurs before equality comparison.
- **Recommended fix:** Normalize both values into the same mapped public route (for example ResourceResolver.map(request, resourcePath) or a dedicated normalized request URL) and add unit tests for /about-us/, .html and the internal resource path.
- **Route:** blockwright
- **Status:** open — blocks Maven

### [MEDIUM] AUD-UI-001 — Cypress naming remains in Maven metadata
- **Issue:** The runner, Docker image, scripts and package lock use Playwright, but artifactId/name/description still state Cypress.
- **Evidence:** ui.tests/pom.xml:28-31; no Cypress dependency or source remains under test-module.
- **Cause:** Migration intentionally left POM unmodified.
- **Recommended fix:** Rename only descriptive Maven coordinates/text if compatibility permits; otherwise document the compatibility exception in the UI harness evidence.
- **Route:** blockwright
- **Status:** non-blocking follow-up

### [MEDIUM] CFG-SEO-001 — Publish-domain mapping is environment-owned
- **Issue:** No source-backed publish hostname is available.
- **Evidence:** configsmith handoff and security-review.md.
- **Cause:** No approved Cloud Manager hostname.
- **Recommended fix:** Configure the real publish/author domains and verify the Core Page canonical after deployment.
- **Route:** environment owner
- **Status:** non-blocking

### [LOW] CMP-ASSET-001 — Supplied image rights confirmation remains pending
- **Issue:** Use rights for supplied images and mirrored logo are owner-owned.
- **Evidence:** composer handoff.
- **Cause:** No rights confirmation was supplied.
- **Recommended fix:** Obtain and record rights confirmation before production activation.
- **Route:** content owner
- **Status:** non-blocking
