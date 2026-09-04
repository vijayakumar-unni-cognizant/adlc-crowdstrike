# Reference and asset inventory

## Evidence status

All six supplied PNGs were opened and visually inspected. Their pixel dimensions and SHA-256 hashes were measured locally. Five URLs were also resolved directly from the live page crawl and match the supplied filenames and dimensions exactly. No production component may hotlink those endpoints.

## Asset-to-section and DAM mapping

| ID | Local source | Dimensions | SHA-256 | Visual content | Live page evidence | Planned DAM path | Planned use |
| --- | --- | --- | --- | --- | --- | --- | --- |
| ASSET-001 | D_ABOUTUS_Hero_Interior.png | 2048×744 | 9a5e158d8dcccb5719083c14bab67b175a3769c9da07d0732d82365f9fac50ad | Three winning drivers in white/red suits; stadium/pit background; deep black-to-photo gradient on left | live image 6 resolves D_ABOUTUS_Hero_Interior at 2048×744 | /content/dam/adlc-crowdstrike/racing/about-us/about-us-hero-interior.png | Hero image; title on dark left field |
| ASSET-002 | Falcon-2.png | 408×320 | 318b3fd04e59ff7a3d0f4f540e43e2116fe7060e59e8093a5ae127f6e6dac87c | Tonal red CrowdStrike falcon silhouette on dark crimson/red field | live image 16 resolves Falcon-2 at 408×320 in legacy/final branch | /content/dam/adlc-crowdstrike/racing/about-us/falcon-2.png | Seed with fixtures; use only if approved footer/final art calls for it, otherwise record unused |
| ASSET-003 | we-stop-breaches.png | 1024×683 | 61ed18b24fb8f4b2708416bf556129e6f5e71057f07ff96812d397bd9e11e894 | No. 04 prototype at speed with strong horizontal motion blur | live image 8 resolves we-stop-breaches at 1024×683 | /content/dam/adlc-crowdstrike/racing/about-us/we-stop-breaches.png | Section 1 media |
| ASSET-004 | why-we-race.png | 1024×683 | f1db05f88fb38a65e99fcd4084f07ff769a83b73541a11ae1c7d1f8803db5e1a | Night pit stop, crew around No. 04 car, bright track lights | live image 9 resolves why-we-race at 1024×683 | /content/dam/adlc-crowdstrike/racing/about-us/why-we-race.png | Section 2 media |
| ASSET-005 | IMSAROLEX26_01_23_26_111222_FH_8052.png | 2048×1365 | 51dc757779c11c8dfaa31b8f82b0c203bb8ea3abe2c796616772d34a2d9b4614 | Daylight panning photograph of No. 04 CrowdStrike prototype | live image 10 resolves same filename at 2048×1365 | /content/dam/adlc-crowdstrike/racing/about-us/crowdstrike-racing-by-apr.png | Section 3 media |
| ASSET-006 | IMSA_D24_26_01_25_001036_JP35529.png | 2048×1365 | 9db6dc808f0a7cf554caff3c5ba656108cd20f7af03bfa8c0b2a480810f4293c | Rear three-quarter No. 04 prototype racing at night in mist/yellow light | live image 11 resolves same filename at 2048×1365 | /content/dam/adlc-crowdstrike/racing/about-us/no-4-crowdstrike-oreca-07.png | Section 4 media |

## Metadata contract

Composer must write the source filename and SHA-256 into its fixture manifest. DAM metadata should include a useful title, rights/source attribution supplied by the project owner if available, and alt guidance:

- ASSET-001: informative; describe the three CrowdStrike Racing drivers celebrating.
- ASSET-003: informative; describe the No. 04 prototype racing at speed.
- ASSET-004: informative; describe the nighttime pit stop.
- ASSET-005: informative; describe the No. 04 prototype in a daylight race.
- ASSET-006: informative; describe the No. 04 prototype racing at night.
- ASSET-002: decorative when used as ambient brand art, therefore empty alt; informative only if it is the sole CrowdStrike identity mark.

Do not guess photographer credit or licensing. Rights confirmation is an owner responsibility before public production use; the user supplied the files for this implementation.

## Image delivery contract

- Preserve originals as DAM masters and let AEM generate delivery renditions.
- ASSET-001 is the LCP candidate: fetch priority high/eager, explicit intrinsic ratio, responsive focal point, and no JavaScript-delayed background-image loading.
- All below-fold section images: native lazy loading, explicit width/height or aspect-ratio, responsive srcset/Asset Delivery, and appropriate 1:1-ish phone crops only when the focal subject remains intact.
- Preferred quality target is visually lossless at the reference viewports, not pixel-identical transfer size. Modern WebP/AVIF delivery is allowed.
- Maximum delivered width should match rendered need and device density; the 2048px masters must not be served unchanged to 390px CSS layouts.

## Visual token evidence

Browser computed-style capture was blocked by the corporate Zscaler gateway. Therefore:

- Observed directly: black/white/high-chroma red brand palette; crimson-purple vehicle livery; full-bleed photographic treatment; wide cinematic hero with a built-in black title field; bold condensed/compact display character; clean sans-serif body character.
- Architecture recommendation, to be measured by Designforge: content max width near 1200-1280px, desktop gutters 48-64px, tablet 32px, phone 20-24px; section vertical rhythm 72-112px desktop and 40-64px phone.
- Not yet an exact acceptance token: font family/file, pixel font sizes, exact hex values, border thickness/radius, source site's actual media-query numbers.

Designforge must convert the second group into measured tokens from an approved browser session or screenshots and record evidence. Sentinel compares against those frozen tokens, not against an invented exact value in this Plan artifact.

