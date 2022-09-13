import home from '@/modules/home/home.routes';

const routes = [
  {
    path: '*',
    redirect: '/',
  },
];

export default [
  ...routes,
  ...home,
];
