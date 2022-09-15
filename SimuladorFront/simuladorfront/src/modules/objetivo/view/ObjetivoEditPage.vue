<template>
  <single-content>
    <template #content>
      <div class="container">
        <div class="row justify-content-start ml-lg-5">
          <div class="col-12 mt-5 mt-md-0">
            <h1 class="Display-2 text-center p-2 mb-4 bg-light rounded-2">
              Criar novo objetivo
            </h1>
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row justify-content-center justify-content-xl-start ml-lg-5">
          <div class="col-10 mb-3 ">
            <simulador-input
              id="nome"
              v-model="info.nome"
              label="Nome: "
              class="rounded-5"
              name="Nome"
              placeholder=""
              type="text"
              rules="required"
              :focus="true" />
          </div>
          <div class="col-10 mb-3 ">
            <simulador-input
              id="tempo"
              v-model="info.tempo"
              label="Tempo para conclusão em meses: "
              class="rounded-5"
              name="tempo"
              type="int"
              placeholder="" />
          </div>
          <div class="col-10 mb-3 ">
            <simulador-input
              id="objetivo"
              v-model="info.objetivo"
              label="Valor estimado para atingir o objetivo: "
              class="rounded-5"
              name="objetivo"
              type="int"
              placeholder="" />
          </div>
          <div class="col-10 mb-3 ">
            <simulador-input
              id="entrada"
              v-model="info.entrada"
              label="Valor de entrada possível: "
              class="rounded-5"
              name="entrada"
              type="int"
              placeholder="" />
          </div>
        </div>
        <div class="row justify-content-end mr-lg-5">
          <div class="col-10">
            <simulador-button
              @click="visible = !visible">
              Escolher investimento
            </simulador-button>
          </div>
        </div>
      </div>
      <gerenciar-tipo-investimento v-if="visible" @save="criarObjetivo">
      </gerenciar-tipo-investimento>
    </template>
  </single-content>
</template>
<script>

import SingleContent from '@/layout/SingleContent.vue';
import { saveObjetivo } from '@/modules/objetivo/objetivo.service';
import { toastError } from '@/services/toastService';
import { goToBasePage } from '@/router/route.service';
import GerenciarTipoInvestimento from '@/modules/investimento/views/GerenciarInvestimento.vue';

export default {
  name: 'ObjetivoPage',
  components: {
    SingleContent,
    GerenciarTipoInvestimento,
  },
  provide() {
    const infoRegistrarVm = {};
    Object.defineProperty(infoRegistrarVm, 'info', {
      get: () => this.info,
    });
    return { infoRegistrarVm };
  },
  data() {
    return {
      info: {
        nome: null,
        tempo: null,
        objetivo: null,
        entrada: null,
        tipo_investimento: null,
      },
      visible: false,
    };
  },
  methods: {
    criarObjetivo() {
      saveObjetivo(this.info)
        .then(data => {
          goToBasePage(this.$router, data || this.info);
        })
        .catch(() => toastError('Erro ao salvar o objetivo'));
    },
  },
};
</script>
