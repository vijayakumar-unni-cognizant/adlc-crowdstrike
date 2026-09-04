# Sentinel post-deployment report — CrowdStrike Racing About page

**Terminal verdict: FAIL.** This report measures build `c9d960e9f9f6b314133a8441fa4bc0d4723b4c35` on the real AEM Cloud environment supplied at resume. No implementation, UI-harness, PR, deployment, or release state was changed. Author authentication was used only in bearer-token mode; no credential or token is recorded here.

## Environment and execution

| Tier | URL role | Auth mode | Pre-probe |
| --- | --- | --- | --- |
| Author | author-p185256-e1945105 | bearer-token | 200 — page, page JSON, template JSON, header XF, footer XF, and hero DAM asset all readable |
| Publish | publish-p185256-e1945105 | none | 200 — anonymous SSR About page and hero DAM asset readable |

The repository contains a Playwright configuration and `@playwright/test`; no Cypress configuration or dependency is present. The full configured Publish suite was launched for Chromium, Firefox, WebKit, and mobile (20 scenario IDs, 80 project instances). Execution artifacts were retained under `playwright-publish/artifacts`; the runner did not emit its terminal JUnit/HTML summary in this execution environment, so only results confirmed by retained failure artifacts or independent runtime probes are treated as conclusive. This is not reported as a green execution.

## Blocking findings

| ID | Class / severity | Evidence | Owner |
| --- | --- | --- | --- |
| SEN-UI-001 | correctness / high | The deployed page has the designed seven top-level regions: header, hero, four editorials, footer. `UI-001` asserts six and fails in all public projects. The harness assertion is inconsistent with the approved scenario description. | blockwright |
| SEN-CONTENT-001 | correctness / high | The authored `we_stop_breaches/actions/item0` contains `Learn more about CrowdStrike`, but Publish has no editorial CTA anchor. `UI-012` failure artifacts and the runtime DOM both confirm this. | blockwright / composer |
| SEN-SEO-001 | correctness / high | Publish has no meta description or `og:title`, `og:description`, `og:image`, or `og:url`; canonical resolves to the internal `/content/.../about-us.html` path rather than the specified public canonical. `UI-015` fails. | blockwright / configsmith |
| SEN-SEO-002 | threshold / major | Anonymous `/robots.txt`, `/sitemap.xml`, and `/sitemap-index.xml` return 404. | configsmith |
| SEN-FOOTER-001 | correctness / high | Desktop/mobile screenshots show an unloaded logo, only two footer groups, no social group, and collapsed link presentation. This misses UI-013/TC-019 footer requirements. | composer / blockwright |
| SEN-VISUAL-001 | correctness / high | Both screenshots visibly render mojibake in editorial copy (for example `industryâ€™s`) and the desktop header has duplicate `The Team` labels. The reference-parity requirement is not met. | composer / blockwright |
| SEN-PERF-001 | threshold / major | Publish delivers the 2048px 1,479,597-byte hero original at a 358px mobile render width. This violates the explicit narrow-screen rendition requirement. Lighthouse did not complete in the execution host, so LCP/CLS/TTFB remain unmeasured rather than assumed. | blockwright / configsmith |

## Track results

| Track | Tier | Result | Evidence |
| --- | --- | --- | --- |
| UI tests | Publish | fail | Full Playwright launch retained failures for UI-001, UI-004, UI-005, UI-009, UI-012 and UI-015; terminal runner summary absent. |
| Reference / visual | Publish | fail | `publish-chromium-1440.png`, `publish-chromium-mobile-390.png`; local DAM assets are used, but visual/content defects above are present. |
| A11y deep | Publish | partial pass, overall incomplete | Chromium desktop and mobile axe WCAG tags reported zero critical/serious violations; required interaction/zoom and cross-engine completion is not evidenced. |
| NFR baseline | Publish | incomplete with observed threshold failure | Lighthouse could not complete in this host; mobile original-image delivery is directly observed as failing. |
| SEO deep | Publish | fail | Raw status and HTML captures in `seo/`; absent required metadata and 404 robots/sitemaps. |
| Observability | Publish | not_applicable | No Adobe Launch/analytics or error-tracking integration is declared in scope or present in delivered HTML. |
| Authoring provisions | Author | partial pass, blocked for mutation cases | Read-only author validation passed for stored page/template/XF/DAM state. Bearer-authenticated dialog mutation/reorder/round-trip and publish activation were not safely executable through the shipped form-login-only harness; they are not claimed as passed. |
| GraphQL content parity | Publish | not_applicable | Composer handoff declares server-rendered Sites only and no persisted queries/Content Fragments. |
| SPA integration | Publish | not_applicable | No headless/SPA consumer is present in this run. |

## Visual and content observations

The page does have one header, main, footer, h1, hero and four editorial components; Chromium desktop/mobile show no horizontal overflow and axe found no critical/serious issue in those two baseline probes. However, the approved hero/alternating-row structure cannot offset the blocking visual defects: broken logo, missing CTA/social footer content, duplicate header label, and incorrectly decoded copy.

## Required remediation and re-validation

1. Blockwright/Composer: restore Core Teaser action rendering, correct text encoding, render local logo successfully, and make the approved footer groups/social content render coherently.
2. Blockwright: correct the UI-001 assertion to the approved seven-region architecture; keep one spec per scenario and rerun all projects.
3. Blockwright/Configsmith: expose page title, description, public canonical, Open Graph metadata, robots and sitemap on Publish.
4. Blockwright/Configsmith: deliver responsive image renditions rather than the master on mobile; then run Lighthouse to establish LCP, CLS, TTFB, transfer, accessibility, best-practices, and SEO scores.
5. On re-dispatch, use an Author bearer-aware Playwright context or approved authoring API workflow to finish AUTH-003..010 and AUTH-012/014/016 without relying on form credentials.

Raw evidence: `author-preprobe.html`, `publish-preprobe.html`, `author-probes/`, `seo/`, `runtime-probes.partial.json`, `playwright-publish/artifacts/`, and the two Publish screenshots in this directory.
