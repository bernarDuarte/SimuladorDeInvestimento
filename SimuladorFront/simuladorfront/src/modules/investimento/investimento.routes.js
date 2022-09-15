import { TIPOINVESTIMENTO_URL } from '@/modules/investimento/investimento.constants';
import { createEmptyComponent } from '@/router/route.service';

export default [
  {
    path: TIPOINVESTIMENTO_URL.path,
    redirect: '/',
    component: { render: createEmptyComponent },
    children: [
      {
        ...TIPOINVESTIMENTO_URL.view,
        component: () => import('@/modules/investimento/views/InvestimentoViewPage.vue'),
      },
    ],
  },
];

export function goToTipoInvestimentoNotFound($router) {
  $router.push({
    name: TIPOINVESTIMENTO_URL.notfound.name,
  });
}

export function goToOpenTipoInvestimento($router, TipoInvestimento) {
  $router.push({
    name: TIPOINVESTIMENTO_URL.view.name,
    params: { id: TipoInvestimento.id },
  });
}

export function goToCreateTipoInvestimento($router) {
  $router.push({
    name: TIPOINVESTIMENTO_URL.create.name,
  });
}
