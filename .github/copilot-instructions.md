# GitHub Copilot instructions — Lunar (AEM as a Cloud Service)

All project context, module layout, build commands, AEMaaCS guardrails, the ADLC
agent roster, and the **Model Routing Matrix** live in the repository's single
source of truth:

@AGENTS.md

Read that file first. Nothing is duplicated here.

## ADLC agents

This repository runs the **Agentified Delivery Life Cycle (ADLC)** — one
orchestrator plus nine specialists. Two rules:

1. **Every agent's prompt logic lives in `.claude/agents/<name>.md`** and nowhere
   else. That directory is the shared source for Claude Code, Copilot CLI, and
   Codex CLI. **Never edit it** — a change there changes all three tools at once.
2. **The Copilot agent files in `.github/agents/*.agent.md` are generated**
   pointer shims. Never hand-edit them; they are overwritten by
   `node scripts/sync-agent-routing.mjs`. To change routing, edit
   [.agent-routing.json](../.agent-routing.json) and re-run that script.

The lifecycle contract is @.claude/agents/ADLC-SPEC.md.
Project identifiers (`<project>`, `<package>`, `<group>`) come from
@.aem-skills-config.yaml — never infer them from the filesystem.

## Model selection

See the Model Routing Matrix in @AGENTS.md for the per-agent model mapping.

Per-agent `model:` frontmatter in `.github/agents/*.agent.md` is **declarative
intent**: GitHub documents the property, but documents its model-selection
effect only for VS Code, JetBrains, Eclipse, and Xcode — not for the CLI. To
guarantee the intended model in Copilot CLI, set it at session level:

```bash
copilot --model="GPT-5.5"              # Deep Reasoning tier (strategist, designforge)
copilot --model="GPT-5.4"              # Orchestrator, Execution, Quality Gate tiers
copilot --model="GPT-5.4 mini"         # Utility / Release tier (pilot)
```

`COPILOT_MODEL` and the in-session `/model` command are equivalent mechanisms.

## Hard constraints

- **Maven budget:** at most **2** `mvn` invocations per ADLC run, owned
  exclusively by `auditron` (Build Validation Gate + integration tests). Every
  invocation uses `-q` and reads back only a `tail`. All other agents verify
  statically via read/grep/glob. Never read a build log into context.
- Prefer extending an existing project component or an Adobe Core Component
  before creating a new one; chain Core Component extensions through the project
  proxy under `apps/<project>/components/`.
- This is **AEM as a Cloud Service**, not AMS or on-prem — use only the curated
  resources listed in @AGENTS.md.
- Sample content belongs in `ui.content` (mutable), never `ui.apps` (immutable).
