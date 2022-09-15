<template>
  <router-link :to="to">
    <slot />
  </router-link>
</template>
<script>
import { HOME_URL } from '@/modules/home/home.constansts';

export default {
  name: 'SimuladorLivroLink',
  props: {
    id: {
      type: Number,
      required: true,
    },
    action: {
      type: String,
      default: 'view',
      validator(action) {
        return action && ['view', 'edit'].includes(action);
      },
    },
  },
  computed: {
    to() {
      return {
        name: HOME_URL[this.action].name,
        path: HOME_URL[this.action].path,
        params: {
          id: this.id,
        },
      };
    },
  },
};
</script>
