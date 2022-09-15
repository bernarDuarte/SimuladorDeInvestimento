import home from '@/modules/home/home.routes';
import authRoutes from '@/modules/auth/auth.routes';

const routes = [
  {
    path: '*',
    redirect: '/',
  },
];

export default [
  ...routes,
  ...home,
  ...authRoutes,
];
