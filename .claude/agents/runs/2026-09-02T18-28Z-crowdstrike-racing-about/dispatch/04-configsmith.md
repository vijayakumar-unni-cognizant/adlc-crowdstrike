agent: configsmith
stage: Implement
input-packet: |
  You are Configsmith for approved ADLC run `2026-09-02T18-28Z-crowdstrike-racing-about`. Execute the mandatory security review and policy/Dispatcher/CDN hardening for a public AEM Sites About page. Work concurrently with Blockwright and Composer; preserve their changes and do not write their owned code/component/template/content/DAM paths.

  Read and exactly follow `.claude/agents/configsmith.md`, `AGENTS.md`, `CLAUDE.md`, the full Designforge pack, Strategist technical specification, and `DECISIONS.md`. The POM-derived project is `adlc-crowdstrike` / `com.adlccrowdstrike`; `.aem-skills-config.yaml` is absent. Record this non-blocking configuration fallback, then proceed without inventing deployment hosts or secrets.

  Inputs:
  - `.../handoffs/designforge.yaml`
  - `.../design/template-design.md`, `policy-mapping.md`, `component-specifications.md`, `dialog-specifications.md`, and `functional-test-cases.md`
  - `.../plan/technical-specifications.md`
  - when available in the shared worktree, `implement/blockwright/handoff-notes.md` and template policy mapping (consume, do not edit Blockwright-owned files).

  Your ownership is the consolidated policy definitions under `ui.content/**/conf/adlc-crowdstrike/settings/wcm/policies/`, any strictly required `ui.config` Externalizer configuration, and dispatcher/CDN configuration only where source-backed and safe. Blockwright owns template policy mappings; Composer owns page/DAM/XF instances.

  Use `security-review` and the applicable `dispatcher`/`repoinit` skills. There is no service user, external API, secret, vanity path, or custom dispatcher route in the approved design: do not manufacture one. Perform the full branch/diff security review anyway. Provision the consolidated policy nodes required by Designforge and Blockwright: exactly resolvable page/clientlib, container, Core Teaser Style System (all approved variants in one policy), and Experience Fragment policy definitions with numeric style IDs. Ensure every Blockwright policy pointer can resolve; preserve least privilege and forbid broad allowlists. Confirm no `loginAdministrative`, plaintext secret, or missing mapper exists.

  SEO is in scope. Check whether an existing safe Externalizer publish mapping already supports absolute canonicals. Do not invent a production hostname; if absent, document it as an environment-owned configuration follow-up rather than adding a fabricated domain or duplicate canonical markup. Validate Dispatcher locally only when an SDK/config is actually present and no external install is required; record skipped/not-applicable evidence precisely, never falsely claim green.

  Do not run Maven. Write `implement/configsmith/security-review.md`, any validation report, and `handoffs/configsmith.yaml` containing complete tracks, findings, policy-resolution proof, and an explicit clean/pending status. High findings may not be hidden; if any cannot be fixed inside your ownership, state it clearly for Program Agent gate handling.
expected-handoff: C:\AEM\Repos\adlc-crowdstrike\.claude\agents\runs\2026-09-02T18-28Z-crowdstrike-racing-about\handoffs\configsmith.yaml
gate-criteria: |
  Security review has no unaccepted high finding; no unsafe service-user/secret/admin-session pattern is introduced; all template-referenced policy definitions exist and contain correct clientlibs/style groups/style IDs; dispatcher/CDN validation is passed or accurately scoped where no relevant SDK/config exists; no production hostname is fabricated; and a complete handoff/report exists.
