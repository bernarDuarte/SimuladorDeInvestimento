import HOME_URL from '@/modules/home/home.constansts';

export function createEmptyComponent(controller) {
  return controller('router-view');
}

function redirectByRouter($router, path) {
  if ($router) {
    $router.push(path);
    return;
  }
  window.location = path;
}

export function goToLoginPage($router) {
  redirectByRouter($router, `${HOME_URL.path}`);
}

export function goToBasePage($router) {
  redirectByRouter($router, `${HOME_URL.path}`);
}
