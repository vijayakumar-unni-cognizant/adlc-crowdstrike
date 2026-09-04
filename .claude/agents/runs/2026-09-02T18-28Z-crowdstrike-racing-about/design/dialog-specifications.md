# Dialog specifications — confirmation candidate

Resource types were checked against `.claude/skills/create-component/assets/field-type-mappings.md`, `references/dialog-patterns.md`, and Designforge D20. Structural shell types are exact. No dialog XML is produced here.

## Shared structural shell

| Node purpose | Verified resource type |
| --- | --- |
| Dialog root | `cq/gui/components/authoring/dialog` |
| Content/tab container/multifield field | `granite/ui/components/coral/foundation/container` |
| Tabs | `granite/ui/components/coral/foundation/tabs` |
| Fixed columns | `granite/ui/components/coral/foundation/fixedcolumns` |
| Text | `granite/ui/components/coral/foundation/form/textfield` |
| Link/path | `granite/ui/components/coral/foundation/form/pathfield` |
| Boolean | `granite/ui/components/coral/foundation/form/checkbox` |
| List | `granite/ui/components/coral/foundation/form/multifield` with `composite=true` |
| Root-level DAM image | `granite/ui/components/coral/foundation/form/upload` per mandatory D20; `allowUpload=false`, `mimeTypes=[image/.*]` |

The local field mapping also shows legacy `cq/gui/components/authoring/dialog/fileupload`; do not use it for these root-level image-reference fields because D20's current contract is more specific. Image references inside composite multifields use verified `granite/ui/components/coral/foundation/form/pathfield` only.

## Proposed dialog: `site-header`

### Tab `Brand & accessibility`

| Property | Type | Label / description | Default / validation |
| --- | --- | --- | --- |
| `./logoReference` | root-level upload | `Logo` — DAM asset preview/drag target | required; `allowUpload=false`; `/content/dam` source; image mime only |
| `./logoAlt` | textfield | `Logo alternative text` | required; default `CrowdStrike Racing Logo`; 1–120 chars |
| `./homeUrl` | pathfield | `Brand home link` | required; root `/content`; URL/path validation |
| `./navigationLabel` | textfield | `Navigation accessible label` | required; default `Primary navigation` |
| `./menuLabel` | textfield | `Mobile menu label` | required; default `Menu` |
| `./closeLabel` | textfield | `Mobile close label` | required; default `Close menu` |

### Tab `The Team submenu`

| Property | Type | Label / description | Default / validation |
| --- | --- | --- | --- |
| `./teamLabel` | textfield | `Top-level label` | required; `The Team` |
| `./teamUrl` | pathfield | `Top-level destination` | optional; root `/content`; falls back to first child only if documented |
| `./teamItems` | composite multifield | `Submenu links`; child container has fields below | required; min 1; seeded count 3; add/remove/reorder |
| `./label` (inside item) | textfield | `Link label` | required; 1–80 chars |
| `./url` (inside item) | pathfield | `Link destination` | required; internal path or HTTPS |
| `./openInNewTab` (inside item) | checkbox | `Open in new tab` | false; external-only guidance |

### Tab `Primary links`

| Property | Type | Label / description | Default / validation |
| --- | --- | --- | --- |
| `./primaryItems` | composite multifield | `Links after The Team` | required; seeded count 3; add/remove/reorder |
| `./label` (inside item) | textfield | `Link label` | required |
| `./url` (inside item) | pathfield | `Link destination` | required; path/HTTPS |
| `./openInNewTab` (inside item) | checkbox | `Open in new tab` | false |

Current-page state is computed and is deliberately not authorable.

## Proposed dialog: `site-footer`

### Tab `Brand`

| Property | Type | Label / description | Default / validation |
| --- | --- | --- | --- |
| `./logoReference` | root-level upload | `Footer logo` | required; `allowUpload=false`; image mime only |
| `./logoAlt` | textfield | `Logo alternative text` | required; `CrowdStrike Racing Logo` |
| `./homeUrl` | pathfield | `Logo destination` | required |
| `./falconReference` | root-level upload | `Optional Falcon artwork` | optional; canonical instance empty; `allowUpload=false`; image mime only |
| `./falconDecorative` | checkbox | `Treat Falcon artwork as decorative` | true; relevant only when reference exists |

### Tab `Racing links`

| Property | Type | Label / description | Default / validation |
| --- | --- | --- | --- |
| `./racingGroupTitle` | textfield | `Group heading` | required; `CrowdStrike Racing` |
| `./racingLinks` | composite multifield | `Racing links` | required; seeded count 2 |
| `./label`, `./url`, `./openInNewTab` (inside item) | textfield, pathfield, checkbox | Link fields | label+URL required; add/remove/reorder |

### Tab `CrowdStrike links`

| Property | Type | Label / description | Default / validation |
| --- | --- | --- | --- |
| `./whyGroupTitle` | textfield | `Group heading` | required; `Why CrowdStrike?` |
| `./whyLinks` | composite multifield | `Corporate links` | required; seeded count 4 |
| `./label`, `./url`, `./openInNewTab` (inside item) | textfield, pathfield, checkbox | Link fields | label+URL required; add/remove/reorder |

### Tab `Social`

| Property | Type | Label / description | Default / validation |
| --- | --- | --- | --- |
| `./socialGroupTitle` | textfield | `Group heading` | required; `Follow us!` |
| `./socialLinks` | composite multifield | `Social destinations` | optional list; seeded count 4 only after live validation |
| `./label` (inside item) | textfield | `Accessible name` | required |
| `./url` (inside item) | pathfield | `Destination` | required HTTPS |
| `./iconReference` (inside multifield → pathfield) | pathfield | `Optional DAM icon` | root `/content/dam`; this is the permitted multifield image exception |
| `./openInNewTab` (inside item) | checkbox | `Open in new tab` | true; renderer adds safe rel |

### Tab `Legal`

| Property | Type | Label / description | Default / validation |
| --- | --- | --- | --- |
| `./copyrightText` | textfield | `Copyright text` | required; exact inventory value |
| `./legalLinks` | composite multifield | `Legal links` | required; seeded count 5; preserve order |
| `./label`, `./url`, `./openInNewTab` (inside item) | textfield, pathfield, checkbox | Link fields | label+URL required; no placeholders |

## Reused Core proxies

### `teaser`

No custom dialog. Inherit Core Teaser v2 tabs `properties` and `actions`. Required authoring surfaces: title, description RTE, link actions, delegated Core Image asset selector/alt, and Style System. Policy restricts hero/editorial heading types and RTE plugins. Root-level image selection remains Core Image's inherited supported drop target; Blockwright must not recreate it.

### `container`

No custom dialog. Inherit Core Container v1 `properties`/policy and Style System. Background uploads are disabled; only approved layout styles are visible.

### `experiencefragment`

No custom dialog. Inherit Core XF v2 fragment-variation picker. Template structure fixes the canonical paths.

## Confirmation summary for Program Agent

- `site-header`: Brand & accessibility; The Team submenu; Primary links.
- `site-footer`: Brand; Racing links; CrowdStrike links; Social; Legal.
- Core Teaser/Container/XF: inherited dialogs only, with policy/Style System constraints.

The Program Agent must present these tables at the mandatory human confirmation checkpoint before Blockwright scaffolds them.

