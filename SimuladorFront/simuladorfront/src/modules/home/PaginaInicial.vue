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
          <table v-if="usuarioList && usuarioList.length > 0" class="table">
            <tbody>
              <tr v-for="usuario in usuarioList" :key="usuario.id">
                <td class="py-3 px-2">
                  <div size="sm" class="d-flex align-item--center">
                    <p>
                      {{ usuario.nome }}
                    </p>
                  </div>
                  <p color="regular">
                    {{ usuario.nome }}
                  </p>
                </td>
              </tr>
            </tbody>
          </table>
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
        <table v-if="objetivoList && objetivoList.length > 0" class="table">
          <tbody>
            <tr v-for="objetivo in objetivoList" :key="objetivo.id">
              <td class="py-3 px-2">
                <div size="sm" class="d-flex align-item--center">
                  <p>
                    {{ objetivo.nome }}
                  </p>
                </div>
                <p color="regular">
                  {{ objetivo.nome }}
                </p>
              </td>
            </tr>
          </tbody>
        </table>
        <p v-else class="opacity--50 my--lg">( Sem administradores )</p>
      </div>
    </template>
  </aside-content>
</template>
<script>

import AsideContent from '@/layout/AsideContent.vue';
import { fetchUsuario } from '@/modules/usuario/usuario.service';
import { goToCreateObjetivo } from '@/modules/objetivo/objetivo.routes';

export default {
  name: 'PaginaInicial',
  components: {
    AsideContent,
  },
  data() {
    return {
      usuarioList: [],
      objetivoList: [],
    };
  },
  mounted() {
    this.fetch();
  },
  methods: {
    fetch() {
      this.usuarioList = [];
      fetchUsuario()
        .then(data => {
          this.usuarioList = data.data;
        })
        .catch(() => {
          this.usuarioList = [];
        });
    },
    onCreateObjetivo() {
      goToCreateObjetivo(this.$router);
    },
    setDeleteObjetivo(objetivo) {
      this.objetivoDelete = objetivo;
    },
    showModal(objetivo) {
      return this.objetivoDelete && this.objetivoDelete.id === objetivo.id;
    },
  },
};
</script>
