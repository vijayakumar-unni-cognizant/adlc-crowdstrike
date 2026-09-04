# Sentinel coverage matrix

All totals were censused directly from the Designforge files: UI=20, AUTH=16, TC=30. Auditron already passed 22 TC IDs; Sentinel owns the eight listed below. A launch or partial probe is never counted as a pass.

| Set | Total | Sentinel result | Auditron carried pass | Fail | Blocked / incomplete |
| --- | ---: | ---: | ---: | ---: | ---: |
| UI scenarios | 20 | 20 launched across configured Publish projects; UI-018/019 separately require Author | 0 | 6 confirmed IDs (001, 004, 005, 009, 012, 015) | 14 without terminal runner evidence; UI-018/019 bearer-harness blocked |
| Authoring cases | 16 | AUTH-001/002/009/011/015 read-back evidence | 2 (002, 011) | 0 | 14 (interactive/mutation or activation evidence unavailable) |
| Functional cases | 30 | TC-009,017,019,023,024,025,026,028 | 22 | 017,019,023,025,026 | 024,028; TC-009 visual structure observed but reference gate fails through shared visual findings |

## Sentinel functional case disposition

| ID | Status | Evidence / rationale |
| --- | --- | --- |
| TC-009 | fail | Hero structure/asset loads, but reference visual gate fails through encoding/logo/header defects. |
| TC-017 | fail | Retained mobile UI-005 artifact; full keyboard state completion is not evidenced. |
| TC-019 | fail | Rendered footer has two groups only; approved group/social/grid contract is unmet. |
| TC-023 | fail | 2048px 1.48MB master served at 358px mobile width; Lighthouse timings incomplete. |
| TC-024 | incomplete | Chromium desktop/mobile axe has zero critical/serious; required zoom/interaction/cross-engine sweep lacks terminal evidence. |
| TC-025 | fail | SSR is 200 but description/OG/public canonical/robots/sitemap requirements fail. |
| TC-026 | fail | Cross-browser/mobile suite has retained failures and no terminal completion summary. |
| TC-028 | incomplete | Author read-only page/template/XF evidence passes; editor-surface bearer session and dialog exercise not completed. |

## Authoring case disposition

`AUTH-001` is partially evidenced by the enabled Author template read-back. `AUTH-002` and `AUTH-011` are carried from Auditron. `AUTH-009` is partially evidenced by stored hero/editorial Teaser properties and policy/template read-back. `AUTH-015` is partially evidenced by Author and anonymous Publish 200 probes for the page/hero asset. Every interactive or temporary-mutation case (AUTH-003..008, AUTH-010, AUTH-012, AUTH-014, AUTH-016) remains incomplete, not passed.
