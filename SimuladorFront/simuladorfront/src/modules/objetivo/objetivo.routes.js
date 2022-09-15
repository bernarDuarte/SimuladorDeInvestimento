import { OBJETIVO_URL } from '@/modules/objetivo/objetivo.constants';
import { createEmptyComponent } from '@/router/route.service';

export default [
  {
    path: OBJETIVO_URL.path,
    redirect: '/',
    component: { render: createEmptyComponent },
    children: [

      {
        ...OBJETIVO_URL.criar,
        component: () => import('@/components/HelloWorld.vue'),
      },
      {
        ...OBJETIVO_URL.view,
        component: () => import('@/components/HelloWorld.vue'),
      },
      {
        ...OBJETIVO_URL.notfound,
        component: () => import('@/components/HelloWorld.vue'),
      },
    ],
  },
];

export function goToObjetivoNotFound($router) {
  $router.push({
    name: OBJETIVO_URL.notfound.name,
  });
}

export function goToCreateObjetivo($router) {
  $router.push({
    name: OBJETIVO_URL.criar.name,
  });
}

export function goToViewObjetivo($router) {
  $router.push({
    name: OBJETIVO_URL.view.name,
  });
}
