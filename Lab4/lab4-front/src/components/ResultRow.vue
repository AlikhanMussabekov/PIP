<template>
  <tr>
    <td>
      {{point.x}}
    </td>
    <td>
      {{point.y}}
    </td>
    <td>
      {{point.r}}
    </td>
    <td>
      {{point.result}}
    </td>
    <td>
      <input type="button" @click="remove"/>
    </td>
  </tr>
</template>

<script>
  export default {
    name: 'ResultRow',
    props: {
      point: {
        type: Object
      }
    },
    methods: {
      remove () {
        this.$emit('remove', this.point.id);
      }
    }
  }
</script>
