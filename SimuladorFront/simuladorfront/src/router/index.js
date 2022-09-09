import Vie from 'vue';
import VueRouter from 'vue-router';
import routes from 'routes.js';

VueRouter.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes,
  linkActiveClass: 'active',
});

export default router;