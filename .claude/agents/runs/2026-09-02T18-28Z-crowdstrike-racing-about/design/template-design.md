# Editable-template design — `racing-page`

## Decision

Create `/conf/adlc-crowdstrike/settings/wcm/templates/racing-page`, based on existing template type `/conf/adlc-crowdstrike/settings/wcm/template-types/page`, using `adlc-crowdstrike/components/page`. Reusing `page-content` is rejected because its structural Title self-populates an unwanted second `<h1>`.

**Structural page heading: absent.** The hero Teaser owns the single `<h1>About Us</h1>`; omit the archetype `<title>` node from both structure and initial content.

## Structure contract

The structure mirrors the established project shape and adds two authoring contexts so Core Teaser heading policies are deterministic:

```text
jcr:content (page policy; clientlibs)
└── root — adlc-crowdstrike/components/container, layout=responsiveGrid (locked)
    ├── experiencefragment-header — project XF proxy; canonical header master (locked)
    ├── container — project Container; semantic main (locked)
    │   ├── hero — project Container; editable responsiveGrid, hero-only parsys
    │   └── container — project Container; editable responsiveGrid, editorial parsys
    └── experiencefragment-footer — project XF proxy; canonical footer master (locked)
```

- Header variation: `/content/experience-fragments/adlc-crowdstrike/us/en/site/header/master`.
- Footer variation: `/content/experience-fragments/adlc-crowdstrike/us/en/site/footer/master`.
- Do not set `editable=false` or `decoration=false` on XF nodes. Do not set `editable=true` on `root`.
- `hero` and the inner `container` are the only editable structural containers.
- No Breadcrumb, Navigation, Language Navigation, Search, or Title self-populating component is present in page structure.
- Core XF v2 keeps its `<div>` wrapper; semantic `<header>` and `<footer>` roots come from the custom components inside the fragments.

## Initial content

Initial content repeats page/root/main/hero/editorial container paths only and contains no placeholder Teaser, Title, text, header, or footer. Composer seeds the complete sample page and XF master content. Empty author parsys placeholders are author-only and must never render as public “configure” text.

## Policy contexts and H1 budget

| Instance/context | Resource type | Policy | Heading |
| --- | --- | --- | --- |
| `root/container/hero/*` | `adlc-crowdstrike/components/teaser` | `.../teaser/racing-hero` | fixed `titleType=h1`; `allowedTypes=[h1]` |
| `root/container/container/*` | `adlc-crowdstrike/components/teaser` | `.../teaser/racing-editorial` | fixed `titleType=h2`; `allowedTypes=[h2]` |
| Structural Title | none | none | absent |
| Footer group headings | custom site-footer | custom semantic contract | `<h2>` visually compact or `<h3>` under a hidden footer nav label; never h1 |

This two-container mapping is the documented exception to one shared Teaser policy: Core Teaser v2 ignores per-instance `titleType`, so distinct reachable template contexts are necessary for one h1 and four h2s. Each context has one policy; all editorial variants are consolidated in the editorial policy.

## Responsive definition

Retain project responsive breakpoints: `phone=768`, `tablet=1200`. Mobile-first CSS uses `<768`, tablet `768–1199`, desktop `>=1200`. The AEM emulator definitions and frontend media queries must match.

## Registration

On the `jcr:content` of each `/content/adlc-crowdstrike`, `/content/adlc-crowdstrike/us`, and `/content/adlc-crowdstrike/us/en`, add/retain a `String[]` `cq:allowedTemplates` entry exactly matching `/conf/adlc-crowdstrike/settings/wcm/templates/racing-page$`. Do not replace other legitimate project-template entries. Template `allowedPaths` is `/content/adlc-crowdstrike(/.*)?`.

## Page metadata

The page policy must include `clientlibs=[adlc-crowdstrike.dependencies,adlc-crowdstrike.site]`. Composer authors `jcr:title=About Us`, `pageTitle=About Us | CrowdStrike Racing`, the source-derived description, canonical/public URL, OG title/description/URL, and OG image from ASSET-001. No invented SportsTeam schema.

## Authoring/content placement

- Hero node: `.../jcr:content/root/container/hero/about_us_hero`.
- Editorial nodes: `.../jcr:content/root/container/container/{we_stop_breaches,why_we_race,racing_by_apr,oreca_07}`.
- Page content is mutable in `ui.content`; template/policies are immutable developer definitions.

