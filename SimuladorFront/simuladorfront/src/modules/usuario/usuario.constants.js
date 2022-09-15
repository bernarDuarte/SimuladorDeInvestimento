export const USUARIO_URL = Object.freeze({
  path: '/api/usuarios',
  criar: {
    name: 'usuario.criar',
    path: '/usuario',
  },
  view: {
    name: 'usuario.view',
    path: '/usuario/ver',
  },
  notfound: {
    name: 'usuario.notfound',
    path: '/usuario/notfound',
  },
});

export const USUARIO_ERRORS = {
  404: 'usuario_NOT_FOUND',
  401: 'PERMISSION_DENIED',
};
