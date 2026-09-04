# Blockwright policy handoff

Config fallback: `.aem-skills-config.yaml` is absent; implementation uses the approved POM-derived `adlc-crowdstrike` and `com.adlccrowdstrike` identifiers.

Configsmith policy definitions required: `page/racing-page`; containers `racing-root`, `racing-main`, `racing-hero-slot`, `racing-editorial-slot`, `racing-band`; teaser `racing-hero`, `racing-editorial`; XF `racing-header`, `racing-footer`. The corresponding template pointers are in `racing-page/policies/.content.xml`.

The complete immutable template subtree is `ui.content/src/main/content/jcr_root/conf/adlc-crowdstrike/settings/wcm/templates/racing-page/`; allowed-template registrations are retained at the project, US, and EN roots. Composer owns mutable page/XF content and Configsmith owns policy definitions.

Numeric style IDs: hero `20260902001`; editorial base `20260902002`; content-first `20260902003`; media-first `20260902004`; light `20260902005`; dark `20260902006`; full bleed `20260902011`; content width `20260902012` and `20260902013` as specified by Designforge. All allowlists must be exact resource types from `policy-mapping.md`; no broad groups or `*`.
