<template>
  <el-container>
    <el-header>
      <top-bar>
      </top-bar>
    </el-header>
    <el-main>
      <div>
        <div class="simulador-aside-content-layout">
          <div class="simulador-aside-content-layout__sidebar">
            <slot name="aside" />
          </div>
          <div class="simulador-aside-content-layout__content">
            <slot name="content" />
          </div>
        </div>
      </div>
    </el-main>
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

  .simulador-aside-content-layout {
    display: flex;
    align-items: flex-start;
    justify-content: space-between;

    @include media-breakpoint-down(md) {
      flex-direction: column;
    }

    .simulador-aside-content-layout__sidebar {
      top: 0;
      order: 1;
      width: 900px;
      height: 560px;
      position: sticky;
      position: -webkit-sticky;
      padding: $padding-xl $padding-xl 0 0;

      @include media-breakpoint-down(lg) {
        width: 600px;
      }

      @include media-breakpoint-down(md) {
        order: 1;
        width: 100%;
        border-right: 0;
        padding: $padding-md;
      }
    }

    .simulador-aside-content-layout__content {
      order: 2;
      width: 100%;
      min-height: 560px;
      padding: $padding-xl 0 0 $padding-xl;
      border-left: 1px solid $border-light-color;

      @include media-breakpoint-down(md) {
        order: 2;
        padding: $padding-md;
      }
    }
  }
  </style>
