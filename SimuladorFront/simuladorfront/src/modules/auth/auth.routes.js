import { AUTH_URL } from '@/modules/auth/auth.constants';

export default [
  {
    ...AUTH_URL.login,
    component: () => import('@/modules/auth/view/login.vue'),
  },
  {
    ...AUTH_URL.register,
    component: () => import('@/modules/auth/view/registration.vue'),
  },
];
