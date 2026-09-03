# Authoring guidelines — CrowdStrike Racing About

## Create and seed the page

1. Ensure `/content/adlc-crowdstrike`, `/us`, and `/en` are `cq:Page` nodes and each content node exposes the exact `racing-page$` allowed-template entry.
2. Create `/content/adlc-crowdstrike/us/en/about-us` from `racing-page`; do not create intermediate `nt:folder` nodes.
3. Author the hero at `jcr:content/root/container/hero/about_us_hero`; author the four editorial Teasers at `jcr:content/root/container/container/*` in the inventory order.
4. Header/footer are never overridden per page. Edit the custom component within the canonical header/footer Experience Fragment masters.
5. Activate the page, both XF masters, the logo, and all five visible DAM images together. ASSET-002 is seeded but intentionally unused.

## Exact content and styles

Use `source-content-inventory.md` verbatim. Do not paste source HTML or invent shortened prose. Configure:

- Hero: style `Racing Hero`, h1 fixed by policy, ASSET-001, no CTA/description.
- We Stop Breaches: `Editorial Split + Content First + Light`, ASSET-003, one external CTA.
- Why We Race: `Editorial Split + Media First + Dark`, ASSET-004, two paragraphs, no CTA.
- CrowdStrike Racing by APR: `Editorial Split + Content First + Light`, ASSET-005, no CTA.
- No. 4 CrowdStrike Oreca 07: `Editorial Split + Media First + Dark`, ASSET-006, paragraph followed by a semantic unordered list of exactly three items.

No raw HTML field exists. Use the Core Teaser rich-text controls; scripts, inline styles, tables, and embedded images are not allowed.

## Image rules

- Preserve originals as DAM masters and record source filename, dimensions, and SHA-256.
- Use concise contextual alt text from the inventory. Logo alt is `CrowdStrike Racing Logo`. Falcon art, if ever approved as ambient art, uses empty alt.
- Keep the hero's full image visible on phone/tablet as an intrinsic-width image below its dark title band; do not crop out drivers. On desktop use the built-in left dark field and keep drivers right.
- Editorial crops retain the car/crew focal subject. No ornamental radius. Do not serve a 2048px original unchanged to a 390px layout.
- Hero loads eagerly/high priority with intrinsic ratio. All editorial images lazy-load with width/height or aspect ratio.

## Header/footer authoring

- Header order is fixed: The Team disclosure (Drivers, Schedule, Awards), CXO Summits, Photo Gallery, About Us. The component computes current-page state from the request/path; authors do not tick a current checkbox.
- Menu/control labels are localizable fields with defaults documented in the inventory. External new-context links require `rel="noopener noreferrer"`.
- Footer group/link/legal order is fixed by the inventory. Resolve and record the five live legal hrefs before seeding; no `#` placeholders.
- Add/remove/reorder operations in each multifield must round-trip. Empty groups are omitted semantically; the entire footer/header must not emit unconfigured placeholder copy.

## Responsive reading order

DOM order is always heading/copy/actions before image for Teasers. At desktop, media-first rows use CSS `order` on the image only. At phone/tablet all editorial rows read content then image. Never use `column-reverse`; never duplicate header, body, or footer DOM for responsive states.

## Empty and error states

- Missing hero title or image: author validation blocks save; public render suppresses broken image UI and logs no client error.
- Missing editorial image: render the content pane full width, without an empty 50% hole.
- Missing optional CTA: omit action list entirely.
- Missing footer link group/social list: omit that group/list; preserve remaining group order.
- Broken/dangling DAM references, remote image URLs, `#` links, “Please configure”, or author placeholders are release blockers.

## Rights/provenance

The supplied images and live logo require owner rights confirmation before public production use. Preserve provenance; do not invent photographer/license metadata.

