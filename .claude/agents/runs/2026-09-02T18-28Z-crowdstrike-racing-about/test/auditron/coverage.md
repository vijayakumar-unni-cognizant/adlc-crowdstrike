# Auditron Coverage Ledger — CrowdStrike Racing About

- **status:** FAIL
- **run:** 2026-09-02T18-28Z-crowdstrike-racing-about
- **url:** 

> Functional test cases: **30 total — 0 auditron_executed, 0 deferred_to_sentinel, 30 blocked**. JaCoCo was not produced because the mandatory build was correctly withheld.

## Scores

- TC attribution: **100** (30/30 reconciled)
- Executed: **0** (review gate blocked)

## Track matrix

| Track | Verdict | Detail |
|---|---|---|
| Functional-TC ledger | COMPLETE | Every TC-001..TC-030 has a concrete blocking reason |
| JaCoCo | NOT AVAILABLE | No Maven build after failed review |

## Functional-TC attribution ledger

| ID | Bucket | Evidence |
|---|---|---|
| TC-001 | blocked | AUD-HDR-001 review gate |
| TC-002 | blocked | AUD-HDR-001 review gate |
| TC-003 | blocked | AUD-HDR-001 review gate |
| TC-004 | blocked | AUD-HDR-001 review gate |
| TC-005 | blocked | AUD-HDR-001 review gate |
| TC-006 | blocked | AUD-HDR-001 review gate |
| TC-007 | blocked | AUD-HDR-001 review gate |
| TC-008 | blocked | AUD-HDR-001 review gate |
| TC-009 | blocked | AUD-HDR-001 review gate |
| TC-010 | blocked | AUD-HDR-001 review gate |
| TC-011 | blocked | AUD-HDR-001 review gate |
| TC-012 | blocked | AUD-HDR-001 review gate |
| TC-013 | blocked | AUD-HDR-001 review gate |
| TC-014 | blocked | AUD-HDR-001 review gate |
| TC-015 | blocked | AUD-HDR-001 review gate |
| TC-016 | blocked | Direct public/internal URL mismatch |
| TC-017 | blocked | AUD-HDR-001 review gate |
| TC-018 | blocked | AUD-HDR-001 review gate |
| TC-019 | blocked | AUD-HDR-001 review gate |
| TC-020 | blocked | AUD-HDR-001 review gate |
| TC-021 | blocked | AUD-HDR-001 review gate |
| TC-022 | blocked | AUD-HDR-001 review gate |
| TC-023 | blocked | AUD-HDR-001 review gate |
| TC-024 | blocked | AUD-HDR-001 review gate |
| TC-025 | blocked | AUD-HDR-001 review gate |
| TC-026 | blocked | AUD-HDR-001 review gate |
| TC-027 | blocked | AUD-HDR-001 review gate |
| TC-028 | blocked | AUD-HDR-001 review gate |
| TC-029 | blocked | AUD-HDR-001 review gate |
| TC-030 | blocked | AUD-HDR-001 review gate |

JaCoCo is unavailable because this correctly halted run did not execute Maven; code coverage does not substitute for this ledger.

## Iteration 3 supersession

| ID set | Bucket | Evidence |
|---|---|---|
| TC-016 | auditron_executed (fail) | Maven Build Gate #2: `marksPublicRouteCurrentForInternalAemPath` expected true but was false |
| TC-001–TC-015, TC-017–TC-030 | blocked | `BLD-HDR-002`; both allowed Maven calls are exhausted |

Final ledger: 30 total — 1 auditron_executed, 0 deferred_to_sentinel, 29 blocked. JaCoCo is unavailable because a failing unit suite does not produce a passing coverage gate.
