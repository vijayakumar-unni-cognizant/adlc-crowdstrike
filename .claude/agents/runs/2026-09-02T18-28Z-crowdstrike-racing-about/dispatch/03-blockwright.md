agent: blockwright
stage: Implement
input-packet: |
  You are Blockwright for approved ADLC run `2026-09-02T18-28Z-crowdstrike-racing-about`. The user expects a complete production-ready responsive AEM page matching https://crowdstrikeracing.com/about-us/. Implement your owned code/template/frontend/UI-test surface now. You are working concurrently with Configsmith and Composer: do not revert their edits and do not modify their ownership areas.

  Read and exactly follow `.claude/agents/blockwright.md`, `AGENTS.md`, `CLAUDE.md`, Designforge's complete design pack, Strategist's technical specifications, and `DECISIONS.md`. `.aem-skills-config.yaml` is absent; use the POM-derived project configuration `adlc-crowdstrike` / `com.adlccrowdstrike`, document this non-blocking fallback, and do not create a config file merely to satisfy a guard.

  Authoritative inputs:
  - `.../handoffs/designforge.yaml`
  - `.../design/component-specifications.md`
  - `.../design/dialog-specifications.md`
  - `.../design/template-design.md`
  - `.../design/policy-mapping.md`
  - `.../design/design-token-audit.md`
  - `.../design/ui-test-scenarios.md` (20 IDs, all must receive a tagged Playwright spec)
  - `.../design/functional-test-cases.md` and `authoring-test-cases.md`

  Your exclusive ownership: `core/` Sling Models + unit tests for `site-header` and `site-footer`; `ui.apps/` component definitions/HTL/dialogs for those two atomic components; `ui.frontend/` tokenized CSS/JS; `ui.tests/` Playwright harness/spec source; and the `racing-page` template structure/policy MAPPING only. Configsmith owns the consolidated policy DEFINITIONS under `ui.content/**/settings/wcm/policies`; Composer owns mutable pages, DAM files, and Experience Fragment instances. Coordinate by consuming the design contract; do not write their files.

  Use the components, templates, and ui-tests tracks plus all required skills. Implement exactly the approved server-rendered pattern:
  - custom semantic header/footer components, each one coherent authoring surface with null-safe composite-multifield Sling Models, resource+request adaptable arrays, real unit tests, and `${currentStyle.cssClasses}` on custom wrappers;
  - existing project Core Teaser proxy only for hero/four editorials: no new teaser-like components, HTL, or models; corresponding BEM variant CSS in `_teaser.scss`;
  - Container and XF styling that matches actual Core v2 DOM; no element-only XF selectors; full image-sizing and explicit dark-text contracts;
  - new `racing-page` editable template whose structural page title is absent, with locked header/footer Experience Fragment references and a properly mapped innermost editable container. Use the project container proxy, no foundation responsivegrid.
  - use only numeric style IDs in the authored-content map supplied to Composer. Give Configsmith an exact policy-shape checklist for all page/container/teaser/XF policy nodes and numeric IDs it must provision.
  - at desktop preserve true 50:50 editorial panels (`flex: 0 0 50%`, `width: 50%`); enforce documented stacking/gutters/tokens on tablet/phone and all source image crop/priority behavior.

  Migrate `ui.tests` fully from Cypress if necessary and create the Playwright harness BEFORE deployment. It must have author/publish env parameterization, no host/credentials committed, Cypress completely removed, a spec for every `UI-001` through `UI-020`, and static discovery/parsing success. Do not execute live UI tests.

  Do not run Maven. Run static checks and allowed non-Maven UI-harness parse checks only. If the local SDK is unavailable, record runtime Style-System smoke as skipped with reason; never claim it verified. Follow every B-series FileVault, dialog, selector, image sizing, policy mapping, heading, and UI-harness guardrail in your contract.

  Write `implement/blockwright/handoff-notes.md` (policy requirements for Configsmith) and `ui-test-harness.md`. Write `handoffs/blockwright.yaml` only after all owned changes/static checks complete. Include every required ui_tests field: harness state on entry, `cypress_fully_removed: true`, full ID-to-spec coverage with `unmapped: []`, discovery evidence, `executed: false`, no Maven invocation, and the runtime Style-System result.
expected-handoff: C:\AEM\Repos\adlc-crowdstrike\.claude\agents\runs\2026-09-02T18-28Z-crowdstrike-racing-about\handoffs\blockwright.yaml
gate-criteria: |
  Every specified code/template/frontend artifact exists; custom component dialogs/models are contract-compliant and unit-tested; the template has correct EF chrome, structural-title omission, precise policy mapping, and no broad allowlist; all 20 Playwright scenario IDs map to parseable specs; Cypress is entirely removed; no Maven ran; no high best-practice finding remains; and the handoff includes the required policy contract plus complete UI-test provenance.
