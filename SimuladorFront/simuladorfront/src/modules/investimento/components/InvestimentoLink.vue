<template>
  <router-link :to="to">
    <slot />
  </router-link>
</template>
<script>
import { TIPOINVESTIMENTO_URL } from '@/modules/investimento/investimento.constants';

export default {
  name: 'TipoInvestimentoLink',
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
        name: TIPOINVESTIMENTO_URL[this.action].name,
        path: TIPOINVESTIMENTO_URL[this.action].path,
        params: {
          id: this.id,
        },
      };
    },
  },
};
</script>
