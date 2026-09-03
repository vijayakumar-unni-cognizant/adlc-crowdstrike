# Reference asset manifest

The intake's own requirement is a “faithfully matching” AEM page using the source URL and the images in `C:\Users\2489691\Downloads\crowdstrike-images`. Image identity and verbatim copy are exact; responsive rendition encoding/crop and inaccessible computed CSS are directional within `design-token-audit.md` tolerances.

| ID | Source | Role | Target/section | Match strictness |
| --- | --- | --- | --- | --- |
| REF-WEB-001 | `https://crowdstrikeracing.com/about-us/` | content-source-of-truth and visual reference | Entire page; header, hero, four editorial sections, footer, responsive behavior | Exact for current-2026 visible copy/order/link labels; directional for visual tokens until approved-browser capture; never copy DOM/CSS/JS |
| REF-LOGO-001 | `https://assets.crowdstrike.com/is/content/crowdstrikeinc/Crowdstrike%20Racing%20Logo` | live SVG logo reference | `site-header.logoReference`, `site-footer.logoReference`, OG identity where appropriate | Exact artwork/alt. Mirror to project DAM; no runtime hotlink. Rights/provenance must be recorded |
| ASSET-001 | `C:\Users\2489691\Downloads\crowdstrike-images\D_ABOUTUS_Hero_Interior.png` | visual-and-asset-source-of-truth | Hero `fileReference` → `/content/dam/adlc-crowdstrike/racing/about-us/about-us-hero-interior.png` | Exact SHA-256 `9a5e158d8dcccb5719083c14bab67b175a3769c9da07d0732d82365f9fac50ad`, `2048×744`; rendition/crop directional, subjects retained |
| ASSET-002 | `C:\Users\2489691\Downloads\crowdstrike-images\Falcon-2.png` | supplied fixture / legacy-reference artwork | Seed → `/content/dam/adlc-crowdstrike/racing/about-us/falcon-2.png`; intentionally unused in canonical visible page | Exact SHA-256 `318b3fd04e59ff7a3d0f4f540e43e2116fe7060e59e8093a5ae127f6e6dac87c`, `408×320`. Do not surface unless later approved; canonical current footer uses logo, not this legacy art |
| ASSET-003 | `C:\Users\2489691\Downloads\crowdstrike-images\we-stop-breaches.png` | section image source-of-truth | Section 1 `fileReference` | Exact SHA-256 `61ed18b24fb8f4b2708416bf556129e6f5e71057f07ff96812d397bd9e11e894`, `1024×683`; crop retains car |
| ASSET-004 | `C:\Users\2489691\Downloads\crowdstrike-images\why-we-race.png` | section image source-of-truth | Section 2 `fileReference` | Exact SHA-256 `f1db05f88fb38a65e99fcd4084f07ff769a83b73541a11ae1c7d1f8803db5e1a`, `1024×683`; crop retains crew/car/action |
| ASSET-005 | `C:\Users\2489691\Downloads\crowdstrike-images\IMSAROLEX26_01_23_26_111222_FH_8052.png` | section image source-of-truth | Section 3 `fileReference` → renamed DAM node | Exact SHA-256 `51dc757779c11c8dfaa31b8f82b0c203bb8ea3abe2c796616772d34a2d9b4614`, `2048×1365`; crop retains whole car |
| ASSET-006 | `C:\Users\2489691\Downloads\crowdstrike-images\IMSA_D24_26_01_25_001036_JP35529.png` | section image source-of-truth | Section 4 `fileReference` → renamed DAM node | Exact SHA-256 `9db6dc808f0a7cf554caff3c5ba656108cd20f7af03bfa8c0b2a480810f4293c`, `2048×1365`; crop retains rear three-quarter car/yellow light |

All masters are preserved; delivered pages use AEM responsive modern renditions. ASSET-001 is eager/high priority with intrinsic geometry. ASSET-003–006 are lazy with intrinsic dimensions. No runtime request may target `crowdstrikeracing.com`, `assets.crowdstrike.com`, `scene7.com`, or the Downloads folder.

