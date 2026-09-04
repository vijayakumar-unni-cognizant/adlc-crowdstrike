agent: auditron
stage: Test — Code Quality, Build, and Tests
input-packet: |
  You are Auditron for ADLC run `2026-09-02T18-28Z-crowdstrike-racing-about`. Execute the unified pre-release quality gate. You exclusively own the maximum two Maven calls for this run. This is the only stage permitted to run Maven. Do not run Playwright against a live environment; Sentinel owns post-deploy UI/NFR execution.

  Read and follow `.claude/agents/auditron.md`, `AGENTS.md`, `CLAUDE.md`, the full Designforge pack, all Plan artifacts, the three upstream handoffs, Blockwright's remediation documents, and `DECISIONS.md`. `.aem-skills-config.yaml` is absent; use POM-derived `adlc-crowdstrike` / `com.adlccrowdstrike` and report the fallback non-blockingly.

  Required inputs:
  - `handoffs/blockwright.yaml`, `handoffs/configsmith.yaml`, `handoffs/composer.yaml`
  - `implement/blockwright/handoff-notes.md`, `ui-test-harness.md`
  - `implement/configsmith/security-review.md`, `dispatcher-validation.md`
  - `integrate/composer/content-seeding-report.md`, `dam-fixture-manifest.yaml`
  - all `design/` files, especially `source-content-inventory.md`, `functional-test-cases.md` (30 IDs), `ui-test-scenarios.md` (20 IDs), and `authoring-test-cases.md` (16 IDs)
  - the changed worktree across `core`, `ui.apps`, `ui.content`, `ui.frontend`, and `ui.tests`.

  Known non-blocking follow-ups to aggregate transparently, not hide or fabricate:
  - no real publish hostname was available for an Externalizer mapping, so do not invent one;
  - five legal URLs and icon-only social destination URLs were omitted rather than guessed;
  - local SDK/real-tier rendering evidence has not yet run;
  - supplied-image rights confirmation remains owner-owned.

  First perform the full static review before consuming Maven budget. Independently validate the post-remediation template/policy pointers, policy clientlibs/style groups/numeric style IDs, FileVault namespace/protected-property rules, cq:Page ancestry/depth, DAM real-binary metadata, source-exact authored content versus DESIGNFORGE's independent source inventory, header/footer multifield-to-model/dialog parity, semantic one-H1 policy architecture, image sizing/50:50/grid/XF selector contracts, and all Playwright module migration artifacts. Do not trust a closed-loop expected-payload document as a content oracle. Use actual emitted Core Component v2 DOM evidence/design contract if the internal historical XF-selector examples conflict, and explain the resolution in the report.

  Produce a complete `changed_files.txt`, code-quality report in Markdown and standalone HTML, then obey review gate rules. Any severity high+ finding without an accepted human decision must stop before Maven and return `status: fail`.

  If review passes, execute exactly these two Maven calls (and no other `mvn` command), capturing logs to temp files and returning only tails:
  1. `mvn -q clean install -PautoInstallSinglePackage` — Build Gate call #1. Record exit, all-package zip presence/size, Surefire XML pass state, and local SDK deployment using the three-signal contract.
  2. `mvn -q -pl it.tests verify -Pintegration-tests` against the local SDK when available — integration call #2. If technically impossible after a passing local build, document the concrete reason and submit a fully attributed blocking/incomplete test result; never silently skip it.

  Do not add an additional Maven invocation. Do not call a standalone core test command. Build may also exercise the Playwright module in Cloud Manager-compatible packaging; attribute any failure to its owner.

  Produce `test/auditron/{code-quality-report.md,code-quality-report.html,test-report.md,test-report.html,coverage.md,coverage.html,changed_files.txt}`. Mechanically census the 30 `TC-*` IDs and attribute every one to exactly one bucket with evidence. Auditron must discharge every statically/local-SDK-settleable case; only real publish/author/Dispatcher/CDN properties may be deferred to Sentinel. Put the same complete totals in `handoffs/auditron.yaml`; `mvn_invocations` must equal 2. A PASS requires all gate artifacts, build/test success, coverage gates, and reconciled functional ID totals.
expected-handoff: C:\AEM\Repos\adlc-crowdstrike\.claude\agents\runs\2026-09-02T18-28Z-crowdstrike-racing-about\handoffs\auditron.yaml
gate-criteria: |
  Review has no unaccepted high/critical finding; all cross-file/FileVault/content/Policy/UI-harness checks pass; exactly two Maven calls supply three-signal BUILD_SUCCESS plus passing integration result; every functional TC is reconciled and attributed with evidence; Auditron reports and HTML companions exist; and the Auditron handoff status is pass.
