import { USUARIO_URL } from '@/modules/usuario/usuario.constants';
import { createEmptyComponent } from '@/router/route.service';

export default [
  {
    path: USUARIO_URL.path,
    redirect: '/',
    component: { render: createEmptyComponent },
    children: [

      {
        ...USUARIO_URL.criar,
        component: () => import('@/components/HelloWorld.vue'),
      },
      {
        ...USUARIO_URL.view,
        component: () => import('@/components/HelloWorld.vue'),
      },
      {
        ...USUARIO_URL.notfound,
        component: () => import('@/components/HelloWorld.vue'),
      },
    ],
  },
];

export function goToUsuarioNotFound($router) {
  $router.push({
    name: USUARIO_URL.notfound.name,
  });
}

export function goToCreateUsuario($router) {
  $router.push({
    name: USUARIO_URL.criar.name,
  });
}

export function goToViewUsuario($router) {
  $router.push({
    name: USUARIO_URL.view.name,
  });
}
