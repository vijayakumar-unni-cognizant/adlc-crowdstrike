# Composer content-seeding report

Project fallback: `.aem-skills-config.yaml` is absent, so `adlc-crowdstrike` was derived from the Maven POMs.

Seeded one mutable Sites page at `/content/adlc-crowdstrike/us/en/about-us`, using `/conf/adlc-crowdstrike/settings/wcm/templates/racing-page`. Its five Teasers occupy the template's approved hero/editorial editable paths. The hero is the sole policy-governed H1; all four editorial Teasers are policy-governed H2s.

The canonical header and footer Experience Fragment masters each contain exactly one custom semantic component. Header navigation is source-complete and stored in `teamItems/item0..2` and `primaryItems/item0..2`. Footer racing and corporate lists are source-complete and stored in canonical nested multifields.

Six supplied PNG masters, plus the locally mirrored source logo, are packaged with real originals. The five visible images resolve from page Teasers; `Falcon-2.png` is intentionally unused. Every PNG has verified SHA-256, dimensions, and `tiff:ImageWidth`/`tiff:ImageLength` metadata; see `dam-fixture-manifest.yaml`.

## Explicit content gaps

The five legal destinations and the icon-only social destinations are not source-verifiable under this run's approved source inventory. Their visible labels and order are retained in the inventory but their required URL fields are not authored: no placeholders, guessed URLs, or `#` links were introduced. Resolve and seed them in the footer only after approved live verification.

Public-use rights confirmation for the supplied images and mirrored CrowdStrike Racing logo remains required.

## Static verification

- XML parsed for page, XF, DAM metadata, filter, template, and policy content.
- All six local PNG originals matched their inventory hashes and dimensions.
- Page references template `racing-page`; its Teaser, container, header, and footer resource types and numeric style IDs resolve against current Blockwright artifacts.
- DAM references point only to packaged local assets. No source-site or Downloads-folder URL is rendered.
- Runtime package install/read-back and smoke rendering remain pending.

## Post-deploy request

Pilot and Auditron: request `GET /content/adlc-crowdstrike/us/en/about-us.html`; verify HTTP 200, one H1, five Teaser sections, canonical XF header/footer, all five visible DAM images, and absence of unconfigured placeholders. Verify package-installed metadata/read-back and responsive/eager/lazy behavior against the authored content.
