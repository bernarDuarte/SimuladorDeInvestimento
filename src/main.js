import App from '@/App.vue';
import router from '@/router';
import Vue from 'vue';

import 'bootstrap';
import 'bootstrap-icons/font/bootstrap-icons.css';

import '@/config/element-ui';
import '@/config/vee-validate';
import '@/config/biblioteca-components';

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App),
}).$mount('#app');
