<template>
  <div @click="$emit('update:click', $event)" style="width: 300px; height: 300px; display: block">
    <svg xmlns="http://www.w3.org/2000/svg" version="1.1" width="300" height="300">
      <path d=" M200,150 A50,50 0 0,1 150,200 L150,150 L250,150 L250,100 L150,100 L150,150 L150,250 L50,150" fill="blue" fill-opacity="1"></path>

      <line x1="150" y1="0" x2="150" y2="300" stroke="black" stroke-width="2"></line>
      <line x1="0" y1="150" x2="300" y2="150" stroke="black" stroke-width="2"></line>

      <line x1="140" y1="10" x2="150" y2="0" stroke="black" stroke-width="2"></line>
      <line x1="160" y1="10" x2="150" y2="0" stroke="black" stroke-width="2"></line>

      <line x1="290" y1="140" x2="300" y2="150" stroke="black" stroke-width="2"></line>
      <line x1="290" y1="160" x2="300" y2="150" stroke="black" stroke-width="2"></line>
      <circle v-for="p in points" :key="p.id" :cx="getX(p.x)" :cy="getY(p.y)"
              r="3" :fill="getColor(p.result)" ></circle>
      <text x="200" y="150" fill="">{{r/2}}</text>
      <text x="100" y="150" fill="">{{r/2}}</text>
      <text x="150" y="100" fill="">{{r/2}}</text>
      <text x="150" y="200" fill="">{{-r/2}}</text>
      <text x="250" y="150" fill="">{{r}}</text>
      <text x="50" y="150" fill="">{{-r}}</text>
      <text x="150" y="50" fill="">{{r}}</text>
      <text x="150" y="250" fill="">{{-r}}</text>
      <rect x="0" y="0" width="300" height="300" opacity="0"></rect>
    </svg>
  </div>
</template>

<script>
  export default {
    name: 'Map',
    props: {
      r: {
        type: Number,
        default: 1
      },
      points: {
        type: Array,
        default: []
      }
    },
    methods: {
      getColor: function (inside) {
        if (inside === 'Лежит')
          return "green";
        else return "red";
      },
      getX(x) {
        console.log(x + ' ' + typeof(x))
        return 150 + x * 100 / this.r;
      },
      getY(y) {
        return 150 - y * 100 / this.r;
      }
    }
  }
</script>
