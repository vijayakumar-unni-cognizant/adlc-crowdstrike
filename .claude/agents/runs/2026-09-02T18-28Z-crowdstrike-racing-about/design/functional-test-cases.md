```ids: prefix=TC count=30 TC-001..TC-030 (no gaps)```

# Functional test cases

| ID | executor | Trace | Description, preconditions, data, steps | Expected result |
| --- | --- | --- | --- | --- |
| TC-001 | auditron | US-008 | With implementation present, inspect `racing-page` definition, template type, status, `allowedPaths`, and registration at project/us/en content roots. | Enabled template resolves only under project content; all three roots include exact anchored template regex. |
| TC-002 | auditron | US-008 | Inspect seeded `/content/adlc-crowdstrike/us/en/about-us` and ancestors plus FileVault filters. | Every segment is `cq:Page`; page uses `racing-page`; mutable content is in `ui.content` with safe update semantics. |
| TC-003 | auditron | US-007 | Resolve structure→policy mappings for root/main/hero/editorial/XF contexts and inspect component allowlists. | Every editable container has a non-empty explicit allowlist; no `*`, raw Core resource type, or Foundation responsive grid. |
| TC-004 | auditron | US-004, SRC-001..SRC-004 | Compare `site-header` dialog fields, model accessors, and HTL use contract against the design. | All fields map; model adapts from request+resource; no admin/service resolver; semantic header/nav/disclosure structure is possible. |
| TC-005 | auditron | US-005, SRC-018 | Compare `site-footer` dialog, accessors, and rendering contract. | Three groups, social, brand, legal and copyright map coherently; no raw HTML field or fragmented components. |
| TC-006 | auditron | US-002, US-003, US-007 | Inspect project Teaser proxy and changes. | Core Teaser v2 stays inherited with no custom dialog/HTL/edit config/model; all six styles are in reachable policies with unique numeric IDs. |
| TC-007 | auditron | US-002, US-006 | Render/inspect local SDK About page and policy mappings. | Exactly one h1 (`About Us`), four ordered h2s, no structural Title, logical footer headings. |
| TC-008 | auditron | US-002, SRC-005, SRC-006, ASSET-001 | Verify hero node data, DAM path/hash, image semantics, fetch priority and dimensions. | Exact asset/reference and h1; eager/high-priority responsive image, intrinsic geometry, useful alt, no remote request. |
| TC-009 | sentinel | US-002, US-006 | On real Publish at 1440/768/390, compare hero visual/crop to REF-WEB-001/ASSET-001. | Desktop overlay sits on dark left field; tablet/phone retain title contrast and all three drivers; no overflow. |
| TC-010 | auditron | US-001, SRC-007..SRC-017 | Normalize rendered local text and compare character-for-character to current-branch inventory in required section order. | Four canonical sections only; exact headings/copy/spec facts; no merged legacy prose. |
| TC-011 | auditron | US-003, ASSET-003..ASSET-006 | Read each editorial `fileReference` and verify DAM binary hash/section association. | We Stop/Why/APR/Oreca map respectively to ASSET-003/004/005/006. |
| TC-012 | auditron | US-003, SRC-009 | Inspect/render Section 1 action. Activate it in local test without leaving origin. | Exact accessible label and HTTPS CrowdStrike destination; safe rel if target-new; no action list in Sections 2–4. |
| TC-013 | auditron | US-003, SRC-015..SRC-017 | Inspect Section 4 RTE source and rendered local DOM. | One paragraph then one semantic `ul` with exactly three `li` values, punctuation preserved, no table/raw HTML script. |
| TC-014 | auditron | US-003 | Statically compare SCSS to pixel criteria and compute local styles at 1440. | Editorial parent is row/stretch; both panes have `flex:0 0 50%`, `width:50%`, `box-sizing:border-box`; alternating image order matches styles. |
| TC-015 | auditron | US-003, US-006 | Render at 320/390/768/1024/1199 widths on local SDK; inspect order/overflow. | Below 1200 rows stack content then image, copy remains readable, image subjects retained, no horizontal overflow. |
| TC-016 | auditron | US-004, SRC-001..SRC-003 | Render header on About route and inspect ordered labels, hrefs, hierarchy and state. | The Team + three submenu links, then CXO/Photo/About; About has `aria-current=page` plus non-color indication. |
| TC-017 | sentinel | US-004, SRC-004 | On real Publish, keyboard through desktop submenu and mobile control; press Enter/Space/Escape; move focus outside. | Accurate `aria-expanded`; no trap; Escape closes/restores focus; content is not permanently obscured; 44px mobile controls. |
| TC-018 | auditron | US-005, SRC-018 | Render local footer, normalize visible label/link order and count footer landmarks/DOM. | Exact three groups and current 2025 legal row render once; no 2023 duplicate or duplicated responsive DOM. |
| TC-019 | sentinel | US-005, US-006 | On Publish at three reference viewports, keyboard through footer and inspect computed grid. | 3/2/1-column behavior as designed; no clip/duplicate; focus order follows DOM; social links have names. |
| TC-020 | auditron | US-007 | Test empty optional CTA/image/group cases and required header/hero validations using unit/local fixtures. | Optional structures disappear cleanly; missing editorial image expands content; required fields reject save or produce safe non-broken output; no placeholder copy. |
| TC-021 | auditron | US-008, ASSET-001..ASSET-006 | Compare Composer manifest, packaged binaries, metadata, dimensions and hashes with reference manifest. | Six exact masters exist under project DAM; five are referenced; Falcon is explicitly unused; provenance/rights gap recorded. |
| TC-022 | auditron | US-001, US-008, US-009 | Scan source/content/clientlibs and local page network references for reference/source domains, Downloads paths, legacy headings and placeholders. | No runtime hotlink/dependency, local path, duplicate legacy copy, `#` link, or “Please configure”. |
| TC-023 | sentinel | US-009, NFR-performance | Measure real Publish LCP/INP/CLS/TTFB, initial transfer and responsive image requests on desktop/mobile. | LCP≤2.5s, INP≤200ms, CLS≤0.1, TTFB≤800ms, initial transfer≤1.8MB; no 2048px master on narrow phone; only hero eager. |
| TC-024 | sentinel | US-006, NFR-accessibility | Run full axe and manual keyboard/zoom/reflow checks on real Publish. | WCAG 2.1 AA; zero critical/serious axe; visible focus, skip link, landmarks, alternatives, 200% zoom and 320px reflow pass. |
| TC-025 | sentinel | US-009, NFR-seo | Inspect real Publish response/head/crawlability/canonical/OG and author-chrome absence. | 200 indexable SSR HTML; unique title/description, one h1, canonical, OG basics, crawlable links, no author chrome/mixed content. |
| TC-026 | sentinel | US-006, US-009 | Execute all UI IDs in Chromium/Firefox/WebKit plus mobile emulation on real tiers. | 100% scenarios attributed/executed with no browser-specific functional or serious visual regression. |
| TC-027 | auditron | US-007, US-009 | Validate FileVault filters, package inclusion, clientlib imports, TypeScript/SCSS static checks and one-spec-per-UI-ID Playwright source. | No orphan/missing file; Playwright replaces Cypress for Cloud Manager; exactly one runnable spec per UI ID. |
| TC-028 | sentinel | US-007, US-008 | On authenticated Author, open page and both XF masters, confirm editable surfaces and preview styles. | Hero/editorial/header/footer are authorable in intended contexts; no per-page chrome override; no unconfigured public placeholder. |
| TC-029 | auditron | US-004, US-005, NFR-security | Inspect link sanitization/target behavior and frontend strings/scripts. | Authored URLs are safely escaped; target-new external links have noopener+noreferrer; no inline secret/script or hard-coded translatable JS label. |
| TC-030 | auditron | US-001, Q-002 | Scan seeded nodes and rendered local DOM for excluded branch headings/text and duplicate footer/legal nodes. | Only current hero + four editorial nodes + one footer exist; legacy “Protection around the globe”/“We win as one” and 2023 row are absent. |

## Requirement traceability

| Requirement | Allocated TC IDs |
| --- | --- |
| US-001 | TC-010, TC-022, TC-030 |
| US-002 | TC-007, TC-008, TC-009 |
| US-003 | TC-010, TC-011, TC-012, TC-013, TC-014, TC-015 |
| US-004 | TC-004, TC-016, TC-017, TC-029 |
| US-005 | TC-005, TC-018, TC-019, TC-029 |
| US-006 | TC-007, TC-009, TC-015, TC-017, TC-019, TC-024, TC-026 |
| US-007 | TC-003, TC-006, TC-020, TC-027, TC-028 |
| US-008 | TC-001, TC-002, TC-021, TC-022, TC-028 |
| US-009 | TC-022, TC-023, TC-025, TC-026, TC-027 |

## Source-oracle traceability

| Source item | Test case IDs |
| --- | --- |
| SRC-001 | TC-004, TC-016 |
| SRC-002 | TC-004, TC-016 |
| SRC-003 | TC-004, TC-016 |
| SRC-004 | TC-017 |
| SRC-005 | TC-007, TC-008 |
| SRC-006 | TC-008, TC-009 |
| SRC-007 | TC-010 |
| SRC-008 | TC-010 |
| SRC-009 | TC-012 |
| SRC-010 | TC-010 |
| SRC-011 | TC-010 |
| SRC-012 | TC-010 |
| SRC-013 | TC-010 |
| SRC-014 | TC-010, TC-013 |
| SRC-015 | TC-010, TC-013 |
| SRC-016 | TC-010, TC-013 |
| SRC-017 | TC-010, TC-013 |
| SRC-018 | TC-005, TC-018, TC-019 |
| ASSET-001 | TC-008, TC-009, TC-021 |
| ASSET-002 | TC-021 |
| ASSET-003 | TC-011, TC-021 |
| ASSET-004 | TC-011, TC-021 |
| ASSET-005 | TC-011, TC-021 |
| ASSET-006 | TC-011, TC-021 |
