agent: sentinel
stage: Test — UI and NFR enforcement (terminal)
input-packet: |
  You are Sentinel for ADLC run `2026-09-02T18-28Z-crowdstrike-racing-about`. This is the terminal post-deploy validation. Read and follow `.claude/agents/sentinel.md`, all run Plan/Design/Test artifacts, `DECISIONS.md`, `handoffs/auditron.yaml`, `handoffs/blockwright.yaml`, `handoffs/composer.yaml`, and `AGENTS.md`. Do not modify product implementation, the UI harness, or release/PR state. Execute and report only.

  Real environment approval context (recorded in `DECISIONS.md`):
  - build: `c9d960e9f9f6b314133a8441fa4bc0d4723b4c35`
  - Author URL: `https://author-p185256-e1945105.adobeaemcloud.com`; auth mode: bearer-token
  - Publish URL: `https://publish-p185256-e1945105.adobeaemcloud.com`; auth mode: none

  The Author bearer token is in the repository-local `.env`. Never print, read into an artifact, commit, or expose it. Load it only into the executing process environment and use it only as an Authorization Bearer header for Author probes. If the expected token value cannot be safely bound from `.env`, do not request or reveal the value; mark only Author-dependent cases `blocked_missing_credential` with no secret in logs. Do not use the author host for Publish-tier tracks.

  Pre-probe Author and Publish independently, then execute every applicable track against its prescribed tier. This server-rendered run has no Content Fragments/GraphQL or SPA consumer, so report those two tracks `not_applicable` with source-backed per-track reasoning. All other tracks are required:
  - execute the existing Playwright harness/specs against Publish for every `UI-001..UI-020`, all configured desktop browsers plus mobile emulation; verify harness is Playwright and no Cypress remains, but do not scaffold/migrate it;
  - run Publish Lighthouse baseline, authoritative axe checks, deep SEO (including robots/sitemap/OG/JSON-LD), observability, and reference/visual alignment using the non-empty Designforge reference manifest and supplied-image mapping;
  - run Author authoring-provision cases `AUTH-001..AUTH-016`, including dialog/model parity, multifields, stored values, asset references, edit round-trip, and publish state; use Publish only for the activation portion;
  - mechanically census and execute every Sentinel-owned `TC-*` case, honoring Auditron's evidence and creating a complete coverage matrix.

  Execute baseline coverage in full; never reduce it based on changed files. Capture Publish desktop/mobile screenshots for visual Tier A and a Tier B baseline once Tier A passes. Do not report a reference/visual source as unavailable merely because it needs URL or file ingestion. Do not claim a pass for a blocked, skipped, or unexecuted test.

  Write the required consolidated `test/sentinel/sentinel-report.md` and `sentinel-report.html`, one full `coverage-matrix.md`, reference extracts/screenshots/raw drill-down artifacts as appropriate, and `handoffs/sentinel.yaml`. The report must carry secrets only as auth modes. If any finding fails, report its true severity/class and proposed owner but DO NOT fix or trigger re-dispatch; the Program Agent will stop for human remediation approval.
expected-handoff: C:\AEM\Repos\adlc-crowdstrike\.claude\agents\runs\2026-09-02T18-28Z-crowdstrike-racing-about\handoffs\sentinel.yaml
gate-criteria: |
  Both real tiers are independently probed with the correct auth modes; every applicable UI, Authoring, Sentinel-owned functional, NFR, a11y, SEO, observability, reference-parity, and visual ID/track is executed and reported; coverage census totals reconcile; all required terminal reports/artifacts exist; and Sentinel returns its actual terminal pass/fail verdict without secret exposure.
