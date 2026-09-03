# Auditron Build Gate — Teaser and Navigation Remediation

- **status:** FAIL
- **run:** 2026-09-02T18-28Z-crowdstrike-racing-about
- **url:** 

> The custom Teaser renderer and explicit active-navigation change are present on disk, but Maven build/deploy failed before packaging at BND manifest generation. No Author revalidation of these changes is valid.

## Track matrix

| Track | Verdict | Detail |
|---|---|---|
| Source remediation presence | PASS | Custom Teaser HTL and header active Boolean are on disk |
| Build/deploy | FAIL | bnd-maven-plugin Calc manifest failure at filters/package-info.class |
| Author revalidation | NOT RUN | New sources were not deployed |
| Publish | WAIVED | User waived local Publish |

## Findings

### [HIGH] BLD-BND-001 — BND manifest calculation fails before package/deploy
- **Issue:** The build cannot produce a validated core bundle after the latest remediation.
- **Evidence:** mvn clean install -PautoInstallSinglePackage exit=1; bnd-maven-plugin:bnd-process reports ‘Calc manifest failed’ at core/target/classes/com/adlccrowdstrike/aem/core/filters/package-info.class.
- **Cause:** BND/package metadata must be diagnosed from the core bundle configuration and the affected package-info source; the Maven tail does not provide a narrower root cause.
- **Recommended fix:** Blockwright should inspect the affected package-info and BND export/import configuration, fix the manifest calculation, then request a new Auditron build/deploy before claiming Teaser or navigation remediation is deployed.
- **Route:** blockwright
- **Status:** open — release-blocking
