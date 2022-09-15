<template>
  <el-container>
    <el-header>
      <top-bar />
    </el-header>
    <main class="continer-fluid">
      <div class="row">
        <div class="col-12 col-md-10 col-lg-9">
          <div class="simulador-aside-content-layout__sidebar">
            <slot name="aside" />
          </div>
          <div class="col-12 col-md-6">
            <slot name="content" />
          </div>
        </div>
      </div>
    </main>
  </el-container>
</template>

<script>
import TopBar from '@/components/topbar/TopBar.vue';

export default {
  name: 'SimuladorAsideContentLayout',
  components: { TopBar },
  props: {
    containerSize: String,
  },
};
</script>

  <style lang="scss" scoped>
  @import '@/scss/variables/colors';
  @import '@/scss/variables/margins';
  @import '@/scss/variables/paddings';
  @import '@/scss/bootstrap/container';
  @import '@/scss/bootstrap/mixins';

  </style>
