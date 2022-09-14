<template>
  <el-container>
    <el-header>
      <top-bar />
    </el-header>
    <el-main>
      <el-container :size="containerSize">
        <div class="simulador-single-content-layout">
          <div class="simulador-single-content-layout__main">
            <slot name="content" />
          </div>
        </div>
      </el-container>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'SimuladorSingleContentLayout',
  props: {
    containerSize: String,
  },
};
</script>

<style lang="scss" scoped>
@import '@/scss/variables/paddings';
@import '@/scss/bootstrap/container';
@import '@/scss/bootstrap/mixins';

.simulador-single-content-layout {
  width: 100%;
  display: flex;
  align-items: flex-start;
  justify-content: space-between;

  .simulador-single-content-layout__main {
    width: 100%;
    padding-top: $padding-lg;

    @include media-breakpoint-down(md) {
      padding: $padding-lg;
    }
  }
}

header.el-header{
  background-color: #121026;
}
</style>
