document.querySelectorAll('.cmp-site-header').forEach((header) => {
  const menu = header.querySelector('.cmp-site-header__menu-toggle');
  const nav = header.querySelector('.cmp-site-header__navigation');
  const submenu = header.querySelector('.cmp-site-header__submenu-toggle');
  const setMenu = (open) => { header.classList.toggle('cmp-site-header--menu-open', open); if (menu) { menu.setAttribute('aria-expanded', String(open)); menu.textContent = open ? menu.dataset.closeLabel : menu.dataset.openLabel; } };
  const setSubmenu = (open) => { const item = submenu && submenu.closest('.cmp-site-header__item'); if (item) item.classList.toggle('is-open', open); if (submenu) submenu.setAttribute('aria-expanded', String(open)); };
  if (menu) menu.addEventListener('click', () => setMenu(!header.classList.contains('cmp-site-header--menu-open')));
  if (submenu) submenu.addEventListener('click', () => setSubmenu(submenu.getAttribute('aria-expanded') !== 'true'));
  document.addEventListener('keydown', (event) => { if (event.key === 'Escape') { const returnFocus = header.contains(document.activeElement); setMenu(false); setSubmenu(false); if (returnFocus && submenu) submenu.focus(); } });
  document.addEventListener('click', (event) => { if (!header.contains(event.target)) { setMenu(false); setSubmenu(false); } });
});
