<template>
  <section class="d-flex justify-content-center align-items-center m-0 mt-sm-5">
    <div class="container-fluid">
      <div class="row d-flex justify-content-end align-items-end h-100">
        <div class="col-sm col-md-10 d-none d-xl-flex align-self-end">
          <img class="image-fluid" alt="imagem-logo" src="../../../assets/logo.png" />
        </div>
        <div id="formCol" class="col col-xl-8 offset-xl-1 d-flex text-center justify-content-center rounded-sm-0">
          <div class="row justify-content-end">
            <div class="col-15 col-sm-10 col-lg-15">
              <h2 class="h2 display-1 m-0 m-lg-5 mb-lg-3 text-start">Previdência privada <br><b>100%</b> digital </h2>
            </div>
            <div class="row justify-content-end">
              <forms v-slot="{ validate }" :submit="submitLogin">
                <div class="col-10 input-group-lg m-5 mt-5 mb-5 justify-content-end">
                  <input
                    v-model="username"
                    type="text"
                    placeholder="Insira seu Email"
                    class="form-control rounded-5"
                    name="e-mail"
                    :focus="true" />
                </div>
                <div class="col-10 input-group-lg m-5 mt-5 mb-3">
                  <input
                    v-model="password"
                    type="password"
                    placeholder="Insira sua Senha"
                    class="form-control rounded-5"
                    name="senha"
                    :focus="true" />
                </div>
                <div>
                  <simulador-button
                    class="btn btn-primary"
                    native-type="submit"
                    @click="validate">
                    Acessar
                  </simulador-button>
                </div>
              </forms>
            </div>
            <div class="col-10 mt-5">
              <p>Não possui conta? </p><router-link class="color--primary" to="/registrar">Criar conta</router-link>
            </div>
            <div class="col-18 justify-content-center">
              <img class="imagem-saks" alt="imagem-saks" src="../../../assets/saks.png">
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>

import Forms from '@/components/forms/forms.vue';
import SimuladorButton from '@/components/button/button.vue';
import * as authStore from '@/modules/auth/auth.store';
import { passwordLogin } from '@/modules/auth/auth.service';
import { goToBasePage } from '@/router/route.service';
import { toastError } from '@/services/toastService';

export default {
  name: 'LoginView',
  components: {
    Forms,
    SimuladorButton,
  },
  props: {
    msg: String,
  },
  data() {
    return {
      username: '',
      password: '',
    };
  },
  beforeCreate() {
    if (authStore.getters.getToken()) {
      goToBasePage();
    }
  },
  methods: {
    submitLogin() {
      passwordLogin(this.username, this.password)
        .then(goToBasePage)
        .catch(err => {
          if (err.response.data.message === 'USUARIO_INCORRETO') {
            toastError('E-mail e/ou senha incorretos');
          }
        });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
@import '@/scss/variables/paddings';
@import '@/scss/bootstrap/container';
@import '@/scss/bootstrap/mixins';

* {
  font-size: 32px;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  border: none;
}
h2{
  font-size: 56px;
  color:#ffffff
}
p{
  color: #ffffff;
  font-size: 32px;
}
#login {
  display: block;
  align-items: center;
}
#formCol{
  background-color:#5274D8;
  border-radius: 260px 0px 0px 260px;
}

@media only screen and (max-width: 576px) {
  #formCol {
    border-radius: 0px 0px 0px 0px;
    padding:100px 0px 100px 0px;
  }
}
.imagem-saks{
  width: 350px;
  height: 182px;
  border-radius: 400px;
}
b{
  font-size: 56px;
}
input{
  height: 56px;
}
</style>
