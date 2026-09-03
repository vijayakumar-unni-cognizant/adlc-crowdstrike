# Auditron Test Report — CrowdStrike Racing About

- **status:** FAIL
- **run:** 2026-09-02T18-28Z-crowdstrike-racing-about
- **url:** 

> Functional test cases: **30 total — 0 auditron_executed, 0 deferred_to_sentinel, 30 blocked**. Review gate failure means neither permitted Maven call was consumed.

## Track matrix

| Track | Verdict | Detail |
|---|---|---|
| Maven Build Validation Gate | NOT RUN | Call #1 withheld by AUD-HDR-001 |
| Maven integration tests | NOT RUN | Call #2 withheld; no local SDK deployment |
| Functional-TC attribution | COMPLETE | 30/30 IDs reconciled in blocked bucket |

## Functional test-case ledger

functional test cases: 30 total — 0 auditron_executed, 0 deferred_to_sentinel, 30 blocked.

Every ID is blocked by the same concrete reason: `AUD-HDR-001` is an unaccepted high review finding, so the contract prohibits Maven build, local-SDK and downstream tier validation until Blockwright remediates the header current-path comparison.

| ID | Bucket | Evidence |
|---|---|---|
| TC-001 | blocked | AUD-HDR-001 review gate blocks release validation |
| TC-002 | blocked | AUD-HDR-001 review gate blocks release validation |
| TC-003 | blocked | AUD-HDR-001 review gate blocks release validation |
| TC-004 | blocked | AUD-HDR-001 review gate blocks release validation |
| TC-005 | blocked | AUD-HDR-001 review gate blocks release validation |
| TC-006 | blocked | AUD-HDR-001 review gate blocks release validation |
| TC-007 | blocked | AUD-HDR-001 review gate blocks local SDK render |
| TC-008 | blocked | AUD-HDR-001 review gate blocks build/package validation |
| TC-009 | blocked | AUD-HDR-001 review gate blocks downstream release |
| TC-010 | blocked | AUD-HDR-001 review gate blocks local render check |
| TC-011 | blocked | AUD-HDR-001 review gate blocks package validation |
| TC-012 | blocked | AUD-HDR-001 review gate blocks local action check |
| TC-013 | blocked | AUD-HDR-001 review gate blocks local DOM check |
| TC-014 | blocked | AUD-HDR-001 review gate blocks local style check |
| TC-015 | blocked | AUD-HDR-001 review gate blocks local responsive check |
| TC-016 | blocked | Direct failure: public `/about-us/` cannot equal internal resource path |
| TC-017 | blocked | AUD-HDR-001 review gate blocks downstream release |
| TC-018 | blocked | AUD-HDR-001 review gate blocks local footer check |
| TC-019 | blocked | AUD-HDR-001 review gate blocks downstream release |
| TC-020 | blocked | AUD-HDR-001 review gate blocks unit/local fixture validation |
| TC-021 | blocked | AUD-HDR-001 review gate blocks package validation |
| TC-022 | blocked | AUD-HDR-001 review gate blocks local network check |
| TC-023 | blocked | AUD-HDR-001 review gate blocks downstream release |
| TC-024 | blocked | AUD-HDR-001 review gate blocks downstream release |
| TC-025 | blocked | AUD-HDR-001 review gate blocks downstream release |
| TC-026 | blocked | AUD-HDR-001 review gate blocks downstream release |
| TC-027 | blocked | AUD-HDR-001 review gate blocks build validation |
| TC-028 | blocked | AUD-HDR-001 review gate blocks downstream author validation |
| TC-029 | blocked | AUD-HDR-001 review gate blocks static gate completion |
| TC-030 | blocked | AUD-HDR-001 review gate blocks local DOM validation |

## Iteration 3 supersession

functional test cases: 30 total — 1 auditron_executed, 0 deferred_to_sentinel, 29 blocked.

`TC-016` was executed by Maven Build Gate call #2 and **failed**: `SiteHeaderModelTest.marksPublicRouteCurrentForInternalAemPath` returned `false` where the test expected `true`. `TC-001`–`TC-015` and `TC-017`–`TC-030` are blocked by `BLD-HDR-002` because Maven budget is exhausted after the failed second build.

Integration did not run: call #1 and call #2 were both build attempts, so no Maven capacity remains. The only reachable local tier was Author `http://localhost:4502`; Publish `http://localhost:4503` was unavailable.

## Extended validation supersession

The human authorized two additional Maven calls. Extended build evidence produced `all/target/adlc-crowdstrike.all-1.0.0-SNAPSHOT.zip` (7,661,144 bytes) and Surefire reports `8 tests, 0 failures, 0 errors`. Extended integration with `mvn -q -pl it.tests verify -Plocal` produced Failsafe `5 tests, 0 failures, 0 errors`.

The final result remains **FAIL**: direct Author rendering reports both Experience Fragment wrappers but zero `.cmp-site-header` / `.cmp-site-footer` nodes. Bundle `653` (`ADLC Crowdstrike - Core`) is `Installed`, not `Active`, and HTL reports `SiteHeaderModel cannot be resolved to a type`. This is `LCL-OSGI-001`, a release-blocking runtime defect.

## Author-only validation supersession

`LCL-OSGI-001` is resolved: bundle `653` is now `Active`; both custom XF endpoints render their components with no Sling Model exception. The user waived local Publish validation.

The gate remains **FAIL** on two new direct Author findings: `LCL-TEASER-002` (the four editorial Teasers render the page title rather than their authored source-exact headings/body) and `LCL-NAV-002` (public header routes are Link Checker-invalid, no About anchor/current state renders). See `iter5-report.md`.

## Targeted remediation revalidation

The one additional user-requested Maven build/deploy made the intended content visible on Author: all Teaser nodes have `title` values and editorial `jcr:description` values, and the About header URL is an internal AEM path. The rendered contract still fails: all Teaser H2s repeat `About Us | CrowdStrike Racing`, required editorial headings/body copy occur zero times, and the valid About anchor still has no `aria-current="page"` through the XF. Final blockers are `LCL-TEASER-003` and `LCL-NAV-003`; see `iter6-report.md`.

## Latest remediation build gate

The custom Teaser HTL and explicit `active=true` header item are present in source but **not deployed**: the user-requested build failed at `bnd-maven-plugin:bnd-process` with manifest calculation failure for `core/.../filters/package-info.class`. This is `BLD-BND-001`; no new Author rendering assertion can be made. See `iter7-report.md`.

## Final Author-only validation

The clean build/deploy supersedes `BLD-BND-001`. Author validation passes: core bundle `653` is Active; the all-package ZIP is rebuilt; Surefire reports 8 tests with 0 failures/errors; header/footer and both XF endpoints render without exceptions; all intended Teaser headings/body copy render; and the internal About anchor has `aria-current="page"` and the current-link class. Existing local-profile integration evidence remains 5 Failsafe tests with 0 failures/errors. Publish is explicitly waived. See `iter8-report.md`.
