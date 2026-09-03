# Reference deconstruction

This is the canonical visual extraction for the source page. Evidence levels:

- observed: visible in locally supplied source assets or extracted live content/asset endpoints;
- inferred: derived from DOM order and visual asset composition, to be frozen only after Designforge browser measurement;
- project contract: an intentional implementation rule for responsive/accessibility quality.

## Global page system

- Layout intent: high-contrast racing editorial page, full-width dark chrome and hero, followed by large modular alternating media/text bands and a dense multi-column footer.
- Palette, observed: black and near-black foundations, white text/surfaces, vivid CrowdStrike red accents, vehicle-specific red-to-purple gradients, restrained gray body/supporting text.
- Typography, observed character: compact, bold display headings with high impact; readable sans-serif body; short uppercase/nav labels where present. Exact family and sizes require Designforge measurement.
- Grid, inferred: centered 1200-1280px content system with full-bleed section backgrounds; editorial rows are visually balanced near 50/50. Recommended fallback gutters are 64px desktop, 32px tablet, 20-24px phone.
- Rhythm, inferred: large desktop section spacing (approximately 72-112px) and tighter phone spacing (40-64px). Heading-to-body and paragraph spacing should repeat consistently.
- Breakpoints, project contract: phone below 768px, tablet 768-1199px, desktop 1200px and wider, matching the existing AEM template breakpoint model.

## Header

- Source items: SRC-001 through SRC-004.
- Layout intent: single horizontal brand/navigation row on desktop. The Team owns a nested submenu; CXO Summits, Photo Gallery, and About Us follow as top-level items.
- Navigation order: The Team → CXO Summits → Photo Gallery → About Us; nested order Drivers → Schedule → Awards.
- Position: page top, visually separate from hero but able to read as a continuous dark chrome system.
- Logo/icon: CrowdStrike Racing brand mark at the leading edge; compact scale that does not compete with the hero title.
- Desktop behavior: nested menu opens by explicit pointer/keyboard action; hover may supplement but not replace focus/click.
- Phone behavior: brand mark plus visible menu toggle; one-column flyout/drawer, logical nested navigation, Escape close, restored focus.
- Overlay/z-index: menu must layer above the hero without clipping; header need not be sticky unless runtime reference capture proves it.
- Component fit: atomic navigation chrome does not map cleanly to one Core dialog when logo, nested menu, mobile state, and utility destinations are treated as one authoring concern. Use one project site-header component inside the existing header Experience Fragment.

## Hero

- Source items/assets: SRC-005, SRC-006, ASSET-001.
- Layout intent: full-bleed cinematic banner; one title overlays the left side while the three drivers occupy the right half.
- Split ratio, observed from asset: the left approximately 35-40% is purposefully dark/empty; subjects occupy the right approximately 60-65%.
- Image treatment: 2048×744 panoramic crop, edge-to-edge, no border or radius, cover behavior with protected focal region.
- Text: h1 About Us, white, bold display face, left aligned and vertically centered or slightly low-center. Recommended measured range: 64-88px desktop, 44-60px tablet, 36-44px phone.
- CTA: none.
- Overlay: the black gradient is baked into the supplied image; optional subtle CSS scrim may be added only if needed to pass contrast.
- Breakpoint behavior: desktop preserves the full panorama. Tablet narrows crop while preserving title field and three drivers. Phone may use cover with authorable focal point; if all three drivers cannot remain readable, a stacked image/title treatment is preferable to cutting off a principal subject.
- Core Teaser v2 DOM fit:
  - emitted skeleton: .cmp-teaser > .cmp-teaser__image + .cmp-teaser__content > .cmp-teaser__title;
  - CSS can absolutely layer content over the image, size the image, align the title, and preserve semantic h1;
  - no additional element is required, so this is classification A: existing project Teaser proxy plus hero Style System variant.

## Section 1 — We Stop Breaches

- Source: SRC-007 through SRC-009; ASSET-003.
- Layout intent: wide editorial split row, content and media near 50/50; inferred desktop order content-left/media-right from DOM order.
- Background: high-contrast neutral, likely white/light content surface paired to edge-to-edge photograph; exact source token must be measured.
- Heading: h2, bold display, left aligned; recommended measured range 44-64px desktop and 32-42px phone.
- Body: one readable paragraph, regular sans serif, approximately 17-20px desktop, comfortable 1.45-1.65 line height.
- CTA: one prominent Learn more about CrowdStrike link/button beneath body; vivid red or source-measured high-contrast treatment, low/no radius unless reference shows otherwise.
- Image: car at speed with horizontal motion blur, 1024×683, cover; no ornamental radius observed.
- Breakpoint behavior: one-column on phone; preserve source reading order, with copy before image unless browser evidence freezes a different order.
- Core Teaser v2 DOM fit:
  - emitted skeleton provides image, title, description, action container;
  - CSS grid/flex can create either side of a 50/50 row without DOM replacement;
  - classification A: Teaser variant editorial-split, with a content-first modifier.

## Section 2 — Why We Race

- Source: SRC-010, SRC-011; ASSET-004.
- Layout intent: alternate editorial split, inferred desktop order media-left/content-right.
- Background: source-measured dark or neutral alternating surface; preserve high contrast and rhythm against Section 1.
- Heading/body: same scale and line-height system as Section 1; two body paragraphs with a deliberate paragraph break.
- CTA: none in the primary branch.
- Image: night pit-stop scene with bright highlights; crop must retain crew, car number, and pit action.
- Breakpoint behavior: one column; choose media then content only if runtime source reading order and accessibility remain coherent. DOM source should keep heading/text before decorative media where possible and use CSS visual order carefully.
- Core Teaser v2 DOM fit: image/title/description are sufficient, and CSS can reverse the columns. Classification A: same editorial-split Teaser plus reverse modifier.

## Section 3 — CrowdStrike Racing by APR

- Source: SRC-012, SRC-013; ASSET-005.
- Layout intent: editorial split returning to content-left/media-right.
- Heading/body: consistent with the prior two sections; no CTA.
- Image: daylight panning race image, 3:2 master, cover with car centered low-middle.
- Treatment: full-height row media, no border/radius; prevent excessive crop of nose/rear wing.
- Breakpoint behavior: single column and full-width media; paragraph line length capped near 65-75 characters.
- Core Teaser v2 DOM fit: image/title/description sufficient. Classification A: editorial-split content-first variant.

## Section 4 — No. 4 CrowdStrike Oreca 07

- Source: SRC-014 through SRC-017; ASSET-006.
- Layout intent: alternate split, media-left/content-right, likely the closing editorial band.
- Heading/body: h2 plus descriptive paragraph.
- Specifications: three concise items for engine, gearbox, and chassis; strong labels with readable list spacing. The semantic ul/li must survive RTE output.
- Image: night/mist rear three-quarter photograph, 3:2 master; preserve the car and yellow light atmosphere.
- CTA: none.
- Breakpoint behavior: one-column; specifications remain a vertical list with no table overflow.
- Core Teaser v2 DOM fit: rich description can contain paragraph plus semantic list and requires no extra UI or computed model. Classification A: editorial-split reverse variant. Designforge must confirm the Core Teaser RTE policy permits lists.

## Footer

- Source: SRC-018; ASSET-002 is supplied brand art but occurs in the crawler's legacy/final branch.
- Layout intent: dark full-width closing region with three grouped columns/areas—CrowdStrike Racing, Why CrowdStrike?, Follow us!—then brand/legal row.
- Navigation: list semantics within each group; visible descriptive focus treatment; external destinations remain normal links.
- Logo/icons: local project brand asset(s); social icons must have accessible names. Falcon-2 may be ambient artwork only after runtime/design approval and is otherwise an intentionally unused supplied asset.
- Text: group titles visually stronger than links; legal row smaller but at least 14px equivalent and sufficient contrast.
- Breakpoint behavior: three columns at desktop, two/one as space reduces, single vertical flow on phone. Never duplicate the footer DOM for responsive layouts.
- Atomic authoring fit: grouped navigation, social links, brand art, and legal row form one authoring concern not represented by one Core Component dialog. Classification C: one project site-footer component inside the existing footer Experience Fragment.

## Cross-viewport acceptance snapshots

| Viewport | Required structural result |
| --- | --- |
| 1440×900 | Full desktop nav; panoramic hero; alternating two-column editorial bands; multi-column footer |
| 768×1024 | Tablet navigation treatment; hero/title remain balanced; split rows may remain two-column only where each pane stays at least 320px |
| 390×844 | Menu toggle; no clipping; stacked hero/editorial layout; 20-24px safe gutters; one-column footer; 44px touch targets |

## Source capture limitation

The live page text and asset endpoints were available, and all supplied images were visually inspected. Corporate Zscaler controls blocked a direct browser screenshot/computed-style session. Every exact-looking value above is therefore explicitly marked observed, inferred, or project contract. Before implementation, Designforge must replace inferred font, color, spacing, and breakpoint values with browser-measured evidence where available, while preserving the layout and component architecture documented here.

