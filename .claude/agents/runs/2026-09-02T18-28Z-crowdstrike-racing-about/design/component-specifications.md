# Component specifications — CrowdStrike Racing About

All visual values reference `design-token-audit.md`; content values reference `source-content-inventory.md`. The source DOM/CSS/scripts are not reused.

## Inventory/reuse triage

Existing project proxies confirmed: `teaser` → Core Teaser v2, `container` → Core Container v1, `experiencefragment` → Core XF v2, `image` → Core Image v3, and `page` → Core Page v3. Existing `page-content` has a structural Title and is not modified. New components are limited to the two coherent arbitrary-link-list chrome surfaces.

## `site-header`

**Classification:** custom atomic component. Core Navigation cannot represent the source's arbitrary fixed top-level links plus one nested arbitrary submenu, brand image, mobile disclosure, and current-path state in one dialog. Composition would fragment one semantic header across components.

**Resource type:** `adlc-crowdstrike/components/site-header`. **Semantic root:** `<header class="cmp-site-header">`; first child is a skip link to `#main-content`; brand-home link; `<nav aria-label>`; disclosure button for The Team; mobile menu button.

**Sling Model:** `com.adlccrowdstrike.aem.core.models.SiteHeaderModel`, adaptable from `{SlingHttpServletRequest.class, Resource.class}`, `DefaultInjectionStrategy.OPTIONAL`. No resolver/service/external call.

| Accessor | Type/role |
| --- | --- |
| `getLogoReference()` | `String`; DAM logo path |
| `getLogoAlt()` | `String`; non-empty brand alt |
| `getHomeUrl()` | `String`; brand link |
| `getNavigationLabel()`, `getMenuLabel()`, `getCloseLabel()` | `String`; localizable control names |
| `getTeamLabel()`, `getTeamUrl()` | `String`; first primary disclosure identity |
| `getTeamItems()` | `List<NavigationItem>`; ordered submenu |
| `getPrimaryItems()` | `List<NavigationItem>`; ordered links after The Team |
| `getCurrentPath()` | `String`; request-derived current resource path |
| `NavigationItem.getLabel/getUrl/isExternal/isCurrent` | `String/String/boolean/boolean`; normalized view contract |

**BEM/behavior:** `.cmp-site-header`, `__skip-link`, `__inner`, `__brand`, `__logo`, `__menu-toggle`, `__navigation`, `__list`, `__item`, `__link`, `__submenu-toggle`, `__submenu`, `__submenu-link`; modifiers `--menu-open`, `--has-submenu`, `--current`. JS enhances native buttons, sets `aria-expanded`/`aria-controls`, closes on Escape/outside activation, restores focus, never traps focus, and leaves links available when JS fails. Current link uses `aria-current="page"` plus underline/marker, not color alone. No hard-coded UI strings in JS.

**Edge cases:** missing logo → text brand fallback, not broken image; empty submenu → The Team is a normal link; invalid/empty label suppresses item; external target-new links get `noopener noreferrer`; only one header landmark.

### Pixel-Verified Acceptance Criteria

| Selector | Property | Mobile `<768` | Desktop `>=1200` |
| --- | --- | --- | --- |
| `.cmp-site-header` | `height` | `72px` | `88px` |
| `.cmp-site-header` | `background-color` | `rgb(0, 0, 0)` | `rgb(0, 0, 0)` |
| `.cmp-site-header` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-site-header__inner` | `padding-inline` | `20px` | `64px` |
| `.cmp-site-header__menu-toggle` | `min-width` | `44px` | `0px` |
| `.cmp-site-header__menu-toggle` | `min-height` | `44px` | `0px` |
| `.cmp-site-header__menu-toggle` | `display` | `inline-flex` | `none` |
| `.cmp-site-header__navigation` | `display` | `none` closed / `flex` open | `flex` |
| `.cmp-site-header__navigation` | `flex-direction` | `column` | `row` |
| `.cmp-site-header__link` | `font-size` | `16px` | `16px` |
| `.cmp-site-header__link` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-site-header__link:focus-visible` | `outline` | `2px solid rgb(255, 255, 255)` | `2px solid rgb(255, 255, 255)` |

## Project Teaser proxy — hero and editorial variants

**Classification:** Style System variants on `adlc-crowdstrike/components/teaser` → `core/wcm/components/teaser/v2/teaser`. Core model, HTL, dialog, and edit config are inherited.

**Hard guardrails:** no custom `_cq_dialog/.content.xml`, no custom `teaser.html`, no custom `_cq_editConfig.xml`, no custom Sling Model, and no reserved `jcr:` field names beyond Core's standard persisted properties. Use `pretitle`, `jcr:title`, `jcr:description`, `actions`, `fileReference`, image alt, and policy fields exactly as Core Teaser v2 expects.

**DOM fit:** Core renders content before image. The Style System class is on the decoration wrapper, so selectors must include the variant wrapper and descendant `.cmp-teaser`. Hero uses CSS positioning only. Editorial uses flex only. Media-first desktop rows set `.cmp-teaser__image { order:-1 }`; never `column-reverse`.

**Content mapping:** `jcr:title` renders h1 only in hero policy context and h2 in editorial context; `jcr:description` renders body/RTE list; `actions/item0/{text,link}` renders CTA; `fileReference` delegates to project Image; image alt comes from DAM with author override. Exact values are the hero/section rows in the source inventory.

**Variants:** `cmp-teaser--racing-hero`; editorial base `cmp-teaser--racing-editorial`; direction `--racing-content-first|--racing-media-first`; surface `--racing-light|--racing-dark`.

**Accessibility/image behavior:** one h1 only; four h2s; semantic `<ul><li>` preserved in Section 4; dark variants explicitly color container, title, description, all description descendants, pretitle, links, focus, and icons. Hero phone/tablet uses content band then uncropped intrinsic image to retain all three drivers. Desktop hero overlays left content on the asset's black field. Editorial missing-image state expands content to 100%. Image-first desktop presentation does not alter reading/focus order.

### Pixel-Verified Acceptance Criteria — hero

| Selector | Property | Mobile `<768` | Desktop `>=1200` |
| --- | --- | --- | --- |
| `.cmp-teaser--racing-hero .cmp-teaser` | `position` | `relative` | `relative` |
| `.cmp-teaser--racing-hero .cmp-teaser` | `display` | `flex` | `block` |
| `.cmp-teaser--racing-hero .cmp-teaser` | `flex-direction` | `column` | `row` (not layout-active because block at desktop) |
| `.cmp-teaser--racing-hero .cmp-teaser__content` | `position` | `relative` | `absolute` |
| `.cmp-teaser--racing-hero .cmp-teaser__content` | `padding` | `32px 20px` | `64px` |
| `.cmp-teaser--racing-hero .cmp-teaser__content` | `z-index` | `2` | `2` |
| `.cmp-teaser--racing-hero .cmp-teaser__content` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-teaser--racing-hero .cmp-teaser__title` | `font-size` | `48px` | `72px` |
| `.cmp-teaser--racing-hero .cmp-teaser__title` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-teaser--racing-hero .cmp-teaser__pretitle, .cmp-teaser--racing-hero .cmp-teaser__description, .cmp-teaser--racing-hero .cmp-teaser__description *` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-teaser--racing-hero a, .cmp-teaser--racing-hero a:hover, .cmp-teaser--racing-hero a:focus` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-teaser--racing-hero svg` | `fill` | `currentColor` | `currentColor` |
| `.cmp-teaser--racing-hero .cmp-teaser__image img` | `width` | `100%` | `100%` |
| `.cmp-teaser--racing-hero .cmp-teaser__image img` | `height` | `auto` | `520px` |
| `.cmp-teaser--racing-hero .cmp-teaser__image img` | `object-fit` | `contain` | `cover` |
| `.cmp-teaser--racing-hero .cmp-teaser__image img` | `object-position` | `center center` | `center center` |

### Pixel-Verified Acceptance Criteria — editorial

| Selector | Property | Mobile `<768` | Desktop `>=1200` |
| --- | --- | --- | --- |
| `.cmp-teaser--racing-editorial .cmp-teaser` | `display` | `flex` | `flex` |
| `.cmp-teaser--racing-editorial .cmp-teaser` | `flex-direction` | `column` | `row` |
| `.cmp-teaser--racing-editorial .cmp-teaser` | `align-items` | `stretch` | `stretch` |
| `.cmp-teaser--racing-editorial .cmp-teaser__content` | `flex` | `0 0 100%` | `0 0 50%` |
| `.cmp-teaser--racing-editorial .cmp-teaser__content` | `width` | `100%` | `50%` |
| `.cmp-teaser--racing-editorial .cmp-teaser__image` | `flex` | `0 0 100%` | `0 0 50%` |
| `.cmp-teaser--racing-editorial .cmp-teaser__image` | `width` | `100%` | `50%` |
| `.cmp-teaser--racing-editorial .cmp-teaser__content` | `padding` | `48px 20px` | `80px 64px` |
| `.cmp-teaser--racing-editorial .cmp-teaser__title` | `font-size` | `36px` | `52px` |
| `.cmp-teaser--racing-editorial .cmp-teaser__description` | `font-size` | `17px` | `18px` |
| `.cmp-teaser--racing-media-first .cmp-teaser__image` | `order` | `0` | `-1` |
| `.cmp-teaser--racing-media-first .cmp-teaser__content` | `order` | `0` | `0` |
| `.cmp-teaser--racing-editorial .cmp-teaser__image` | `border-radius` | `0px` | `0px` |
| `.cmp-teaser--racing-editorial .cmp-teaser__image img` | `border-radius` | `0px` | `0px` |
| `.cmp-teaser--racing-editorial .cmp-teaser__image img` | `object-fit` | `cover` | `cover` |
| `.cmp-teaser--racing-dark .cmp-teaser` | `background-color` | `rgb(21, 21, 21)` | `rgb(21, 21, 21)` |
| `.cmp-teaser--racing-dark .cmp-teaser` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-teaser--racing-dark .cmp-teaser__title` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-teaser--racing-dark .cmp-teaser__description, .cmp-teaser--racing-dark .cmp-teaser__description *` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-teaser--racing-dark .cmp-teaser__pretitle` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-teaser--racing-dark a, .cmp-teaser--racing-dark a:hover, .cmp-teaser--racing-dark a:focus` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-teaser--racing-dark svg` | `fill` | `currentColor` | `currentColor` |
| `.cmp-teaser--racing-light .cmp-teaser` | `background-color` | `rgb(244, 244, 244)` | `rgb(244, 244, 244)` |
| `.cmp-teaser--racing-light .cmp-teaser` | `color` | `rgb(23, 23, 23)` | `rgb(23, 23, 23)` |

## Project Container proxy

**Classification:** reuse `adlc-crowdstrike/components/container` → Core Container v1. No custom dialog/HTL/edit config or Sling Model. It supplies root/main, hero/editorial authoring contexts, and optional authored bands. Style classes: `.cmp-container--racing-full-bleed`, `.cmp-container--racing-content-width`; content selectors target descendant `.cmp-container` because classes may sit on the decoration wrapper.

**Semantics:** root is structural `<div>`; the main container uses supported element semantics/policy and must expose `id="main-content"`; author bands may be `<section>` only when they have an accessible heading. No Foundation responsive grid.

**Edge cases:** no broad allowed-component default; grid clearfix pseudo-elements disabled if a container is turned into flex/grid; no overflow 320–1920 px.

### Pixel-Verified Acceptance Criteria

| Selector | Property | Mobile `<768` | Desktop `>=1200` |
| --- | --- | --- | --- |
| `.cmp-container--racing-full-bleed > .cmp-container` | `width` | `100%` | `100%` |
| `.cmp-container--racing-full-bleed > .cmp-container` | `max-width` | `none` | `none` |
| `.cmp-container--racing-content-width > .cmp-container` | `width` | `100%` | `calc(100% - 128px)` |
| `.cmp-container--racing-content-width > .cmp-container` | `max-width` | `100%` | `1280px` |
| `.cmp-container--racing-content-width > .cmp-container` | `margin-inline` | `0px` | `auto` |

## `site-footer`

**Classification:** custom atomic component per arbitrary label+URL D16 exception. Fixed three group shapes plus ordered link multifields avoid nested multifield fragility and keep one coherent authoring surface.

**Resource type:** `adlc-crowdstrike/components/site-footer`. **Semantic root:** `<footer class="cmp-site-footer">` containing a labelled footer navigation region, three groups with heading/list semantics, optional brand artwork, and one legal list/row.

**Sling Model:** `com.adlccrowdstrike.aem.core.models.SiteFooterModel`, adaptable from `{SlingHttpServletRequest.class, Resource.class}`, optional injection; no service/external call.

| Accessor | Type/role |
| --- | --- |
| `getLogoReference/getLogoAlt/getHomeUrl` | `String`; brand identity |
| `getRacingGroupTitle/getWhyGroupTitle/getSocialGroupTitle` | `String`; exact group headings |
| `getRacingLinks/getWhyLinks/getLegalLinks` | `List<FooterLink>`; ordered arbitrary link pairs |
| `getSocialLinks()` | `List<SocialLink>`; label, URL, optional DAM icon |
| `getCopyrightText()` | `String`; exact current legal text |
| `getFalconReference/isFalconDecorative` | `String/boolean`; optional artwork, unset for canonical page |
| `FooterLink.getLabel/getUrl/isExternal` | normalized rendering contract |

**BEM:** `.cmp-site-footer`, `__inner`, `__brand`, `__logo`, `__groups`, `__group`, `__heading`, `__links`, `__link`, `__social`, `__social-link`, `__social-icon`, `__legal`, `__copyright`, `__legal-links`, `__falcon`.

**Accessibility/edge cases:** all descendant text/links explicitly white on dark; external new-context links safe; social icons have link accessible names; decorative Falcon has empty alt and is absent in canonical page; empty groups are suppressed; one footer landmark/DOM only; legal link targets must be resolved before seed.

### Pixel-Verified Acceptance Criteria

| Selector | Property | Mobile `<768` | Desktop `>=1200` |
| --- | --- | --- | --- |
| `.cmp-site-footer` | `background-color` | `rgb(0, 0, 0)` | `rgb(0, 0, 0)` |
| `.cmp-site-footer` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-site-footer__inner` | `padding` | `48px 20px 32px` | `80px 64px 40px` |
| `.cmp-site-footer__groups` | `display` | `grid` | `grid` |
| `.cmp-site-footer__groups` | `grid-template-columns` | `1fr` | `repeat(3, minmax(0, 1fr))` |
| `.cmp-site-footer__groups` | `gap` | `32px` | `48px` |
| `.cmp-site-footer__heading` | `font-size` | `22px` | `24px` |
| `.cmp-site-footer__heading, .cmp-site-footer__link, .cmp-site-footer__legal *` | `color` | `rgb(255, 255, 255)` | `rgb(255, 255, 255)` |
| `.cmp-site-footer__link:focus-visible` | `outline` | `2px solid rgb(255, 255, 255)` | `2px solid rgb(255, 255, 255)` |
| `.cmp-site-footer__legal` | `font-size` | `14px` | `14px` |

## Experience Fragment proxy/chrome

**Classification:** reuse `adlc-crowdstrike/components/experiencefragment` → Core XF v2. No custom dialog/HTL/edit config/model. The wrapper is unconditionally a `<div>`; target `.cmp-experiencefragment--header` and `.cmp-experiencefragment--footer`. The custom child components supply semantic landmarks.

### Pixel-Verified Acceptance Criteria

| Selector | Property | Mobile `<768` | Desktop `>=1200` |
| --- | --- | --- | --- |
| `.cmp-experiencefragment--header` | `display` | `block` | `block` |
| `.cmp-experiencefragment--header` | `position` | `relative` | `relative` |
| `.cmp-experiencefragment--header` | `z-index` | `1000` | `1000` |
| `.cmp-experiencefragment--footer` | `display` | `block` | `block` |
| `.cmp-experiencefragment--footer` | `background-color` | `rgb(0, 0, 0)` | `rgb(0, 0, 0)` |
