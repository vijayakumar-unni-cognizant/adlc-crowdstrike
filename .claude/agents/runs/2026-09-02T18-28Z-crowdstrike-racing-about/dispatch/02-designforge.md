agent: designforge
stage: Design
input-packet: |
  You are Designforge for approved ADLC run `2026-09-02T18-28Z-crowdstrike-racing-about`.

  The user wants a clean, responsive, production-ready AEM page faithfully matching https://crowdstrikeracing.com/about-us/ across desktop, tablet, and phone. The architecture checkpoint has been explicitly approved. You own the implementation-ready DESIGN PACK ONLY: do not modify production source, content packages, Java, HTL, dialog XML, SCSS, TypeScript, or tests. You are not alone in the repository; preserve unrelated changes and write only the run design artifacts and your handoff.

  Read and follow `.claude/agents/designforge.md`, `.claude/agents/ADLC-SPEC.md`, `AGENTS.md`, `CLAUDE.md`, the complete plan directory, Strategist handoff, and `DECISIONS.md`. The project identifiers are `adlc-crowdstrike` / `com.adlccrowdstrike` (POM-derived because `.aem-skills-config.yaml` is absent).

  Authoritative upstream inputs:
  - `.claude/agents/runs/2026-09-02T18-28Z-crowdstrike-racing-about/plan/requirements.yaml`
  - `.../plan/technical-specifications.md`
  - `.../plan/source-content-inventory.md`
  - `.../plan/reference-deconstruction.md`
  - `.../plan/reference-assets.md`
  - `.../handoffs/strategist.yaml`
  - live content/visual source: https://crowdstrikeracing.com/about-us/
  - local visual fixtures: C:\Users\2489691\Downloads\crowdstrike-images

  Reinspect the live reference before freezing design tokens. Strategist could not obtain computed styles through the corporate gateway: either capture defensible browser/screenshot measurements or clearly label values as observed/inferred with evidence and tolerance. The source URL is a content-source-of-truth: extract verbatim visible text and write `design/source-content-inventory.md` with target-field, source location, exact source value, and fidelity. It must correct/complete the Plan inventory’s intentional long-copy locators rather than treating paraphrases as content. Do not copy source DOM/CSS/scripts. Preserve the approved canonical 2026 branch only—never merge crawler-visible legacy duplicate body/footer markup.

  Produce every standard server-rendered design artifact under `.claude/agents/runs/2026-09-02T18-28Z-crowdstrike-racing-about/design/`:
  1. `component-specifications.md`: explicit contracts for custom atomic site header/footer, Core Teaser hero + editorial Style System variants, Container surfaces, and XF chrome; semantic markup, BEM, accessible navigation, DOM visual-fit, exact desktop/tablet/mobile behaviors, image delivery, responsive crop, and measured spatial/typographic/color token evidence. State required 50:50 desktop split-panel sizing as `flex: 0 0 50%` and `width: 50%` where applicable.
  2. `dialog-specifications.md`: field-by-field authorable dialogs, including header/footer multifields and image handling. Verify ALL Granite resource types against the mandated design references/skills rather than guessing. Explicitly distinguish top-level image file-upload usage from multifield-path usage.
  3. `template-design.md` and `policy-mapping.md`: new racing-page template, locked XF header/main/XF footer, no standalone page Title (hero owns exactly one h1), narrowly allowed project component paths, exact style groups/IDs/contexts, proper XF policy context, and registration at `/content/adlc-crowdstrike`, `/us`, `/en`.
  4. `authoring-guidelines.md`: authored content workflow, style selections, image alt/focal rules, mobile content order, and zero-placeholder/empty-state expectations.
  5. `functional-test-cases.md`, `ui-test-scenarios.md`, and `authoring-test-cases.md`: complete stable ID sets with valid ID-index blocks; traceability to every source/requirement acceptance criterion; each functional case has an executor (`auditron` or `sentinel`); UI scenarios name Author vs Publish tier and fully cover visual layout, keyboard interaction, content mapping, style classes, image identity and responsive viewports. Provide a concrete authoring round-trip/data setup case set.
  6. `reference-assets.md`: carry all supplied/live reference assets forward with field/section mapping and exact-vs-directional matching requirements.

  Ensure Designforge documents the Page architecture approved at the checkpoint: server-rendered AEM Sites; `/content/adlc-crowdstrike/us/en/about-us`; a new `racing-page` editable template; existing project Core Teaser and Container proxy reuse; new atomic header/footer rendered in Experience Fragments; all six images seeded under project DAM by Composer. No external system boundary exists, so no Bridgesmith output is needed. Blockwright must replace Cypress with or create the Playwright harness before deployment, with one spec per UI ID.

  Validate the required design gate yourself. Write `handoffs/designforge.yaml` with status, complete artifact pointers, declared/counted IDs for all three test sets, and an explicit declaration that no code was written. This output will be presented at the mandatory dialog-spec confirmation checkpoint; do not solicit approval or dispatch downstream work yourself.
expected-handoff: C:\AEM\Repos\adlc-crowdstrike\.claude\agents\runs\2026-09-02T18-28Z-crowdstrike-racing-about\handoffs\designforge.yaml
gate-criteria: |
  Full design pack exists, all content-source fields map to exact verified source inventory values, dialog resource types are validated, template/policy/style contexts are implementable, test artifacts have reconciled explicit ID indices with clear executor/tier allocation, the reference asset manifest covers every source input, and the design handoff status is pass. The Program Agent then requires human dialog/spec confirmation before the implementation fan-out.
