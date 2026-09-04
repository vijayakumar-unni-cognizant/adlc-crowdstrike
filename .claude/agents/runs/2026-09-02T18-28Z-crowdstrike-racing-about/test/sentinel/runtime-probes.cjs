/* Sentinel evidence collector: report-only; does not change the application or test harness. */
const fs = require('fs');
const path = require('path');
const { chromium, firefox, webkit } = require('../../../../../../ui.tests/test-module/node_modules/@playwright/test');
const AxeBuilder = require('../../../../../../ui.tests/test-module/node_modules/@axe-core/playwright').default;

const out = __dirname;
const publish = process.env.AEM_PUBLISH_URL;
const author = process.env.AEM_AUTHOR_URL;
const token = process.env.AEM_AUTHOR_BEARER_TOKEN;
const pagePath = '/content/adlc-crowdstrike/us/en/about-us.html';
const result = { generated_at: new Date().toISOString(), publish, author, author_auth_mode: 'bearer-token', probes: [] };

async function inspect(browserType, label, viewport) {
  const browser = await browserType.launch();
  const context = await browser.newContext({ viewport, ignoreHTTPSErrors: true });
  const page = await context.newPage();
  const response = await page.goto(publish + pagePath, { waitUntil: 'networkidle', timeout: 60000 });
  const axe = await new AxeBuilder({ page }).withTags(['wcag2a', 'wcag2aa', 'wcag21a', 'wcag21aa']).analyze();
  const snapshot = await page.evaluate(() => ({
    status: document.readyState,
    title: document.title,
    h1: [...document.querySelectorAll('h1')].map(n => n.textContent.trim()),
    h2: [...document.querySelectorAll('h2')].map(n => n.textContent.trim()),
    hero: document.querySelectorAll('.cmp-teaser--racing-hero').length,
    editorial: document.querySelectorAll('.cmp-teaser--racing-editorial').length,
    headers: document.querySelectorAll('header').length,
    mains: document.querySelectorAll('main').length,
    footers: document.querySelectorAll('footer').length,
    canonical: document.querySelector('link[rel=canonical]')?.href || null,
    og: Object.fromEntries(['og:title','og:description','og:image','og:url'].map(k => [k, document.querySelector(`meta[property="${k}"]`)?.content || null])),
    description: document.querySelector('meta[name=description]')?.content || null,
    overflow: document.documentElement.scrollWidth > document.documentElement.clientWidth,
    images: [...document.images].map(i => ({ src: i.currentSrc || i.src, loading: i.loading, alt: i.alt, naturalWidth: i.naturalWidth, width: i.width, height: i.height })),
    cta: [...document.querySelectorAll('.cmp-teaser--racing-editorial a')].map(a => ({ text: a.textContent.trim(), href: a.href })),
    bodyText: document.body.innerText
  }));
  await page.screenshot({ path: path.join(out, `publish-${label}-${viewport.width}.png`), fullPage: true });
  result.probes.push({ tier: 'publish', engine: label, viewport, http_status: response?.status(), ...snapshot, axe: { violations: axe.violations.map(v => ({ id: v.id, impact: v.impact, nodes: v.nodes.length, help: v.help })) } });
  fs.writeFileSync(path.join(out, 'runtime-probes.partial.json'), JSON.stringify(result, null, 2));
  await browser.close();
}

async function inspectAuthor() {
  const browser = await chromium.launch();
  const context = await browser.newContext({ ignoreHTTPSErrors: true, extraHTTPHeaders: { Authorization: `Bearer ${token}` } });
  const page = await context.newPage();
  const response = await page.goto(author + pagePath + '?wcmmode=edit', { waitUntil: 'domcontentloaded', timeout: 60000 });
  const data = await page.evaluate(() => ({ title: document.title, h1: [...document.querySelectorAll('h1')].map(n => n.textContent.trim()), teaserCount: document.querySelectorAll('.cmp-teaser').length, header: document.querySelectorAll('.cmp-site-header').length, footer: document.querySelectorAll('.cmp-site-footer').length, bodyHasLogin: /sign in|login/i.test(document.body.innerText) }));
  await page.screenshot({ path: path.join(out, 'author-edit.png'), fullPage: true });
  result.probes.push({ tier: 'author', engine: 'chromium', http_status: response?.status(), ...data });
  fs.writeFileSync(path.join(out, 'runtime-probes.partial.json'), JSON.stringify(result, null, 2));
  await browser.close();
}

(async () => {
  await inspect(chromium, 'chromium', { width: 1440, height: 900 });
  await inspect(chromium, 'chromium-mobile', { width: 390, height: 844 });
  for (const item of [[firefox, 'firefox', { width: 1440, height: 900 }], [webkit, 'webkit', { width: 1440, height: 900 }]]) {
    try { await inspect(...item); } catch (error) { result.probes.push({ tier: 'publish', engine: item[1], status: 'execution_error', error: String(error.message || error) }); fs.writeFileSync(path.join(out, 'runtime-probes.partial.json'), JSON.stringify(result, null, 2)); }
  }
  try { await inspectAuthor(); } catch (error) { result.probes.push({ tier: 'author', engine: 'chromium', status: 'execution_error', error: String(error.message || error) }); fs.writeFileSync(path.join(out, 'runtime-probes.partial.json'), JSON.stringify(result, null, 2)); }
  delete result.author; delete result.publish;
  fs.writeFileSync(path.join(out, 'runtime-probes.json'), JSON.stringify(result, null, 2));
  const failures = result.probes.filter(p => p.http_status !== 200 || (p.axe && p.axe.violations.some(v => ['critical','serious'].includes(v.impact))));
  console.log(`probes=${result.probes.length} findings=${failures.length}`);
})().catch(error => { console.error(error.stack || error); process.exit(1); });
