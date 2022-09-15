import { AUTH_URL } from '@/modules/auth/auth.constants';
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
  redirectByRouter($router, `${AUTH_URL.login.path}`);
}

export function goToBasePage($router) {
  redirectByRouter($router, `${HOME_URL.path}`);
}
