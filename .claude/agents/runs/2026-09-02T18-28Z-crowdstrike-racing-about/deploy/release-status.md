# Release status — paused for evidence correction

Run: `2026-09-02T18-28Z-crowdstrike-racing-about`  
Status: **PAUSED — release-evidence correction required before promotion**

## Author-local validation

Auditron recorded a local **PASS** against Author:

- Core bundle: `ADLC Crowdstrike - Core`, state `Active`.
- Unit tests: 8/8 passed.
- Local integration tests: 5/5 passed.
- `/content/adlc-crowdstrike/us/en/about-us.html`: HTTP 200, one H1, four editorial H2s, no reported exceptions.
- Header/footer Experience Fragments and custom chrome render; all five Teasers are present; required content and `aria-current="page"` are verified.

Publish validation is explicitly waived for local validation. It has **not** been executed or inferred.

## Pull request

- Branch: `feature/crowdstrike-racing-about-page`
- Pushed head/evidence commit: `c9d960e`
- Pull request: https://github.com/vijayakumar-unni-cognizant/adlc-crowdstrike/pull/1
- Feature implementation commit: `682e25c` (`feat: add CrowdStrike Racing about page`)

## Promotion hold

See [release-evidence-correction.md](release-evidence-correction.md). Do not merge/promote on the basis of the current PR evidence until the correction is completed and reviewed. Sentinel has not been dispatched.

