# Design token audit — CrowdStrike Racing About

Run: `2026-09-02T18-28Z-crowdstrike-racing-about`  
Reference: `https://crowdstrikeracing.com/about-us/`  
Evidence date: 2026-09-02

## Evidence and confidence

The live HTML/text and all six supplied PNG masters were re-inspected. A direct Chromium capture reached the corporate Zscaler caution interstitial, so source computed CSS and font files could not be measured. Values below are therefore either **observed** (visible content/image evidence), **project-exact** (existing AEM responsive/template contract), **asset-exact** (dimensions), or **inferred design defaults**. Inferred values are implementation targets, not claims about the inaccessible source CSS. Sentinel must capture the accessible live reference and may tighten them through the visual iteration loop without changing the approved component architecture.

Tolerance for reference comparison: color roles/palette direction exact; implemented token values exact; reference geometry ±8 px at 390 px, ±12 px at 768 px, ±16 px at 1440 px; font size ±2 px; line height ±3 px. Image identity and copy have zero tolerance.

## Colors

| Token | Value | Role | Evidence |
| --- | --- | --- | --- |
| `color-black` | `#000000` / `rgb(0, 0, 0)` | Header/footer, hero title field, dark bands | observed in reference/assets |
| `color-charcoal` | `#151515` / `rgb(21, 21, 21)` | Alternating dark editorial surface | inferred from observed near-black surface |
| `color-white` | `#ffffff` / `rgb(255, 255, 255)` | Text on dark, light surface | observed |
| `color-ink` | `#171717` / `rgb(23, 23, 23)` | Text on light | inferred high-contrast neutral |
| `color-light` | `#f4f4f4` / `rgb(244, 244, 244)` | Alternating light editorial surface | inferred from observed neutral |
| `color-red` | `#e01b2f` / `rgb(224, 27, 47)` | Brand accent, CTA/focus detail | inferred from supplied CrowdStrike artwork; reference comparison tolerance ±8/channel |
| `color-focus` | `#ffffff` with `#e01b2f` outer ring | Visible focus on all surfaces | accessibility contract |

## Typography

Exact source webfont files were not available. Use a licensed project font if supplied before implementation; otherwise use the declared resilient stack.

| Role | Family | Size mobile / tablet / desktop | Weight | Line height | Letter spacing | Evidence |
| --- | --- | --- | --- | --- | --- | --- |
| Display h1 | `Arial Narrow, Arial, Helvetica, sans-serif` | `48px / 60px / 72px` | `700` | `0.96` | `-0.02em` | observed compact bold character; size inferred |
| Section h2 | same | `36px / 44px / 52px` | `700` | `1.02` | `-0.015em` | observed/inferred |
| Footer group h3 | same | `22px / 24px / 24px` | `700` | `1.2` | `0` | inferred |
| Body | `Arial, Helvetica, sans-serif` | `17px / 18px / 18px` | `400` | `1.55` | `0` | observed clean sans-serif; values inferred |
| Navigation/link/button | same | `16px / 16px / 16px` | `700` | `1.25` | `0.01em` | inferred |
| Legal | same | `14px` all | `400` | `1.5` | `0` | accessibility minimum |

## Spacing and geometry

Underlying scale: `4, 8, 12, 16, 24, 32, 48, 64, 80, 96, 112` px.

| Role | Mobile | Tablet | Desktop | Evidence |
| --- | --- | --- | --- | --- |
| Safe horizontal gutter | `20px` | `32px` | `64px` | inferred from observed layout; Plan range |
| Header height | `72px` | `80px` | `88px` | inferred |
| Hero content padding | `32px 20px` | `48px 32px` | `64px` | inferred |
| Editorial content padding | `48px 20px` | `64px 32px` | `80px 64px` | inferred from source rhythm |
| Section inter-item gap | `24px` | `32px` | `48px` | inferred |
| Footer padding | `48px 20px 32px` | `64px 32px 40px` | `80px 64px 40px` | inferred |
| Content maximum | `100%` | `100%` | `1280px` | inferred; ±64 px reference tolerance |
| Body copy line length | `100%` | `65ch` | `65ch` | readability contract |

## Breakpoints

Mobile-first. Existing template values are authoritative: phone `<768px`, tablet `768–1199px`, desktop `>=1200px`. Required snapshots are `390×844`, `768×1024`, and `1440×900`; fluid reflow is checked `320–1920px`.

## Radii, borders, shadows, motion, z-index

| Category | Value | Role/evidence |
| --- | --- | --- |
| Editorial/hero image radius | `0` | observed full-bleed photographic treatment |
| Menu/control radius | `2px` | inferred minimal motorsport treatment |
| Focus outline | `2px solid #ffffff`, `2px` offset, `0 0 0 4px #e01b2f` | accessibility contract |
| Shadow | `none` on editorial/hero/footer | observed flat treatment |
| Menu transition | `opacity/transform 160ms ease` | inferred; disabled by reduced-motion |
| Header stacking | `z-index: 1000` | menu overlays hero safely |
| Hero content stacking | `z-index: 2` | title remains above image/gradient |

## Layout patterns

| Pattern | Mobile | Tablet | Desktop | Source |
| --- | --- | --- | --- | --- |
| Hero | content band then uncropped `width:100%; height:auto` image | same unless image/title remain legible | title overlays panoramic asset | asset-exact ratio `2048:744`, observed title field |
| Editorial row | `flex-direction:column`; content then media | stack by default; two columns only at >=1200 | `display:flex; align-items:stretch`; both panes `flex:0 0 50%; width:50%` | approved architecture/D18 |
| Alternation | no CSS order reversal | no reversal | media-first variants set image `order:-1`, content `order:0` | Core Teaser content-first DOM/D7 |
| Footer | one-column grid | two-column grid | three-column grid | observed/inferred responsive collapse |
| Header | menu button + off-canvas/drop panel | menu button | horizontal nav + submenu | reference behavior contract |

