# UI-test harness

The archetype Cypress source/configuration was replaced with Playwright 1.49.1. The Docker image tag and package version match. It defines anonymous Publish and authenticated Author projects from environment variables; no host or credentials are committed. Specs UI-001 through UI-020 each have an individual file under `ui.tests/test-module/tests/`.

Remediation validation completed on 2026-09-03: `npm install` regenerated `package-lock.json`; `npx playwright test --list` exited 0 and discovered 100 project-expanded tests from 20 spec files; `npx eslint .` exited 0. No live UI execution, local SDK Style-System smoke, or Maven invocation occurred.
