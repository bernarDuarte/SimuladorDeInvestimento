<template>
  <section>
    <link id="bootstrap-css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <head>
    </head>
    <body>
      <forms v-slot="{ validate }" :submit="validateUsuario" class="form-horizontal">
        <fieldset>
          <div class="panel panel-primary">
            <div class="panel-heading"><b>Crie uma Conta</b></div>

            <div class="panel-body">
              <div class="form-group">
                <div class="col-md-11 control-label">
                  <p class="help-block"> Campo Obrigatório </p>
                </div>
              </div>

              <div class="form-group">
                <label class="col-md-2 control-label" for="Nome">Nome </label>
                <div class="col-md-8">
                  <input
                    id="Nome"
                    v-model="info.nome"
                    name="Nome"
                    placeholder=""
                    class="form-control input-md"
                    type="text"
                    rules="required"
                    :focus="true">
                </div>
              </div>

              <div class="form-group">
                <label class="col-md-2 control-label" for="Senha">Senha </label>
                <div class="col-md-8">
                  <input
                    id="Senha"
                    v-model="info.senha"
                    placeholder=""
                    class="form-control input-md"
                    required=""
                    type="password"
                    name="senha">
                </div>
              </div>

              <div class="form-group">
                <label class="col-md-2 control-label" for="confirmar_senha">Confirmar Senha </label>
                <div class="col-md-8">
                  <input
                    id="confirmar_senha"
                    v-model="info.confirmar_senha"
                    placeholder=""
                    class="form-control input-md"
                    required=""
                    type="password"
                    name="senha">
                </div>
              </div>

              <div class="form-group">
                <label class="col-md-2 control-label" for="telefone">Telefone </label>
                <div class="col-md-2">
                  <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                    <input
                      id="telefone"
                      v-model="info.telefone"
                      name="telefone"
                      class="form-control"
                      placeholder="XX XXXXX-XXXX"
                      required=""
                      type="text"
                      maxlength="13">
                  </div>
                </div>
              </div>

              <div class="form-group">
                <label class="col-md-2 control-label" for="email">Email </label>
                <div class="col-md-5">
                  <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                    <input
                      id="email"
                      v-model="info.email"
                      class="form-control"
                      placeholder="email@email.com"
                      required=""
                      pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                      type="email"
                      name="e-mail"
                      rules="required|email">
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-2 control-label" for="Registrar"></label>
                <div class="col-md-8">
                  <button id="Registrar" name="Registrar" class="btn btn-primary" native-type="submit" @click="validate">Registrar</button>
                </div>
              </div>
              <div class="d-grid text-center">
                <p>
                  Já possui conta?
                  <router-link class="color--primary" to="/login">Login</router-link>
                </p>
              </div>
            </div>
          </div>
        </fieldset>
      </forms>
    </body>
  </section>
</template>

<script>

import { registrar } from '@/modules/auth/auth.service';
import { toastError } from '@/services/toastService';
import { goToBasePage } from '@/router/route.service';

export default {
  name: 'RegistrationPage',
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
        email: null,
        senha: null,
        confirmar_senha: null,
        telefone: null,
        status: 1,
      },
    };
  },
  methods: {
    onRegistrar() {
      registrar(this.info)
        .then(goToBasePage)
        .catch(err => {
          if (err.response.data.message === 'EMAIL_DUPLICADO') {
            toastError('E-mail duplicado');
          }
        });
    },
    validateUsuario() {
      const specialChars = !!(this.info.senha.match(/[`!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?~]+/) && this.info.senha.match(/\d+/));

      if (!specialChars) {
        toastError('A senha deve conter caracteres especiais e números');
      } else if (this.info.senha !== this.info.confirmar_senha) {
        toastError('As senhas não são iguais');
      } else {
        this.onRegistrar();
      }
    },
  },
};
</script>

  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style lang="scss" scoped>

  div [class="panel-heading"]{
    color: black;
    background-color: #E4EEFC;
    border: none;
  }

  div [class="panel-body"]{
    border: none;
  }

  input {
    border: none;
    background-color: #E4EEFC;
  }

  div [class="panel panel-primary"]{
    background-color: white;
    border: none;
  }

  #logo {
          width:50%;
          height:50%;
  }

  .panel-heading{
      font-size:150%;
  }
  </style>
