<template>
  <div>
    <form @submit.prevent="send">
      <label for="xs">X:</label>
      <select id="xs" v-model="x">
        <option v-for="i in 9" :value="i/2-2.5">{{i/2-2.5}}</option>
      </select>
      <br/>
      <label for="ys">Y:</label>
      <input id="ys" type="text" placeholder="(-5..3)" v-model.number="y"/>
      <br/>
      <label for="rs">R:</label>
      <select id="rs" v-model="rt" @change="$emit('update:r', $event.target.value)">
        <option v-for="i in 4" :value="i/2">{{i/2}}</option>
      </select>
      <div v-if="!valid" style="color: red">Y should be a number between -5 and 3</div>
    </form>
  </div>
</template>

<script>
  import axios from 'axios'
  export default {
    name: 'Controls',
    props: {
      r: {
        type: Number,
        default: 1
      }
    },
    methods: {
      send () {
        if(!this.valid)
          return false;
        axios('https://localhost:8080/Lab4/app/points/check', {
          params: {
            x: this.x,
            y: this.y,
            r: this.rt
          },
          method: 'POST'
        }).then(response => {
          this.$emit('update:points', response.data);
        }).catch(error => {
          this.$emit('update:points', {
            x: this.x,
            y: this.y,
            r: this.rt,
            id: 0,
            inside: 'Не лежит'
          });
          console.log(error)
        });
      }
    },
    computed: {
      valid () {
        return !Number.isNaN(this.y) && this.y >= -5 && this.y <= 3;
      }
    },
    data() {
      return {
        x: 0,
        y: 0,
        rt: 1
      }
    }
  }
</script>
