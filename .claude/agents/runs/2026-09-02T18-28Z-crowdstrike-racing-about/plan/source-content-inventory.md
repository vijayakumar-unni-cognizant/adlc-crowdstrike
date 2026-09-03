# Source content inventory

Run: 2026-09-02T18-28Z-crowdstrike-racing-about  
Source: https://crowdstrikeracing.com/about-us/  
Role: content-source-of-truth  
Inspected: 2026-09-02

## Canonical branch decision

The crawl exposes two generations of content plus duplicated responsive footer markup. The first branch is canonical for this run because it is the current, internally coherent 2026 story, it names the 2026 Daytona result, and every one of its five page images has an exact supplied local-file match. The later branch uses older messaging and additional remote assets that were not supplied. Do not merge the branches.

The inventory below deliberately paraphrases long body passages while preserving every short visible label, fact, destination, order, and source locator. Composer must transcribe long-form copy from the named live line range at authoring time; it must not generate substitute brand prose. Auditron and Sentinel use the locator plus section identity to independently check the delivered page.

## Visible inventory

| ID | Region | Type | Canonical visible value / content contract | Source locator | Test oracle |
| --- | --- | --- | --- | --- | --- |
| SRC-001 | Header | primary navigation label | The Team | live lines 2, 14 | Exact visible label and order |
| SRC-002 | Header | submenu labels | Drivers; Schedule; Awards | live lines 8-18 | Exact labels, hierarchy, destinations |
| SRC-003 | Header | primary navigation labels | CXO Summits; Photo Gallery; About Us | live lines 20-22 | Exact labels and order; About Us current |
| SRC-004 | Header | behavior | Desktop submenu plus compact mobile menu; semantic current-page state | runtime source reference | Keyboard, Escape, focus order, aria state |
| SRC-005 | Hero | h1 | About Us | live lines 24-31 | Exactly one h1; image ASSET-001 |
| SRC-006 | Hero | decorative/visual | Wide winners photograph with purpose-built black left gradient for title | live image 6 | Exact hash mapping to ASSET-001 |
| SRC-007 | Section 1 | h2 | We Stop Breaches | live lines 31-35 | Exact case; precedes Why We Race |
| SRC-008 | Section 1 | body | Preserve the source statement about CrowdStrike's agentic security platform, unified protection domains, AI automation, intelligence, and stopping breaches. | live line 33 | Text normalized from live source, no invented claims |
| SRC-009 | Section 1 | CTA | Learn more about CrowdStrike → https://www.crowdstrike.com/ | live line 35 | Exact accessible name and external URL; image ASSET-003 |
| SRC-010 | Section 2 | h2 | Why We Race | live lines 38-46 | Exact case; image ASSET-004 |
| SRC-011 | Section 2 | body | Preserve both source paragraphs: performance-under-pressure parallels, then the CrowdStrike/AWS C-level race-weekend program and teamwork outcome. | live lines 43-46 | Two paragraphs, normalized live text, no invented claims |
| SRC-012 | Section 3 | h2 | CrowdStrike Racing by APR | live lines 47-51 | Exact heading; image ASSET-005 |
| SRC-013 | Section 3 | body | Preserve the source facts: global LMP2 competition, APR partnership, 2026 Daytona class victory, Asian Le Mans success, and continuing endurance-racing ambition. | live line 50 | Normalized live text retains all named facts |
| SRC-014 | Section 4 | h2 | No. 4 CrowdStrike Oreca 07 | live lines 53-66 | Exact heading; image ASSET-006 |
| SRC-015 | Section 4 | body | Preserve the source description of the ORECA 07, current LMP2 regulations, FIA/ACO championships, and more than 30 victories. | live line 58 | Normalized live text retains all named facts |
| SRC-016 | Section 4 | specification | Engine: Gibson GK-428, 4.2-liter V8, approximately 600 hp | live line 61 | Semantic list item; preserve model/displacement/power |
| SRC-017 | Section 4 | specifications | Gearbox: six-speed sequential Xtrac 1152 with paddles; chassis: carbon-fiber/honeycomb monocoque | live lines 63-65 | Two semantic list items; preserve technical values |
| SRC-018 | Footer | groups and legal | CrowdStrike Racing; Why CrowdStrike?; Follow us!; brand mark; Home, Swag Shop, corporate/about/services/validation/customer links, social destinations, copyright/privacy/cookies/privacy choices/terms/accessibility | live lines 106-145 | One rendered footer only; links are keyboard reachable and named |

## Excluded source material

The following crawler-visible range is not to be seeded as page body for this run:

- Live lines 68-100: older duplicate sections beginning with a second We stop breaches and ending with We win as one.
- Live lines 121-145: duplicate responsive footer markup. Implement one semantic footer and adapt it with CSS/behavior.
- Third-party analytics, tag-manager, consent, and source-site implementation markup are not part of the content contract.

The exclusion is a source-backed architectural decision, not permission to invent content. If a browser capture proves any excluded block visible in the primary desktop, tablet, or phone state, Designforge must flag the mismatch at the architecture checkpoint before implementation.

## Link scope

All source destinations are content-managed links. They are not data integrations and do not activate Bridgesmith. Internal destinations may point at the matching future site path even when those pages are outside this run; external destinations remain authored absolute HTTPS URLs.

## Heading and landmark contract

- One header landmark, one main landmark, one footer landmark.
- One h1: About Us.
- Four body-section h2 headings in SRC-007, SRC-010, SRC-012, SRC-014 order.
- Footer group labels are headings beneath the body hierarchy; they must not introduce another h1.
- A skip link is the first keyboard-focusable item.

