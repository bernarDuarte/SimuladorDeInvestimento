export const OBJETIVO_URL = Object.freeze({
  path: '/api/objetivo',
  criar: {
    name: 'objetivo.criar',
    path: '/objetivo',
  },
  view: {
    name: 'objetivo.view',
    path: '/objetivo/ver',
  },
  notfound: {
    name: 'objetivo.notfound',
    path: '/objetivo/notfound',
  },
});

export const OBJETIVO_ERRORS = {
  404: 'objetivo_NOT_FOUND',
  401: 'PERMISSION_DENIED',
};
