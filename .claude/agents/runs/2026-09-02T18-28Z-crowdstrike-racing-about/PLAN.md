# ADLC plan — CrowdStrike Racing About page

Run ID: `2026-09-02T18-28Z-crowdstrike-racing-about`  
Dispatch mode: co-orchestration

## Objective

Create a production-ready, responsive AEM Sites page that faithfully implements the public visual and content design at `https://crowdstrikeracing.com/about-us/`, using the supplied local images where they map to the reference. The deliverable must preserve authorability, accessibility, responsive layout quality, and AEM as a Cloud Service conventions.

## Project context

- Project/package/group: `adlc-crowdstrike` / `adlc-crowdstrike` / `com.adlccrowdstrike` (derived from Maven POMs; `.aem-skills-config.yaml` is absent).
- Local reference assets: `C:\Users\2489691\Downloads\crowdstrike-images`.
- Source of truth for visual/content extraction: `https://crowdstrikeracing.com/about-us/`.
- Rendering pattern to be decided by Strategist; the expected default is authored, server-rendered AEM Sites components unless the source analysis identifies a justified alternative.

## Execution graph

1. **Plan — Strategist (required):** independently inspect the live source and asset folder; create canonical requirements, source-content inventory, reference asset mapping, AEM architecture, reuse/new assessment, responsive/accessibility/NFR requirements, and work breakdown.
2. **Architecture checkpoint — human:** Program Agent presents Strategist’s architecture/component plan before dispatching Designforge.
3. **Design — Designforge (required):** transform the approved inventory into implementation-ready component, dialog, template/policy, authoring, functional, authoring, and UI/visual test specifications.
4. **Dialog checkpoint — human:** Program Agent presents the design pack before implementation.
5. **Implement/integrate fan-out:** Blockwright owns components/templates/frontend/Playwright harness; Configsmith performs mandatory hardening/security/dispatcher assessment; Composer owns image/DAM fixture mapping and the authored sample page. Bridgesmith is omitted only if Strategist confirms no system boundary.
6. **Test — Auditron (required):** unified review, unit/integration/build gate, within its exclusive two-Maven-call budget.
7. **Release — Pilot (required):** raise a PR to `master`; the run pauses for the Lead’s manual merge/deploy.
8. **Real environment checkpoint — human:** Lead supplies the deployed Author and Publish URLs plus auth modes.
9. **Test — Sentinel (required, terminal):** execute Playwright, reference-alignment, accessibility, performance, SEO, observability, and authoring verification against the real environment.

## Constraints and acceptance criteria

- The source page’s hierarchy, headings/copy, imagery, visual tokens, grid/rhythm, interaction cues, and behavior at desktop/tablet/mobile are captured before design or code.
- Local assets are mapped by filename/dimensions/content rather than replaced by remote hotlinks; DAM references must resolve under the project’s content package.
- Source analysis must produce a canonical inventory for later test oracles—no downstream agent may self-author its own expected source content.
- The implementation is modular and authorable, uses AEM Core Components where suitable, and has semantic HTML/keyboard/a11y support.
- Auditron exclusively owns no more than two Maven invocations. No specialist other than Auditron invokes Maven.
- The terminal Sentinel gate cannot run until a human provides real Author and Publish environment details after PR/deploy.

## Planned specialists

| Sequence | Specialist | Status | Reason |
| --- | --- | --- | --- |
| 01 | Strategist | pending | Required canonical source/architecture handoff |
| 02 | Designforge | pending approval | Required implementation-ready design pack |
| 03 | Blockwright | pending approval | Components, template, frontend, Playwright harness |
| 04 | Configsmith | pending approval | Mandatory AEMaaCS security/dispatcher review |
| 05 | Composer | pending approval | DAM mappings and authored sample page |
| conditional | Bridgesmith | awaiting Strategist | Only if a system boundary exists |
| 06 | Auditron | pending | Required build/code/test gate |
| 07 | Pilot | pending | Required PR creation and pause |
| 08 | Sentinel | pending real environment | Required terminal real-environment validation |

