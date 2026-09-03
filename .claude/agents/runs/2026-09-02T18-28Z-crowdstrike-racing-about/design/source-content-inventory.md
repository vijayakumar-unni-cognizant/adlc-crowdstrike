# Source content inventory — verbatim field oracle

Source: `https://crowdstrikeracing.com/about-us/` (re-fetched 2026-09-02). The current 2026 branch is authoritative. The later crawler-visible branch beginning with “We stop breaches” and the 2023 duplicate legal/footer branch are excluded. Markup, CSS, classes, and scripts are not copied.

| Target field | Source location | Exact source value | Fidelity | Note/rendered role |
| --- | --- | --- | --- | --- |
| `header.teamLabel` | Header primary item | `The Team` | verbatim | Top-level disclosure label |
| `header.teamUrl` | Header | `/sports-car/teams-and-drivers/` | derived | Source-resolved internal destination |
| `header.teamItems[0].label` | The Team submenu 1 | `Drivers` | verbatim | Submenu link text |
| `header.teamItems[0].url` | The Team submenu 1 | `/sports-car/teams-and-drivers/` | derived | Source-resolved href |
| `header.teamItems[1].label` | The Team submenu 2 | `Schedule` | verbatim | Submenu link text |
| `header.teamItems[1].url` | The Team submenu 2 | `/sports-car/schedules/` | derived | Source-resolved href |
| `header.teamItems[2].label` | The Team submenu 3 | `Awards` | verbatim | Submenu link text |
| `header.teamItems[2].url` | The Team submenu 3 | `/sports-car/awards/` | derived | Source-resolved href |
| `header.primaryItems[0].label` | Header item after The Team | `CXO Summits` | verbatim | Primary nav link |
| `header.primaryItems[0].url` | Header | `/cxo-summits/` | derived | Source-resolved href |
| `header.primaryItems[1].label` | Header | `Photo Gallery` | verbatim | Primary nav link |
| `header.primaryItems[1].url` | Header | `/photo-gallery/` | derived | Source-resolved href |
| `header.primaryItems[2].label` | Header | `About Us` | verbatim | Primary nav/current-page link |
| `header.primaryItems[2].url` | Header | `/about-us/` | derived | Source-resolved href |
| `header.navigationLabel` | Header nav accessible name | `Primary navigation` | invented-by-necessity | Source exposes no accessible-name string; localizable UI requirement |
| `header.menuLabel` | Mobile control | `Menu` | invented-by-necessity | Required accessible control label; source parser exposes no text |
| `header.closeLabel` | Mobile control | `Close menu` | invented-by-necessity | Required accessible state label |
| `header.logoAlt` | Current footer/header logo asset | `CrowdStrike Racing Logo` | verbatim | Source image alternative; header brand-home link |
| `hero.jcr:title` | Current hero | `About Us` | verbatim | The page's only `<h1>` |
| `hero.fileReference` | Current hero image 6 | `/content/dam/adlc-crowdstrike/racing/about-us/about-us-hero-interior.png` | derived | Local DAM mapping of exact ASSET-001 |
| `hero.imageAlt` | Visual content | `CrowdStrike Racing drivers celebrating together after a win` | invented-by-necessity | Concise contextual alternative; source has generic “Image” |
| `section1.jcr:title` | Current section 1 | `We Stop Breaches` | verbatim | `<h2>` |
| `section1.jcr:description` | Current section 1 | `CrowdStrike has redefined modern security with the industry’s most advanced agentic security platform, unifying protection across endpoints, cloud workloads, identity, and data. The CrowdStrike Falcon Platform brings AI-driven automation and real-time intelligence to the SOC, combining human expertise with machine-speed action to stop breaches and protect the people, organizations, and technologies shaping the future.` | verbatim | Rich description paragraph |
| `section1.actions[0].text` | Current section 1 CTA | `Learn more about CrowdStrike` | verbatim | CTA accessible name |
| `section1.actions[0].link` | Current section 1 CTA | `https://www.crowdstrike.com/` | verbatim | External authored URL |
| `section1.fileReference` | Current image 8 | `/content/dam/adlc-crowdstrike/racing/about-us/we-stop-breaches.png` | derived | Exact ASSET-003 |
| `section1.imageAlt` | Visual content | `No. 04 CrowdStrike prototype racing at speed` | invented-by-necessity | Source has generic “Image” |
| `section2.jcr:title` | Current section 2 | `Why We Race` | verbatim | `<h2>` |
| `section2.jcr:description.p1` | Current section 2 paragraph 1 | `Performance under pressure defines both cybersecurity and world-class racing. Speed, agility, and resilience are critical when staying ahead of rapidly-evolving threats, on and off the track.` | verbatim | First rich-text paragraph |
| `section2.jcr:description.p2` | Current section 2 paragraph 2 | `CrowdStrike, in partnership with AWS, convenes C-level cybersecurity leaders at premier race weekends around the world to explore how operational excellence and teamwork drive sustained performance in high-stakes environments.` | verbatim | Second rich-text paragraph |
| `section2.fileReference` | Current image 9 | `/content/dam/adlc-crowdstrike/racing/about-us/why-we-race.png` | derived | Exact ASSET-004 |
| `section2.imageAlt` | Visual content | `CrowdStrike Racing crew performing a nighttime pit stop on the No. 04 car` | invented-by-necessity | Source has generic “Image” |
| `section3.jcr:title` | Current section 3 | `CrowdStrike Racing by APR` | verbatim | `<h2>` |
| `section3.jcr:description` | Current section 3 | `CrowdStrike Racing competes globally in premier sports car championships in the LMP2 prototype class. In IMSA competition, the team partners with technical powerhouse APR (Algarve Pro Racing) as “CrowdStrike Racing by APR.” The partnership has delivered landmark victories, including a class win at the 2026 24 Hours of Daytona and championship-winning success in the Asian Le Mans Series. Together, CrowdStrike Racing by APR continues to set the pace in prototype endurance racing worldwide.` | verbatim | Rich description paragraph |
| `section3.fileReference` | Current image 10 | `/content/dam/adlc-crowdstrike/racing/about-us/crowdstrike-racing-by-apr.png` | derived | Exact ASSET-005 |
| `section3.imageAlt` | Visual content | `No. 04 CrowdStrike prototype competing in a daylight race` | invented-by-necessity | Source has generic “Image” |
| `section4.jcr:title` | Current section 4 | `No. 4 CrowdStrike Oreca 07` | verbatim | `<h2>` |
| `section4.jcr:description.p1` | Current section 4 | `The ORECA 07 is a closed-cockpit sports car built to the current Le Mans Prototype 2 (LMP2) technical regulations. The car is present in all major championships sanctioned by the FIA and ACO (Automobile Club de l’Ouest) with more than 30 victories around the world.` | verbatim | Rich description paragraph |
| `section4.jcr:description.li1` | Current specifications 1 | `Engine: Gibson GK-428, 4.2-liter V8, approx. 600 hp` | verbatim | First semantic `<li>`; bold `Engine:` optional formatting only |
| `section4.jcr:description.li2` | Current specifications 2 | `Gearbox: 6-speed sequential Xtrac 1152 with paddle-shift system` | verbatim | Second semantic `<li>` |
| `section4.jcr:description.li3` | Current specifications 3 | `Chassis: Carbon fiber and honeycomb monocoque` | verbatim | Third semantic `<li>` |
| `section4.fileReference` | Current image 11 | `/content/dam/adlc-crowdstrike/racing/about-us/no-4-crowdstrike-oreca-07.png` | derived | Exact ASSET-006 |
| `section4.imageAlt` | Visual content | `No. 04 CrowdStrike prototype racing through mist at night` | invented-by-necessity | Source has generic “Image” |
| `footer.racingGroupTitle` | Footer group 1 | `CrowdStrike Racing` | verbatim | Footer group heading |
| `footer.racingLinks[0]` | Footer group 1 link 1 | `Home` → `/` | verbatim/derived | Label verbatim; href source-resolved |
| `footer.racingLinks[1]` | Footer group 1 link 2 | `Swag Shop` → `https://www.crowdstrikeswag.com/` | verbatim | Exact label/resolved destination |
| `footer.whyGroupTitle` | Footer group 2 | `Why CrowdStrike?` | verbatim | Footer group heading |
| `footer.whyLinks[0]` | Footer group 2 link 1 | `About CrowdStrike` → `https://www.crowdstrike.com/` | verbatim/derived | Exact label; crawler exposes corporate domain |
| `footer.whyLinks[1]` | Footer group 2 link 2 | `Services` → `https://www.crowdstrike.com/en-us/services/` | verbatim/derived | Destination resolves from source link |
| `footer.whyLinks[2]` | Footer group 2 link 3 | `Industry Validation` → `https://www.crowdstrike.com/en-us/why-crowdstrike/crowdstrike-industry-validation/` | verbatim/derived | Destination resolves from source link |
| `footer.whyLinks[3]` | Footer group 2 link 4 | `Our Customers` → `https://www.crowdstrike.com/en-us/resources/customer-stories/` | verbatim/derived | Destination resolves from source link |
| `footer.socialGroupTitle` | Footer group 3 | `Follow us!` | verbatim | Footer group heading |
| `footer.socialLinks[0]` | Publicly indexed CrowdStrike Racing profile set | `X / Twitter` → `https://twitter.com/CrowdStrikeRcng` | derived | Source page exposes icon-only link; destination corroborated by indexed organization profile; validate live before seed |
| `footer.socialLinks[1]` | Publicly indexed CrowdStrike Racing profile set | `Instagram` → `https://www.instagram.com/crowdstrikeracing/` | derived | Same validation duty |
| `footer.socialLinks[2]` | Publicly indexed CrowdStrike Racing profile set | `Facebook` → `https://www.facebook.com/crowdstrikeracing/` | derived | Same validation duty |
| `footer.socialLinks[3]` | Publicly indexed CrowdStrike Racing profile set | `LinkedIn` → `https://www.linkedin.com/company/crowdstrike-racing` | derived | Same validation duty |
| `footer.copyrightText` | Current legal row | `Copyright © 2025` | verbatim | 2023 duplicate is excluded |
| `footer.legalLinks[0].label` | Current legal row | `Privacy` | verbatim | Preserve source order; href must be live-resolved before seed |
| `footer.legalLinks[1].label` | Current legal row | `Cookies` | verbatim | Preserve source order; href must be live-resolved before seed |
| `footer.legalLinks[2].label` | Current legal row | `Your Privacy Choices` | verbatim | Preserve source order; href must be live-resolved before seed |
| `footer.legalLinks[3].label` | Current legal row | `Terms of Use` | verbatim | Preserve source order; href must be live-resolved before seed |
| `footer.legalLinks[4].label` | Current legal row | `Accessibility` | verbatim | Preserve source order; source internal `/about-us/` target is suspicious and must be browser-verified |
| `page.jcr:title` | Browser/page identity | `About Us` | verbatim | Page title base |
| `page.pageTitle` | Page metadata | `About Us | CrowdStrike Racing` | invented-by-necessity | Unique SEO title; source crawler supplies no `<title>` value |
| `page.description` | Page metadata | `Learn how CrowdStrike Racing brings speed, resilience and teamwork together on the track and in cybersecurity.` | invented-by-necessity | Concise source-derived meta description; no new factual claim |

## Declared content gaps

The live parser does not expose the five legal hrefs or accessible names for icon-only social links. Their **visible values and order are complete above**; Composer must resolve hrefs against the live page in an approved browser and record them in the seeding report. A missing or unverified href is an explicit gap and must not be replaced with `#`, JavaScript, or guessed placeholder content.

