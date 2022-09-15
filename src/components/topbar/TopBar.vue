<template>
  <div class="container-fluid">
    <nav id="ftco-navbar" class="navbar navbar-expand-lg ftco_navbar ftco-navbar-light">
      <div class="container">
        <img id="logoSaks" src="@/assets/saks.png" alt="">
        <div class="social-media order-lg-last">
          <p class="mb-0 d-flex">
            <a id="media1" href="#" class="d-flex align-items-center justify-content-center ml-2"><span class="fa fa-facebook"><i class="sr-only">Facebook</i></span></a>
            <a href="media2" class="d-flex align-items-center justify-content-center ml-2"><span class="fa fa-twitter"><i class="sr-only">Twitter</i></span></a>
            <a href="#" class="d-flex align-items-center justify-content-center ml-2"><span class="fa fa-instagram"><i class="sr-only">Instagram</i></span></a>
            <a href="#" class="d-flex align-items-center justify-content-center ml-2"><span class="fa fa-dribbble"><i class="sr-only">Dribbble</i></span></a>
          </p>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="fa fa-bars"></span> Menu
        </button>
        <div id="ftco-nav" class="collapse navbar-collapse">
          <ul class="navbar-nav ml-3 ml-lg-auto mr-md-3">
            <li class="nav-item active"><a href="#" class="nav-link">Objetivos</a></li>
            <li class="nav-item "><a href="#" class="nav-link">Meu Perfil</a></li>
            <li class="nav-item "><a href="#" class="nav-link">Sair</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- END nav -->
  </div>
</template>

<script>
export default {
  name: 'TopBar',
};

</script>
<style scoped>

.container-fluid{
  padding: 0px;
}
#ftco-navbar{
  background-color: #121026;
}
#logoSaks{
  height: 44px;
  border-radius: 60px;
}
.nav-link{
  color: #ffffff;
}
.social-media p a{
  border: 1px solid #ffffff;
			width: 40px;
			height: 40px;
			border-radius: 50%;
			margin-right: 4px;
}
button{
  border: 1px solid #ffffff;
  color: #ffffff;
}
span{
	color: #ffffff;
}
</style>
