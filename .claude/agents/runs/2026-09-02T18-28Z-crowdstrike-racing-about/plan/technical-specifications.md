# Technical specifications — CrowdStrike Racing About page

## Chosen architectural pattern

Use server-rendered AEM Sites with HTL and JCR-authored component properties. This page is SEO-critical, has a conventional authored page layout, and requires no shared headless content or browser-side application state. Content Fragments, GraphQL, SPA rendering, and Universal Editor would add delivery and authoring complexity without a source-backed need.

The public target is /content/adlc-crowdstrike/us/en/about-us, rendered through a new racing-page editable template. The new template retains project Experience Fragment chrome and the project Container proxy, but omits the existing page-content template's always-present standalone title so the hero owns the page's only h1.

The URL is both content-source-of-truth and visual reference. No HTML/CSS/JavaScript is transplanted. Long copy is transcribed from the primary source branch named in source-content-inventory.md; the supplied images are ingested into project DAM.

## Project/config status

.aem-skills-config.yaml is absent. Per the dispatch decision, identifiers are derived from Maven:

- project/package: adlc-crowdstrike
- Maven group and Java root: com.adlccrowdstrike
- existing component group label: ADLC Crowdstrike - Content

This is non-blocking and is recorded in requirements.yaml. The repository already has Core Component proxies, Experience Fragment chrome, an editable-template base, a project Container proxy, and a webpack SCSS build.

## Module and package impact

| Module | Planned impact |
| --- | --- |
| ui.apps | Add atomic site-header and site-footer component definitions/HTL/dialogs if Designforge confirms the fields; add racing-page editable-template/policy definitions or immutable policy updates in the project's established location; extend project component proxies only |
| core | Only if coherent header/footer data shaping cannot be expressed safely in HTL; add focused Sling Models and unit tests, with no service resolver or external call |
| ui.frontend | Replace archetype visual defaults for this feature with tokenized base/chrome/Teaser-variant SCSS and minimal accessible menu TypeScript; import partials through main.scss/main.ts |
| ui.content | Seed /content/adlc-crowdstrike/us/en/about-us, both chrome Experience Fragment content updates, and all six DAM fixtures plus metadata/manifest evidence |
| ui.config | No OSGi configuration expected; Configsmith records a security review and validates that no service user/secret is needed |
| dispatcher | No route rewrite is required; Configsmith assesses publish allow-listing, HTML/image caching, headers, and canonical delivery without broadening unsafe filters |
| ui.tests | Migrate the archetype Cypress harness to Playwright before release if it is still Cypress; author scenarios derived from Designforge IDs for Publish and Author |
| it.tests | Add or adapt integration assertions only where useful for page/resource availability and semantic HTML; Auditron owns execution |

Immutable definitions under /apps and /conf remain developer-owned. Mutable page, DAM, and Experience Fragment content remain in ui.content with author-safe merge semantics. Re-seed verification must account for FileVault merge not overwriting nodes that already exist.

## Component strategy and reuse triage

| Reference block | Classification | Target | Rationale |
| --- | --- | --- | --- |
| Header | C — one custom component | adlc-crowdstrike/components/site-header inside header EF | Logo, nested nav, current state, mobile control, and accessibility behavior are one atomic authoring concern; assembling Image + Navigation + utility fragments would violate the 1:1 rule |
| About hero | A — Style System variant | existing adlc-crowdstrike/components/teaser → Core Teaser v2 | Core image, title, and content wrapper support a CSS overlay and semantic h1 without HTL override |
| We Stop Breaches | A — Style System variant | existing project Teaser, editorial-split content-first | Core image/title/description/action slots exactly cover the section |
| Why We Race | A — Style System variant | existing project Teaser, editorial-split media-first | Core image/title/rich description slots exactly cover the section; CSS reverses visual columns |
| CrowdStrike Racing by APR | A — Style System variant | existing project Teaser, editorial-split content-first | Core image/title/description are sufficient |
| No. 4 CrowdStrike Oreca 07 | A — Style System variant | existing project Teaser, editorial-split media-first | Core rich description can emit the paragraph and semantic list; Designforge confirms RTE list policy |
| Footer | C — one custom component | adlc-crowdstrike/components/site-footer inside footer EF | Grouped link columns, social destinations, brand art, and legal row are one coherent authoring model not represented by one Core dialog |
| Page/layout bands | A — existing proxy | adlc-crowdstrike/components/container | Project container supplies full-width backgrounds and constrained inner rhythm; never use foundation responsivegrid |

### Core Teaser DOM visual-fit check

Core Teaser v2 emits an outer decoration wrapper carrying the Style System class and an inner .cmp-teaser containing .cmp-teaser__image and .cmp-teaser__content; content then exposes pretitle/title/description/action elements. SCSS must target:

1. the decoration class plus descendant .cmp-teaser for grid/flex/overlay;
2. .cmp-teaser__image and .cmp-teaser__content for the two panes;
3. canonical title/description/action classes, after Blockwright verifies the Core Component version's emitted markup.

The hero needs only image/content overlay. Editorial rows need only two-column grid and reversible visual order. No section requires an element Core Teaser cannot emit, so classification A passes both the field-set and visual-fit tests. Do not overlay Teaser HTL or invent custom Sling Models for those blocks.

Style classes must be defined together in the one mapped Teaser policy for this template context. Content cq:styleIds must resolve through that policy; classes are expected on the outer decoration wrapper, not directly on .cmp-teaser.

### Planned style variants

- racing-hero
- racing-editorial-split
- racing-editorial-content-first
- racing-editorial-media-first
- racing-surface-light
- racing-surface-dark

Designforge may consolidate these into style groups but must preserve composability and one policy per component type/context.

### Deviations from project defaults

There are no deviations from S1-S6/S8/S9:

- header/footer remain Experience Fragments;
- the template parsys uses the project Container proxy;
- every content path parent is cq:Page;
- template registration covers project, country, and locale roots;
- teaser-pattern blocks use Core Teaser variants after a documented visual-fit check;
- atomic header/footer use one custom component each;
- the reference was deconstructed before architecture.

## Template strategy

Create /conf/adlc-crowdstrike/settings/wcm/templates/racing-page based on the existing page template type and project Page proxy.

Structure:

1. Experience Fragment component referencing /content/experience-fragments/adlc-crowdstrike/us/en/site/header/master.
2. Main adlc-crowdstrike/components/container with one editable child container/parsys, no locked standalone page-title component.
3. Experience Fragment component referencing /content/experience-fragments/adlc-crowdstrike/us/en/site/footer/master.

Allowed body components are intentionally narrow: project Teaser and project Container. Project Image/Text/Title may be allowed only if Designforge identifies a legitimate authoring need; they must not fragment one reference editorial section.

Policies:

- Page policy includes existing dependency/site clientlibs.
- Root policy emits main semantics and project spacing styles.
- Teaser policy permits titleType h1 only for hero context or uses a separate nested policy context; editorial items use h2. Designforge/Blockwright must avoid assuming per-instance titleType overrides.
- Image delegation enables Asset Delivery, responsive widths, alt-from-DAM with author override, and lazy loading below the hero.
- Header/footer component policies live in the xf-web-variation template context because page-template policies do not apply inside Experience Fragments.

Template registration paths:

- /content/adlc-crowdstrike
- /content/adlc-crowdstrike/us
- /content/adlc-crowdstrike/us/en

Each relevant jcr:content receives or retains a cq:allowedTemplates expression that includes racing-page. The sample content path must be cq:Page at every segment: /content/adlc-crowdstrike, /us, /en, and /about-us.

## Integration map

| Boundary | Direction | Pattern | Owner | Decision |
| --- | --- | --- | --- | --- |
| Corporate/site destination links | browser outbound navigation | Authored HTTPS link | Composer/Blockwright | Normal links, not an integration |
| Supplied local images → AEM DAM | build-time content seeding | FileVault/DAM fixture packaging | Composer | In-scope content orchestration |

No API, webhook, IDP, MarTech exchange, replication-event outbound flow, or other system boundary exists. Bridgesmith is deliberately not dispatched. Analytics/consent from the source site is not copied.

## Content strategy

Use page-authored JCR properties rather than Content Fragments. Composer owns:

- sample page at /content/adlc-crowdstrike/us/en/about-us;
- header and footer EF content at the existing master variation paths;
- six DAM assets under /content/dam/adlc-crowdstrike/racing/about-us;
- source-filename/hash-to-DAM manifest;
- all canonical primary-branch headings, long copy, CTA, specification list, link destinations, alt metadata, page title, description, canonical/OG values;
- render-readiness proof showing no unresolved asset reference or placeholder.

Composer must preserve cq:Page node types for every intermediate page. It must extend template registration at all three listed content roots. Content package merge mode will not overwrite pre-existing authored nodes, so the seeding report must distinguish first install from re-seed and verify the actual rendered/JCR result.

Falcon-2 is packaged and documented but used only if Designforge approves it in the visible footer/final art. The primary page uses ASSET-001 and ASSET-003 through ASSET-006. Remote image endpoints are provenance evidence only.

## Responsive and visual system

The existing template defines phone at 768 and tablet at 1200; use those as implementation boundaries unless measured source behavior justifies a documented adjustment.

- Desktop ≥1200: full navigation, panoramic hero, alternating near-50/50 editorial rows, multi-column footer.
- Tablet 768-1199: preserve two columns only when both panes remain at least 320px; otherwise stack without squeezing copy or losing the vehicle focal point.
- Phone <768: accessible menu control, stacked hero/editorial flow, 20-24px gutters, 44px targets, one-column footer.
- Validate at 1440×900, 768×1024, and 390×844, with fluid overflow checks 320-1920px.

Designforge owns the exact measured design tokens. The corporate gateway prevented current computed-style capture, so reference-assets.md distinguishes observed values from inferred recommendations. This limitation does not alter the component architecture.

## NFR strategy

| NFR | Target/mitigation | Owner |
| --- | --- | --- |
| Performance | LCP ≤2.5s, INP ≤200ms, CLS ≤0.1, TTFB ≤800ms; eager responsive hero, lazy below-fold images, intrinsic ratios, no source hotlinks, initial transfer target ≤1.8MB | Sentinel with Blockwright/Composer remediation |
| Accessibility | WCAG 2.1 AA; deep axe plus keyboard/menu/focus/landmark/heading/contrast/reflow checks | Sentinel |
| SEO | Server-rendered indexable Publish HTML; canonical, unique title/description, one h1, logical h2s, OG basics, crawlable link names | Sentinel |
| Security | No secrets/service resolver/raw scripts; safe external link attributes; Dispatcher/header/cache assessment | Configsmith |
| Compatibility | Chromium, Firefox, WebKit and mobile emulation; 320-1920px | Sentinel |
| Authoring | Dialog validation, policy resolution, style class rendering, asset picker, responsive preview, no placeholder chrome | Auditron/Sentinel |
| Build/quality | Unified cross-file review, unit/integration tests, Cloud Service build within exactly two Maven calls maximum | Auditron |

## Accessibility design requirements

- Header, main, footer landmarks and a first-focusable skip link.
- Exactly one h1 in the hero; four h2 editorial headings.
- Site-header menu works by button click and keyboard, reports aria-expanded/controls, closes with Escape/outside activation, and restores focus.
- Focus indication remains visible against dark, red, and photographic surfaces.
- Body text and controls meet 4.5:1 where applicable; large display text meets 3:1.
- Informative racing photos use concise contextual alt; ambient Falcon artwork is decorative.
- Visual CSS ordering must not create a keyboard/screen-reader sequence that contradicts meaning.
- Motion is limited to menu transition and optional subtle reveal; prefers-reduced-motion disables nonessential animation.

## SEO/content metadata

Composer authors a source-faithful page title and meta description without inventing racing results beyond the source. Use ASSET-001 or an approved rendition as og:image. Canonical target resolves to the final public About URL after deployment. Do not add Event/SportsTeam schema without verified structured facts and site convention.

## Risks and mitigations

| Risk | Impact | Mitigation | Owner |
| --- | --- | --- | --- |
| Corporate gateway blocked exact CSS/computed-style capture | False precision or visual drift | Designforge performs approved-browser token capture; frozen measurements supersede inferred values, while layout/component contracts stay fixed | Designforge/Sentinel |
| Crawl exposes legacy duplicate branch | Duplicate/stale content | Seed only primary 2026 branch; browser-capture proof before design; assert one footer and four editorial sections | Composer/Auditron/Sentinel |
| Large PNG masters | LCP/transfer regression | DAM masters plus responsive modern renditions; high-priority hero only; lazy remaining media | Composer/Blockwright/Sentinel |
| Hero crop at phone width | Subjects or title contrast lost | Preserve authored focal point; allow stacked fallback rather than severe crop | Designforge/Blockwright/Sentinel |
| Style System class attached to outer wrapper | Variants silently fail | Target descendant emitted DOM and validate cq:styleIds against the mapped policy | Blockwright/Auditron |
| Teaser title type policy shared across contexts | Multiple h1 or wrong headings | Map hero and editorial Teasers through distinct policy contexts or template nesting; verify rendered headings | Designforge/Blockwright/Auditron |
| XF policy-context mismatch | Header/footer render unstyled | Map styles/policies in xf-web-variation context and target emitted XF node-name modifier | Blockwright/Auditron |
| Mutable merge does not update an existing page | Demo appears stale | Record merge/update behavior and verify installed JCR/rendered markers; never broadly replace author content | Composer/Auditron |
| Custom chrome grows into page-specific logic | Maintenance burden | Keep components presentation/content only; no external calls; reuse across the site EF masters | Designforge/Blockwright |
| Asset rights/credit unknown | Production legal risk | Preserve provenance and obtain human rights confirmation before public launch; do not invent credit | Human |

## Best-practices validation

The proposal was checked with the repository best-practices skill and its Style System/DOM/deploy contract:

- no deprecated API, administrative resolver, scheduler, listener, Replicator, or DAM AssetManager code is proposed;
- Core proxies and HTL are used for page rendering;
- Style System wrapper placement and Core Teaser canonical properties are explicit;
- .aem-Grid clearfix pseudos must be disabled if any container grid is converted to CSS grid/flex;
- XF policies are mapped in the XF template context;
- FileVault mutable merge behavior is accounted for;
- no Maven invocation occurs in Plan, Design, Implement, Integrate, or Sentinel.

## Traceable test requirements

Designforge must create scenario IDs that cover:

1. SRC-001 through SRC-004 header labels, hierarchy, current state, desktop menu, mobile menu, keyboard and Escape.
2. SRC-005/SRC-006/ASSET-001 hero identity, single h1, focal crop, contrast, and LCP behavior.
3. SRC-007 through SRC-017 and ASSET-003 through ASSET-006, including order, image identity, normalized text facts, CTA destination, semantic specifications, and responsive alternation/stacking.
4. SRC-018 footer groups, one footer DOM, legal/link identity, keyboard focus, and responsive collapse.
5. Author tier: component dialogs, Teaser style choices, DAM pickers, header/footer EF content, and no unconfigured placeholder.
6. Publish tier: no author chrome, no remote image dependency, canonical/metadata, HTTP cacheability, WCAG/SEO/Lighthouse targets.
7. Asset identity: Composer manifest hashes equal reference-assets.md and every primary component fileReference resolves under project DAM.

Blockwright authors the Playwright harness/spec source pre-deploy. Auditron lists/builds/tests and produces the unified gate. Sentinel executes 100% of scenarios against the real Author and Publish URLs after the manual deploy.

## Out of ADLC scope

- Lead review/merge, sync to Adobe Git, and real Cloud Manager deployment are manual external steps after Pilot raises the PR.
- Cloud Manager Dev/Stage/Prod promotion sequencing, rollback, incident response, postmortems, and ongoing operations are not work-breakdown agent tasks.
- Rights approval for supplied imagery is a human responsibility.
- Implementation of linked destination pages and source-site analytics/consent is not included.

## Work breakdown

1. {stage: plan, agent: strategist, task: canonicalize source/content/assets and define AEM architecture, inputs: [dispatch/01-strategist.md, live reference, local assets], expected_artifact: plan/requirements.yaml + plan/technical-specifications.md + plan/source-content-inventory.md + plan/reference-deconstruction.md + plan/reference-assets.md}
2. {stage: gate, agent: human, task: approve architecture, source-branch decision, component reuse triage, and rights-risk acknowledgement, inputs: [handoffs/strategist.yaml], expected_artifact: DECISIONS.md architecture_review approval}
3. {stage: design, agent: designforge, task: measure the approved live reference and produce component/dialog/template/policy/authoring/functional/Playwright specifications, inputs: [all plan artifacts, architecture approval], expected_artifact: handoffs/designforge.yaml and complete design pack}
4. {stage: gate, agent: human, task: approve dialog and design specifications, inputs: [handoffs/designforge.yaml], expected_artifact: DECISIONS.md dialog_spec_confirmation approval}
5. {stage: implement, agent: blockwright, task: implement racing-page template, Teaser variants, atomic site chrome, frontend behavior/styles, unit tests, and Playwright harness/spec source, inputs: [design pack, dialog approval], expected_artifact: handoffs/blockwright.yaml}
6. {stage: implement, agent: configsmith, task: perform security hardening and Dispatcher/CDN assessment; implement only source-backed config changes, inputs: [design pack, requirements.yaml], expected_artifact: handoffs/configsmith.yaml}
7. {stage: integrate, agent: composer, task: seed cq:Page hierarchy, About page, Experience Fragment chrome content, DAM fixtures, metadata, and render-readiness evidence, inputs: [design pack, source-content-inventory.md, reference-assets.md], expected_artifact: handoffs/composer.yaml + integrate/composer/dam-fixture-manifest.yaml}
8. {stage: test, agent: auditron, task: unified code/content/config review and Build Validation Gate within its exclusive two-Maven-call budget, inputs: [handoffs/blockwright.yaml, handoffs/configsmith.yaml, handoffs/composer.yaml, design scenarios], expected_artifact: handoffs/auditron.yaml}
9. {stage: release, agent: pilot, task: raise PR (feature branch -> master), inputs: [handoffs/auditron.yaml], expected_artifact: deploy/pr-request.md}
10. {stage: gate, agent: human, task: Lead: review/merge PR, deploy to real env, then record real-environment validation approval in DECISIONS.md, inputs: [handoffs/pilot.yaml], expected_artifact: DECISIONS.md real-environment validation approval block (Author URL + Publish URL + auth modes)}
11. {stage: test, agent: sentinel, task: execute all Playwright, visual-reference, a11y, performance, SEO, authoring, and observability scenarios against the REAL Author and Publish URLs (LAST stage), inputs: [DECISIONS.md, handoffs/auditron.yaml, design scenarios, plan reference oracles], expected_artifact: handoffs/sentinel.yaml}

Implementation fan-out is [blockwright, configsmith, composer]. Bridgesmith is omitted because there is no external system boundary. Auditron waits for all three. Pilot follows a passing Auditron gate automatically. Sentinel is terminal and cannot run until the Lead records both real URLs/auth modes.

