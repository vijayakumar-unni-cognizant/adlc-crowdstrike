# Policy mapping — `racing-page`

No mapping uses `*` or a broad component group.

## Template mapping tree

| Mapping path | Policy | Allowed components | Rationale |
| --- | --- | --- | --- |
| `jcr:content` | `adlc-crowdstrike/components/page/racing-page` | N/A | Loads dependencies/site clientlibs and page metadata behavior |
| `root` | `adlc-crowdstrike/components/container/racing-root` | structural children only | Locked root; no author insert surface |
| `root/experiencefragment-header` | `adlc-crowdstrike/components/experiencefragment/racing-header` | N/A | Correct page-template XF wrapper context |
| `root/container` | `adlc-crowdstrike/components/container/racing-main` | structural children only | Emits main semantics; locked |
| `root/container/hero` | `adlc-crowdstrike/components/container/racing-hero-slot` | `[adlc-crowdstrike/components/teaser]` | Hero-only authoring, enforces one coherent block |
| `root/container/hero/adlc-crowdstrike/components/teaser` | `adlc-crowdstrike/components/teaser/racing-hero` | N/A | Reachable h1 policy context |
| `root/container/container` | `adlc-crowdstrike/components/container/racing-editorial-slot` | `[adlc-crowdstrike/components/teaser,adlc-crowdstrike/components/container]` | Narrow body surface; optional containers only for authored surface bands |
| `root/container/container/adlc-crowdstrike/components/teaser` | `adlc-crowdstrike/components/teaser/racing-editorial` | N/A | One consolidated h2 editorial policy |
| `root/container/container/adlc-crowdstrike/components/container` | `adlc-crowdstrike/components/container/racing-band` | `[adlc-crowdstrike/components/teaser]` | Nested band cannot contain arbitrary components |
| `root/experiencefragment-footer` | `adlc-crowdstrike/components/experiencefragment/racing-footer` | N/A | Correct page-template XF wrapper context |

## Teaser policies

Both policies are minimal: `imageDelegate=adlc-crowdstrike/components/image`; do not set `titleHidden`, `descriptionHidden`, or `pretitleHidden=false`.

### `racing-hero`

- `titleType=h1`, `allowedTypes=[h1]`, actions disabled.
- Style group `Racing Hero` (single selection):
  - `cq:styleId=20260902001`, `cq:styleClasses=cmp-teaser--racing-hero`, label `Racing Hero`.

### `racing-editorial`

- `titleType=h2`, `allowedTypes=[h2]`, actions enabled.
- RTE permits paragraphs, bold/italic, links, unordered/ordered lists; images/tables/headings/scripts are unavailable.
- Style groups are composable; each seeded item selects exactly one layout direction and one surface:
  - Layout: `20260902002` / `cmp-teaser--racing-editorial` / `Editorial Split` (required base).
  - Direction: `20260902003` / `cmp-teaser--racing-content-first` / `Content First`; `20260902004` / `cmp-teaser--racing-media-first` / `Media First`.
  - Surface: `20260902005` / `cmp-teaser--racing-light` / `Light`; `20260902006` / `cmp-teaser--racing-dark` / `Dark`.
- Seed: Section 1 base+content-first+light; Section 2 base+media-first+dark; Section 3 base+content-first+light; Section 4 base+media-first+dark.

## Container policies and Style System

### `racing-hero-slot`

Allowed component: only project Teaser. Style group `Width`, single selection:

- `20260902011`, class `cmp-container--racing-full-bleed`, label `Full Bleed`.

### `racing-editorial-slot` and `racing-band`

Allowed components are the explicit lists above. Style group `Width`, single selection:

- `20260902012`, class `cmp-container--racing-full-bleed`, label `Full Bleed`.
- `20260902013`, class `cmp-container--racing-content-width`, label `Content Width`.

Do not define unused 2/3/4-column variants. The page's 50:50 layout is a Teaser variant, not a generic author-selected grid.

## Image delegate policy

Enable Asset Delivery where available; rendition widths `[320,480,640,768,1024,1280,1600,2048]`; JPEG quality 85; DAM alt/title defaults with instance override; author upload disabled. The hero instance is explicitly eager/high priority; below-fold images are lazy. If Core Image policy cannot express per-instance fetch priority, Blockwright must implement the smallest supported delegation/config hook without overlaying Teaser HTL.

## Experience Fragment template context

Page-template XF policies do not govern content inside the fragments. In `/conf/adlc-crowdstrike/settings/wcm/templates/xf-web-variation/policies`, map the XF root container to two narrowly scoped policies (or a shared explicit policy whose allowed list is the same):

- Header master root: only `adlc-crowdstrike/components/site-header`.
- Footer master root: only `adlc-crowdstrike/components/site-footer`.

The Core XF wrapper remains a `<div>` with `.cmp-experiencefragment--header` or `--footer`; do not depend on `cq:styleDefaultElement` to change it.

## Pixel-verifiable Container variants

| Selector | Property | Mobile | Desktop >=1200 |
| --- | --- | --- | --- |
| `.cmp-container--racing-full-bleed > .cmp-container` | `width` | `100%` | `100%` |
| `.cmp-container--racing-full-bleed > .cmp-container` | `max-width` | `none` | `none` |
| `.cmp-container--racing-content-width > .cmp-container` | `width` | `100%` | `calc(100% - 128px)` |
| `.cmp-container--racing-content-width > .cmp-container` | `max-width` | `100%` | `1280px` |
| `.cmp-container--racing-content-width > .cmp-container` | `margin-inline` | `0` | `auto` |

