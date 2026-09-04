const { expect } = require('@playwright/test'); const AxeBuilder = require('@axe-core/playwright').default;
const PAGE = '/content/adlc-crowdstrike/us/en/about-us.html';
async function open(page) { await page.goto(PAGE, { waitUntil: 'domcontentloaded' }); }
async function oneH1(page) { await expect(page.locator('h1')).toHaveCount(1); }
async function noSeriousAxe(page) { const result = await new AxeBuilder({ page }).withTags(['wcag2a','wcag2aa','wcag21a','wcag21aa']).analyze(); expect(result.violations.filter((v) => ['critical','serious'].includes(v.impact))).toEqual([]); }
module.exports = { PAGE, open, oneH1, noSeriousAxe };
