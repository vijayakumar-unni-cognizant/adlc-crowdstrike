agent: strategist
stage: Plan
input-packet: |
  You are the Strategist for ADLC run `2026-09-02T18-28Z-crowdstrike-racing-about`.

  Objective: plan an AEM as a Cloud Service implementation of a responsive About page faithfully matching https://crowdstrikeracing.com/about-us/. The user explicitly wants the reference URL autonomously inspected for structure, visual system, typography, spatial rhythm, responsive behavior, textual hierarchy, content, and modular layout. The user supplied image assets at C:\Users\2489691\Downloads\crowdstrike-images and expects them to be mapped to the correct page regions.

  Read and follow `.claude/agents/strategist.md`, `.claude/agents/ADLC-SPEC.md`, `AGENTS.md`, and `CLAUDE.md`. Do not invoke Maven and do not write production code. You are not alone in the codebase: preserve unrelated work and write only the planning/run artifacts you own.

  Project identifiers: project/package `adlc-crowdstrike`; group `com.adlccrowdstrike`. `.aem-skills-config.yaml` is absent; document this non-blockingly and use the POM-derived identifiers.

  Inspect the live source directly, including desktop and mobile views where feasible. Do not rely on a later designer to recreate an undocumented impression. Extract exact user-visible content into a canonical source inventory with source locations/section IDs; inspect computed design cues where available (fonts or suitable fallbacks, colors, widths, spacing, borders, image treatments, nav/footer scope, and breakpoints). Record all known assets and map supplied local files by their actual content/dimensions; do not plan remote hotlinking. Include `design/reference-assets.md` or an equivalent explicit input for later Designforge/Sentinel reference alignment, plus `plan/source-content-inventory.md` for Auditron’s independent verification oracle.

  Inspect the existing project before proposing changes. Prefer AEM Core Components and an authorable server-rendered Sites pattern unless a source-backed reason requires another pattern. Explicitly decide whether any external system boundary exists; only then recommend Bridgesmith. Include whether the requirements call for sample AEM content/DAM seeding (Composer is expected for this visual page). Make the proposed component list and reuse-vs-new reasoning specific enough for the architecture checkpoint.

  Write required outputs under `.claude/agents/runs/2026-09-02T18-28Z-crowdstrike-racing-about/plan/`, including at minimum `requirements.yaml`, `technical-specifications.md`, `source-content-inventory.md`, and any reference/asset inventory needed for downstream visual validation. Include work breakdown, source asset-to-DAM mapping plan, accessibility/SEO/performance risks, acceptance criteria across mobile/tablet/desktop, and traceable test requirements. Then write the required handoff YAML at the expected path with status and artifact pointers.
expected-handoff: C:\AEM\Repos\adlc-crowdstrike\.claude\agents\runs\2026-09-02T18-28Z-crowdstrike-racing-about\handoffs\strategist.yaml
gate-criteria: |
  Requirements and technical specifications exist, are internally consistent, name the target rendering pattern and component/reuse choices, enumerate source-derived acceptance criteria, document source-content and local-asset inventories usable as independent test oracles, and identify no unresolved blocking architecture risk. The Program Agent must then obtain human architecture approval before Designforge.
