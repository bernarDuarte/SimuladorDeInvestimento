<template>
  <div>
    <div
      :sm="4"
      :md="2">
      <icon
        class="mt-2"
        size="xl"
        icon="boxes" />
    </div>
    <div
      :sm="20"
      :md="22">
      <header v-truncate size="sm">
        {{ investimento.nome }}
      </header>
      <div
        v-truncate="2"
        color="regular">
        {{ investimento.risco.nome }}
      </div>
      <div
        v-truncate="2"
        color="regular">
        Rentabilidade Mensal
      </div>
      <div
        v-truncate="2"
        color="regular">
        {{ investimento.rentabilidade }}
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'LivroListItem',
};
</script>
