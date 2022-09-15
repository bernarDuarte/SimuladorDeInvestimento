import { HOME_URL } from '@/modules/home/home.constansts';

export default [
  {
    path: HOME_URL.path,
    redirect: '',
    component: () => import('@/modules/auth/view/login.vue'),
    //  component: () => import('@/modules/home/components/home.vue'),
  },
];
