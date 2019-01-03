<template>
  <div style="height: 200px; overflow-y:scroll;">
    <table>
      <colgroup>
        <col style="width: 25%">
        <col style="width: 25%">
        <col style="width: 25%">
        <col style="width: 25%">
      </colgroup>
      <thead>
      <tr>
        <th>
          X
        </th>
        <th>
          Y
        </th>
        <th>
          R
        </th>
        <th>
          Result
        </th>
        <th>
          Delete
        </th>
      </tr>
      </thead>
      <tbody>
      <ResultRow v-for="p in points" :key="p.id" :point="p" @remove="$emit('removePoint', $event)"></ResultRow>
      </tbody>
    </table>
  </div>
</template>

<script>
  import ResultRow from "./ResultRow";
  export default {
    name: 'Results',
    components: {ResultRow},
    props: {
      points: {
        type: Array,
        default: []
      }
    }
  }
</script>
