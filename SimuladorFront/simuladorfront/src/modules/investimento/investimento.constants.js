export const TIPOINVESTIMENTO_URL = Object.freeze({
  path: '/TipoInvestimento',
  view: {
    name: 'TipoInvestimento.view',
    path: '/TipoInvestimento/ver/:id',
  },
  edit: {
    name: 'TipoInvestimento.edit',
    path: '/TipoInvestimento/editar/:id',
  },
  create: {
    name: 'TipoInvestimento.create',
    path: '/TipoInvestimento/criar',
  },
  notfound: {
    name: 'TipoInvestimento.notfound',
    path: '/TipoInvestimento/nao-encontrado',
  },
});

export const TIPOINVESTIMENTO_ERRORS = {
  404: 'TIPOINVESTIMENTO_NOT_FOUND',
  401: 'PERMISSION_DENIED',
};
