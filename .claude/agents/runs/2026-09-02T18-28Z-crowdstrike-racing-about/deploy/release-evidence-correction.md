# Release-evidence correction — required before promotion

Status: **blocking release-evidence correction**

## Evidence

Commit `c9d960e` (`docs: add ADLC delivery run evidence`) was pushed to `feature/crowdstrike-racing-about-page` and is included in PR #1. Its observed scope is 355 files, 52,226 insertions, and 3 deletions.

In addition to the intended run evidence below `.claude/agents/runs/2026-09-02T18-28Z-crowdstrike-racing-about/`, it includes unrelated, pre-staged toolchain content such as:

- `.claude/agents/**` contracts and reference templates;
- `.claude/skills/**` skill packages and references;
- `.codex/**` agent/configuration files;
- `.github/**` agent instructions; and
- supporting repository/tooling files including `.claude/SHARE-CHECKLIST.md` and `.gitignore`.

The intended page implementation is separately represented by commit `682e25c` (`feat: add CrowdStrike Racing about page`). At record time, the worktree also has untracked `.env` and four Core model/test files; their content is deliberately not represented as released evidence.

## Required correction before promotion

1. Review the PR diff and split/revert the unrelated pre-staged toolchain material in a deliberate correction commit or clean replacement branch; preserve only approved product changes and the minimal run evidence required for review.
2. Review and intentionally stage or remove the untracked `.env` and Core model/test files. Never commit `.env` without an explicit secret review.
3. Update the PR description and re-request review with the corrected commit/range and a clear explanation of the scope correction.
4. Reconcile Auditron's reported `mvn_invocations: 7` against the normal two-call budget. Record the approver, reason, and each additional call if the extension is accepted.
5. Only after a human confirms the corrected PR scope may the normal Lead merge/deploy and real-environment validation process resume.

## Explicitly not performed

This record does not rewrite history, force-push, amend the PR, change merge state, dispatch Pilot/Sentinel, or claim Publish validation.

