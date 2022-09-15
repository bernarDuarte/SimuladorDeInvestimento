import { HOME_URL } from '@/modules/home/home.constansts';

export default [
  {
    path: HOME_URL.path,
    component: () => import('@/modules/home/PaginaInicial.vue'),
  },
  {
    ...HOME_URL.components,
    component: () => import('@/modules/home/PaginaInicial.vue'),
  },

];

export function goToOpenHome($router) {
  $router.push({
    name: HOME_URL.components.name,
  });
}
