```ids: prefix=UI count=20 UI-001..UI-020 (no gaps)```

# Playwright UI scenario specifications

Blockwright creates one pre-deploy Playwright spec per ID, parameterized for Author/Publish as stated. Sentinel executes every ID post-deploy. Every Publish scenario runs axe for its exercised state; cross-browser default is Chromium, Firefox, WebKit, plus a mobile-emulated project unless narrowed below.

| ID | executor | Tier / viewport | Journey/actions | DOM, accessibility and visual assertions |
| --- | --- | --- | --- | --- |
| UI-001 | sentinel | Publish `1440×900` | Open `/about-us/`; wait for fonts/hero image; capture full page. | Header→hero→four sections→footer order; exact current copy; desktop nav, panoramic hero, alternating rows, 3-column footer; visual diff within token tolerance. |
| UI-002 | sentinel | Publish `768×1024` | Open and capture; scroll every section. | Tablet menu treatment; stacked editorial default at <1200; 32px gutters; no clipped copy/image/control; 2-column footer. |
| UI-003 | sentinel | Publish `390×844` | Open and capture; scroll/tap menu. | 20px gutters, 44px controls, content-before-image rows, one-column footer, full driver set visible, no horizontal overflow. |
| UI-004 | sentinel | Publish fluid `320,360,390,768,1024,1199,1200,1440,1920` | At each width evaluate scroll dimensions and bounding boxes. | `scrollWidth<=clientWidth`; no pane < usable width; breakpoint changes only at 768/1200; max-width behavior at wide screens. |
| UI-005 | sentinel | Publish desktop | Tab to The Team, open with Enter/Space, traverse submenu, Escape, then navigate primary links. | Exact order/URLs; submenu role/list semantics; `aria-expanded` true/false, `aria-controls`; focus restored; About has `aria-current=page` and visible non-color marker. |
| UI-006 | sentinel | Publish 390 | Activate labelled Menu, tab all items, open Team submenu, Escape and outside-click close, reopen. | No focus trap; page isn't permanently obscured; state labels/expanded accurate; focus visible; no duplicate nav DOM. |
| UI-007 | sentinel | Publish all reference viewports | Press Tab from page start and activate skip link; query landmarks/headings. | Skip link first focusable and targets main; exactly one header/main/footer and one h1 `About Us`; ordered four h2s; axe has no landmark/heading serious issue. |
| UI-008 | sentinel | Publish 1440/768/390 | Inspect hero image currentSrc/natural dimensions/bounds and compare ASSET-001 screenshot landmarks. | Local DAM URL only; h1 maps to title not eyebrow; desktop overlay left; phone/tablet content band + uncropped intrinsic image; all drivers visible; useful alt; eager/high priority. |
| UI-009 | sentinel | Publish all reference viewports | Normalize text of each editorial component and compare inventory. | Exact headings/body paragraph breaks/order; only Section 1 has exact CTA; Section 4 exact three-item list; no legacy branch text. |
| UI-010 | sentinel | Publish 1440 | Read computed display/flex/order/bounds for four editorial blocks. | Each pane exactly 50% (`flex:0 0 50%`, width 50%); rows alternate content/media; equal heights/stretch; images cover without blank edges. |
| UI-011 | sentinel | Publish 390/768/1199 | Inspect DOM and visual y-order of every editorial content/image pane. | DOM and visual reading order is content then image; no `column-reverse`; consistent 48/64px rhythm; CTA focus precedes following image/section. |
| UI-012 | sentinel | Publish desktop/mobile | Activate Section 1 CTA in intercepted/new page context; inspect Oreca RTE. | Accessible name/destination exact, safe external behavior; semantic paragraph+ul+3 li; no horizontal table/list overflow. |
| UI-013 | sentinel | Publish 1440/768/390 | Query footer groups/legal/social, capture at each viewport, tab all links. | One footer DOM; exact group/link/legal order, current copyright 2025; 3/2/1 grid; accessible social names; white descendants/focus on black; no Falcon visible. |
| UI-014 | sentinel | Publish 390/1440 | Record network requests and image `currentSrc`, scroll below fold. | No request to source/reference/Downloads domains; hero eager, below-fold lazy; modern/resized rendition ≤ rendered need×DPR; width/height prevents CLS. |
| UI-015 | sentinel | Publish desktop | Inspect HTTP response and document head. | 200 SSR/indexable; unique title/meta; canonical current public URL; OG title/description/url/image local; no mixed content; no unwanted schema facts. |
| UI-016 | sentinel | Publish desktop/mobile | Run axe full rules initially, with menus open, after keyboard focus, and at 200% zoom. | Zero critical/serious; contrast thresholds; named buttons/links/images; focus visible; reflow succeeds; reduced-motion disables nonessential transition. |
| UI-017 | sentinel | Publish all projects | Run UI-005, UI-006, UI-008, UI-010, UI-013 in Chromium, Firefox and WebKit. | Equivalent semantics/interaction and no material computed-layout drift across engines. |
| UI-018 | sentinel | Author desktop authenticated | Open page editor, select hero/editorial Teasers, open dialogs/Style System and responsive preview. | Inherited Teaser fields/DAM picker available; hero only Hero style/h1 policy; editorial styles composable and h2-only; no raw HTML field; preview matches breakpoints. |
| UI-019 | sentinel | Author desktop authenticated | Open header/footer XF masters; edit a reversible link-label probe, save, preview, revert. | One custom component per XF; all designed tabs/fields visible; saved value renders then reverts; no per-page chrome component or placeholder. |
| UI-020 | sentinel | Publish all reference viewports | Count current and excluded headings, Teaser instances, footer/legal rows; compare reference source capture. | Exactly one hero, four editorials, one footer/current legal row; zero “Protection around the globe”, “We win as one”, 2023 legal row, duplicate responsive branch. |

## Coverage notes

- US-001: UI-001, UI-009, UI-020.
- US-002: UI-007, UI-008.
- US-003: UI-009–UI-012.
- US-004: UI-005–UI-007.
- US-005: UI-013.
- US-006: UI-001–UI-004, UI-007, UI-016, UI-017.
- US-007: UI-018, UI-019.
- US-008: UI-014, UI-019.
- US-009: UI-014–UI-017.

