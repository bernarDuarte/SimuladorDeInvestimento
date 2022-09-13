<template>
  <div>
    <router-view key="$route.path"></router-view>
  </div>
</template>

<script>

export default {
  name: 'SimuladorApp',
  components: {
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #0b0f14;
  margin-top: 60px;
}
</style>
