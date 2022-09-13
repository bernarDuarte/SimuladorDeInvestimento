<template>
  <el-container>
    <el-header>
      <top-bar />
    </el-header>
    <el-main>
      <container :size="containerSize">
        <div class="biblioteca-single-content-layout">
          <div class="biblioteca-single-content-layout__main">
            <slot name="content" />
          </div>
        </div>
      </container>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'BibliotecaSingleContentLayout',
  props: {
    containerSize: String,
  },
};
</script>

<style lang="scss" scoped>
@import '@/scss/variables/paddings';
@import '@/scss/bootstrap/container';
@import '@/scss/bootstrap/mixins';

.biblioteca-single-content-layout {
  width: 100%;
  display: flex;
  align-items: flex-start;
  justify-content: space-between;

  .biblioteca-single-content-layout__main {
    width: 100%;
    padding-top: $padding-lg;

    @include media-breakpoint-down(md) {
      padding: $padding-lg;
    }
  }
}
</style>
