<template>
  <div class="container">
    <div class="d-flex align-items-center">
      <div>
        <div>
          {{ TipoInvestimento.titulo }}
        </div>
      </div>
    </div>
    <div class="mt-1">
      <div>
        <p class="">
          {{ TipoInvestimento.resumo }}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import { TIPOINVESTIMENTO_ERRORS } from '@/modules/investimento/investimento.constants';
import { getTipoInvestimento } from '@/modules/investimento/investimento.service';
import { toastError } from '@/services/toastService';
// eslint-disable-next-line import/no-cycle
import { goToTipoInvestimentoNotFound } from '@/modules/investimento/investimento.routes';

export default {
  name: 'TipoInvestimentoViewPage',
  components: {
  },
  data() {
    return {
      TipoInvestimento: null,
    };
  },
  computed: {
    id() {
      return this.$route.params?.id;
    },
  },
  mounted() {
    this.fetch();
  },
  methods: {
    fetch() {
      getTipoInvestimento(this.id)
        .then(({ data }) => {
          this.TipoInvestimento = data;
        })
        .catch(err => {
          this.TipoInvestimento = null;
          if (err) {
            goToTipoInvestimentoNotFound(this.$router);
          } else if ((err.response.data.errors === TIPOINVESTIMENTO_ERRORS[err.response.status] && err.response.status === 404)) {
            goToTipoInvestimentoNotFound(this.$router);
          } else {
            toastError('Erro ao buscar o TipoInvestimento');
          }
        });
    },
  },
};
</script>
