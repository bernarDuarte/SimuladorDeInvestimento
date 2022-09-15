<template>
  <div class="container">
    <div class="row d-flex justify-content-space-between align-items-center">
      <div class="col-10">
        Tipos de Investimento
      </div>
      <div class="col-10 ">
        <table v-if="TipoInvestimentoList && TipoInvestimentoList.length > 0" class="table">
          <tbody>
            <tr v-for="TipoInvestimento in TipoInvestimentoList" :key="TipoInvestimento.id">
              <td class="py-3 px-2">
                <div size="sm" class="d-flex align-item--center">
                  <p :id="TipoInvestimento.id">
                    {{ TipoInvestimento.nome }}
                  </p>
                </div>
                <p color="regular">
                  {{ TipoInvestimento.risco.nome }}
                </p>
                <p color="regular">
                  {{ TipoInvestimento.rendimento }}
                </p>
                <simulador-button
                  class="btn btn-primary"
                  native-type="submit"
                  @click="save">
                  Simular
                </simulador-button>
              </td>
            </tr>
          </tbody>
        </table>
        <p v-else class="opacity--50 my--lg">( Sem TipoInvestimento )</p>
      </div>
    </div>
  </div>
</template>

<script>
import { toastError } from '@/services/toastService';
import { fetchTipoInvestimento, removeTipoInvestimento } from '@/modules/investimento/investimento.service';
import { goToCreateTipoInvestimento } from '@/modules/investimento/investimento.routes';

export default {
  name: 'GerenciarTipoInvestimento',
  components: {
  },
  data() {
    return {
      TipoInvestimentoList: [],
      TipoInvestimentoDelete: null,
    };
  },
  mounted() {
    this.fetch();
  },
  methods: {
    save() {
      this.$emit('save');
    },
    fetch() {
      this.TipoInvestimentoList = [];
      fetchTipoInvestimento()
        .then(data => {
          this.TipoInvestimentoList = data.data;
        })
        .catch(() => {
          this.TipoInvestimentoList = [];
        });
    },
    onCreateTipoInvestimento() {
      goToCreateTipoInvestimento(this.$router);
    },
    setDeleteTipoInvestimento(TipoInvestimento) {
      this.TipoInvestimentoDelete = TipoInvestimento;
    },
    showModal(TipoInvestimento) {
      return this.TipoInvestimentoDelete && this.TipoInvestimentoDelete.id === TipoInvestimento.id;
    },
    onDeleteTipoInvestimento(TipoInvestimento) {
      removeTipoInvestimento(TipoInvestimento)
        .then(() => {
          this.$router.go(0);
        })
        .catch(() => toastError('Não foi possível excluir o TipoInvestimento'));
    },
  },
};
</script>
<style lang="scss" scoped>
  @import '@/scss/variables/paddings';
  @import '@/scss/bootstrap/container';
  @import '@/scss/bootstrap/mixins';
</style>
