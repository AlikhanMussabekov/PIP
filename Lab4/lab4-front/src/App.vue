<template>
  <div class="grid-root">
    <div style="grid-area: names">Мусабеков Алихан <br/> Мацкевич Игорь</div>
    <div style="grid-area: group" align="center">P3211</div>
    <div style="grid-area: var">Вариант 311243</div>
    <Map style="grid-area: map; alignment: center" :r="r" :points="points" @update:click="processClick" v-if="logged"></Map>
    <Controls style="grid-area: controls" :r="r" @update:r="r = $event" @update:points="points.unshift($event)" v-if="logged"></Controls>
    <Results style="grid-area: results" :points="points" @removePoint="removePoint($event)" v-if="logged"></Results>
    <Session v-bind:style="{ gridArea: logged ? 'login' : 'map'}" @login="login" @logout="logout"></Session>
  </div>
</template>

<script>
  import axios from 'axios'
  import Map from './components/Map'
  import Controls from './components/Controls'
  import Results from "./components/Results";
  import Session from "./components/Session";

  export default {
    name: 'App',
    components: {
      Session,
      Results,
      Map,
      Controls
    },
    methods: {
      send (x, y) {
        axios('http://localhost:8080/Lab4/app/points/check',{
          params: {
            x: x,
            y: y,
            r: this.r
          },
          method: 'POST'
        }).then(response => {
          this.points.unshift(response.data);
        }).catch(error => {
          this.points.unshift({
            x: x,
            y: y,
            r: this.r,
            id: 0,
            result: 'Не лежит'
          });
          console.log(error)
        })
      },
      processClick (event) {
        this.send((event.offsetX-150)/100*this.r, (150-event.offsetY)/100*this.r);
      },
      login () {
        axios('http://localhost:8080/Lab4/app/points',{
          params: {
          },
          method: 'GET'
        }).then(response => {
          console.log(response.data);
          this.points = response.data;
        }).catch(error => {
          this.points = [];
          console.log(error)
        });
        this.logged = true;
      },
      logout () {
        this.points = [];
        this.logged = false;
      },
      removePoint (id) {
        console.log(id);
        this.points = this.points.filter(q => q.id != id);
        axios('http://localhost:8080/Lab4/app/points/delete', {
          params: {
            id: id
          },
          method: 'POST'
        }).then(response => {
        }).catch(error => {
          console.log(error)
        });
      }
    },
    data () {
      return {
        r: 1,
        points: [],
        logged: false
      }
    }
  }
</script>

<style>
  .grid-root {
    display: grid;
  }
  @media (min-width: 665px){
    .grid-root {
      grid-template-columns: max-content max-content auto max-content;
      grid-template-rows: max-content max-content auto;
      grid-template-areas:
        "names    group   group     var"
        "map      map     controls  controls"
        "results  results results   results"
        "login    login   login     login";
    }
  }
  @media (max-width: 664px){
    .grid-root {
      grid-template-columns: max-content auto max-content;
      grid-template-rows: max-content max-content max-content max-content auto;
      grid-template-areas:
        "names    group     var"
        ".        .         ."
        "map      map       map"
        "controls controls  controls"
        "results  results   results"
        "login    login     login";
    }
  }
</style>
