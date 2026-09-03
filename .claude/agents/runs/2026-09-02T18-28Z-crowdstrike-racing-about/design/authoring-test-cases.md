```ids: prefix=AUTH count=16 AUTH-001..AUTH-016 (no gaps)```

# Authoring-provision and data-setup test cases

| ID | executor | Owner | Asserted behavior / verification |
| --- | --- | --- | --- |
| AUTH-001 | sentinel | sentinel | On Author Create Page at project/us/en roots, `racing-page` appears and creates an About page; unrelated roots do not see it. Read back `cq:template` and page resource type. |
| AUTH-002 | auditron | composer | Read packaged/installed hierarchy: project, us, en, about-us are `cq:Page`; authored components are exactly at `root/container/hero/*` and `root/container/container/*`, not under root or an `nt:folder`. |
| AUTH-003 | sentinel | sentinel | Open `site-header` dialog and census every Brand/accessibility, Team and Primary field against `dialog-specifications.md`, including labels, widget types and requiredness; no field silently drops. |
| AUTH-004 | sentinel | sentinel | In `teamItems`, add `Pit Lane`, reorder it between Drivers/Schedule, remove it, save each state and read back ordered child nodes/DOM. Exactly one item per operation; original order restores. |
| AUTH-005 | sentinel | sentinel | Repeat add/remove/reorder/read-back for `primaryItems`; test internal and HTTPS paths and `openInNewTab`; safe rel renders for target-new. |
| AUTH-006 | sentinel | sentinel | Open `site-footer` dialog and census all Brand, Racing, CrowdStrike, Social and Legal fields, root upload vs inside-multifield pathfield types, labels and requiredness. |
| AUTH-007 | sentinel | sentinel | Add/remove/reorder one item independently in `racingLinks`, `whyLinks`, `socialLinks`, and `legalLinks`; stored child counts/order and rendered lists match, with no cross-list leakage. |
| AUTH-008 | sentinel | sentinel | Pick a DAM SVG/icon through `socialLinks/iconReference` (pathfield inside multifield), save, render accessible labelled link, clear it and verify text/fallback remains. |
| AUTH-009 | sentinel | sentinel | On hero and editorial Teasers, confirm Core title/description/action/delegated-image controls and Style System choices. Hero exposes only Hero style/h1 context; editorial exposes base+direction+surface and h2 context. |
| AUTH-010 | sentinel | sentinel | Author Section 4 as a paragraph plus unordered list; bold only labels; save/reopen. RTE retains one paragraph and exactly three list elements without table/image/script capability. |
| AUTH-011 | auditron | composer | Compare installed DAM binaries/metadata and manifest to all six source hashes/dimensions; verify five fileReferences resolve and Falcon is seeded but unused. Logo is local DAM-backed with provenance. |
| AUTH-012 | sentinel | sentinel | Read stored content rather than package source. Verify every exact inventory scalar and per-multifield count. Separator probe: the comma-bearing value `Engine: Gibson GK-428, 4.2-liter V8, approx. 600 hp` remains one RTE list item; save `Track, pit & paddock` as one temporary link label in a composite child, confirm one node/value, then revert. |
| AUTH-013 | auditron | composer | Redeploy/update semantics: change a seeded non-destructive marker in fixture input, deploy through the approved test mechanism, read installed node and render. The corrected property updates; document FileVault mode without broad replace/delete. |
| AUTH-014 | sentinel | sentinel | Edit-round-trip: change Section 3 title to a temporary value through Author, save, preview/read JCR, publish/verify delivery, then restore exact source value and republish. |
| AUTH-015 | sentinel | composer | Activation integrity: page, header/footer XFs, visible images and logo are published; anonymous Publish resolves each without author credentials, broken reference, or author-only placeholder. |
| AUTH-016 | sentinel | sentinel | Guardrails: attempt blank required hero title/header label/logo; omit optional CTA/Falcon/icon/list; empty one optional social list. Required state is rejected or safely suppressed; optional omission produces valid layout, no empty half, error, duplicate or “Please configure”. |

## Surface coverage

- Header dialog + two multifields: AUTH-003–AUTH-005.
- Footer dialog + four multifields + image modes: AUTH-006–AUTH-008.
- Core Teaser dialog/RTE/Style System: AUTH-009–AUTH-010.
- Template/content/DAM/data/redeploy/activation: AUTH-001–AUTH-002, AUTH-011–AUTH-016.

