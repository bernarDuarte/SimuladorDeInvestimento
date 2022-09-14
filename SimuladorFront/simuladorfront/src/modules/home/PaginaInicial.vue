<template>
  <aside-content>
    <template #aside>
      <div class="container">
        <div class="row justify-content-center justify-content-xl-end ml-lg-5">
          <div class="col-18 mt-5 mt-md-0">
            <h1 class="Display-2 text-center mb-4 bg-light rounded-2">
              <u>Meu Perfil</u>
            </h1>
          </div>
          <div class="col-14 mb-3">
            <simulador-input
              label="Nome"
              name="nome"
              type="text"
              rules="required|min:2"
              placeholder="Nome" />
          </div>
          <div class="col-14 mb-3">
            <simulador-input
              label="Email"
              name="nome"
              type="text"
              rules="required|min:2"
              placeholder="Email" />
          </div>
          <div class="col-14 mb-3">
            <simulador-input
              label="Senha"
              name="nome"
              type="text"
              rules="required|min:2"
              placeholder="**********" />
          </div>
        </div>
      </div>
    </template>

    <template #content>
      <div class="container">
        <div class="row justify-content-center ml-lg-5">
          <div class="col-12 mt-5 mt-md-0">
            <h1 class="Display-2 text-center p-2 mb-4 bg-light rounded-2">
              <u>Historico De Objetivos</u>
            </h1>
          </div>
        </div>
      </div>
    </template>
  </aside-content>
</template>
<script>

import AsideContent from '@/layout/AsideContent.vue';
import SimuladorInput from '@/components/input/input.vue';

export default {
  name: 'PaginaInicial',
  components: {
    AsideContent,
    SimuladorInput,
  },
};
</script>
