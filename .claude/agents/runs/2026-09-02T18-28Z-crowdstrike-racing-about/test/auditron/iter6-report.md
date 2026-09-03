# Auditron Targeted Remediation Revalidation — CrowdStrike Racing About

- **status:** FAIL
- **run:** 2026-09-02T18-28Z-crowdstrike-racing-about
- **url:** 

> The remediation is persisted and deployed to Author, but rendered behavior remains incorrect: Teaser nodes have their intended title/description values yet render the page title, and the internal About anchor still has no active-page state when supplied through the header XF.

## Track matrix

| Track | Verdict | Detail |
|---|---|---|
| Targeted package/deploy | PARTIAL PASS | New all-package ZIP exists and changed properties are visible on Author; Windows Maven launcher did not yield a capturable exit/log or fresh Surefire XML |
| Persisted Teaser fields | PASS | All five title values and four editorial jcr:description values are present on Author nodes |
| Rendered Teaser fields | FAIL | Rendered H2s repeat About Us \| CrowdStrike Racing; required headings/body copy occur zero times |
| Header URL persistence | PASS | About URL is /content/adlc-crowdstrike/us/en/about-us.html and anchor renders |
| Header active state | FAIL | 0 aria-current=page in page and XF render |
| Publish | WAIVED | User waived local Publish |

## Findings

### [HIGH] LCL-TEASER-003 — Persisted title/description properties are ignored by rendered Teaser model
- **Issue:** All seeded nodes now persist title (not jcr:title); editorial nodes persist jcr:description. Author HTML still renders the page title for all Teasers and no required editorial copy.
- **Evidence:** Infinity JSON: each node title is correct and editorial description lengths are 430/431/503/469. Rendered H2 extraction repeats About Us | CrowdStrike Racing; We Stop Breaches, Why We Race, APR, Oreca and Performance under pressure all have zero occurrences.
- **Cause:** The proxy/Core Teaser v2 runtime contract remains mismatched; changing the stored title property alone does not reach the rendered model.
- **Recommended fix:** Inspect the installed Core Teaser v2 model/dialog contract and proxy inheritance, then correct the property/delegation configuration. Verify rendered output, not only node JSON.
- **Route:** blockwright + composer
- **Status:** open — release-blocking

### [HIGH] LCL-NAV-003 — Valid internal About URL still has no active-page state through Experience Fragment
- **Issue:** The internal URL now persists and renders as an anchor, but aria-current=page remains absent in both the page and header-XF output.
- **Evidence:** Header node stores /content/adlc-crowdstrike/us/en/about-us.html; page has 2 matching hrefs, header XF has 1, and both have 0 aria-current=page.
- **Cause:** The header model derives currentPath from the XF inclusion request, not the containing page request.
- **Recommended fix:** Derive the containing/current page from the XF request context or pass an explicit page context; add a live XF inclusion regression test for active navigation.
- **Route:** blockwright
- **Status:** open — release-blocking
