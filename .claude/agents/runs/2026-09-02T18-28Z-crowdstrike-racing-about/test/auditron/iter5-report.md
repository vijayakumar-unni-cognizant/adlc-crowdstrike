# Auditron Author-Only Live Validation — CrowdStrike Racing About

- **status:** FAIL
- **run:** 2026-09-02T18-28Z-crowdstrike-racing-about
- **url:** 

> Author bundle activation and custom chrome now pass, but the rendered About page fails source-content and navigation contracts: Teasers use the page title instead of authored section data, and public header routes are invalid/stripped in Author. Publish is waived for this local validation.

## Track matrix

| Track | Verdict | Detail |
|---|---|---|
| Core bundle | PASS | Bundle 653 is Active |
| Custom chrome / XF | PASS | Header and footer XF endpoints return their custom DOM; no model-resolution exception |
| Semantic hierarchy | FAIL | One H1 but editorial H2s repeat page title; required four section headings/copy are absent |
| Current navigation | FAIL | 0 aria-current=page; public header routes are link-checker invalid and no About anchor renders |
| Publish | WAIVED | User waived local Publish validation |

## Findings

### [HIGH] LCL-TEASER-002 — Editorial Teasers render the page title instead of authored section titles and descriptions
- **Issue:** The authored nodes contain jcr:title and jcr:description for We Stop Breaches, Why We Race, CrowdStrike Racing by APR, and No. 4 CrowdStrike Oreca 07, but rendered H2 output is About Us | CrowdStrike Racing and the expected body copy is absent.
- **Evidence:** Author About HTML has 1 H1 and 6 H2s; heading extraction contains repeated ‘About Us | CrowdStrike Racing’, while exact required editorial headings and ‘Performance under pressure’ occur zero times. Each node’s infinity JSON confirms jcr:title/jcr:description/fileReference exist.
- **Cause:** The Core Teaser v2 persisted-property contract is not being met by the seeded field placement; page-level jcr:title is taking precedence in rendered output.
- **Recommended fix:** Use the actual Core Teaser v2 persisted title/description fields and verify each rendered section against the source inventory on Author before a new build gate.
- **Route:** blockwright + composer
- **Status:** open — release-blocking

### [HIGH] LCL-NAV-002 — Public navigation routes are invalid in Author and no current page state renders
- **Issue:** The XF renders text-only navigation items: /about-us/ is invalid to Author Link Checker, no About anchor is rendered, and aria-current=page is absent.
- **Evidence:** Header XF and About page both return 0 aria-current=page and 0 href=/about-us/; Author output shows Link Checker ‘invalid link: /about-us/’ markers.
- **Cause:** The seeded public routes do not resolve to AEM content paths in Author; an XF request also does not provide the target page route to the current-state comparison.
- **Recommended fix:** Map authored internal routes to valid AEM content paths (or approved absolute destinations), and compute active state from the containing page/original request when rendered through an XF. Add an Author render regression test.
- **Route:** blockwright + composer
- **Status:** open — release-blocking
