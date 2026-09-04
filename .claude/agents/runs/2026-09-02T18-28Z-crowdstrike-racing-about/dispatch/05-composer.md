agent: composer
stage: Integrate
input-packet: |
  You are Composer for approved ADLC run `2026-09-02T18-28Z-crowdstrike-racing-about`. Seed the production-ready AEM About page, its Experience Fragment chrome content, and supplied DAM fixtures. This is server-rendered Sites work: do NOT introduce Content Fragments, GraphQL, or external integrations. Work concurrently with Blockwright and Configsmith; do not revert their work or edit their owned component/template/policy definitions.

  Read and exactly follow `.claude/agents/composer.md`, `AGENTS.md`, `CLAUDE.md`, the full Designforge pack, and `DECISIONS.md`. `.aem-skills-config.yaml` is absent; use `adlc-crowdstrike` as derived from the POMs and report this fallback. Do not run Maven.

  Canonical content/source inputs:
  - `.../design/source-content-inventory.md` (author all supplied source values verbatim and in their specified rendered role; never use the Plan paraphrase or invented replacement prose)
  - `.../design/reference-assets.md`
  - `.../design/template-design.md`, `authoring-guidelines.md`, `component-specifications.md`, `dialog-specifications.md`, and `policy-mapping.md`
  - supplied asset directory `C:\Users\2489691\Downloads\crowdstrike-images`
  - use shared Blockwright/Configsmith output as it appears to verify exact resource types, template paths, and numeric cq:styleIds; if their required definition is not yet present, do not invent it—record dependency evidence while preparing non-conflicting fixture work.

  Own only mutable content under `ui.content/src/main/content/jcr_root/content/`, including `/content/adlc-crowdstrike/us/en/about-us`, parent cq:Page nodes as necessary, header/footer Experience Fragment instance content, and DAM assets under `/content/dam/adlc-crowdstrike/racing/about-us`. Do not create page-level header/footer overrides because template EFs are authoritative.

  Seed all six local PNG binaries with real metadata and exact dimensions/hashes in the manifest. The primary five must resolve from page components, while `Falcon-2.png` is seeded but remains intentionally unused unless an approved implementation makes it visible. Use correct DAM binary/package representation; never create a dam:Asset node without binary data and never include protected JCR properties. Each raster needs actual `tiff:ImageWidth` and `tiff:ImageLength` metadata. Do not hotlink the source site.

  Seed exactly one semantic custom header and one footer instance in their canonical Experience Fragments using child-node `item0...` multifield storage aligned to the final dialog properties. Seed one Core Teaser per hero/editorial section in the correct editable depth, using only final numeric `cq:styleIds`, source-exact headings/body/CTA/spec list fields, source order, and source-supported URLs. The legal/social destination values Designforge flagged as not source-verifiable must remain an explicit content gap—not placeholders or guessed URLs. Ensure all authored page content has exactly one H1 via policy context, not a per-instance heading workaround.

  Apply every Composer FileVault guardrail: clean namespace declarations, no XML-invalid comment text, update-capable coverage semantics, component/template/DAM reference checks, own numeric style-ID verification, and canonical Content path type/depth. Make only source-backed metadata/SEO fields. Do static stored-value/readback verification where possible; name runtime/deploy validations as pending rather than falsely passing them.

  Write `integrate/composer/dam-fixture-manifest.yaml`, `integrate/composer/content-seeding-report.md`, and `handoffs/composer.yaml`, including precise source fidelity, assets, page/template/component counts, reference resolution evidence, style-ID resolution, any unresolved legal/social URL gap, and a request for Pilot/Auditron to smoke `/content/adlc-crowdstrike/us/en/about-us.html` after package deployment.
expected-handoff: C:\AEM\Repos\adlc-crowdstrike\.claude\agents\runs\2026-09-02T18-28Z-crowdstrike-racing-about\handoffs\composer.yaml
gate-criteria: |
  Mutable page/XF/DAM fixtures exist under correct package roots; all supplied images are present as real binaries with accurate metadata/manifest mapping; each source-derived field is verbatim and placed in its correct role; every template/component/asset/style-ID reference resolves against implementation artifacts; no remote source asset is used; any source gap is explicitly reported rather than invented; and the handoff includes render-readiness/static-integrity evidence.
