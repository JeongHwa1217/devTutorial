<template>
  <div class="about">
    <History/>
  </div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component';
import History from '@/components/History.vue';

@Options({
  components: {
    History,
  },
})
export default class AboutView extends Vue {}
</script>