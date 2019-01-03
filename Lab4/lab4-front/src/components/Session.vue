<template>
  <div>
    <input type="button" value="Logout" @click="logout" v-if="logged"/>
    <form @submit.prevent="login" v-else>
      <input type="text" placeholder="Login" v-model="name" v-bind:class="{incorrect: !success}"/>
      <br/>
      <input type="password" placeholder="******" v-model="password" v-bind:class="{incorrect: !success}"/>
      <br/>
      <input type="submit" value="Log in"/>
      <input type="button" value="Register" @click="register"/>
      <br/>
      <div v-if="!success" style="color: red">Cannot log in</div>
    </form>
  </div>
</template>

<script>
  import axios from 'axios'
  export default {
    name: 'Session',
    methods: {
      login () {
        axios('http://localhost:8080/Lab4/app/user/login', {
          params: {
            username: this.name,
            password: this.password
          },
          method: 'POST'
        }).then(response => {
          this.$emit('login');
          this.logged = true;
          this.success = true;
          console.log(response.data['msg'])
        }).catch(error => {
          this.success = false;
          name.borderColor = 'red';
          password.borderColor = 'red';
        });
      },
      logout () {
        axios('http://localhost:8080/Lab4/app/user/logout', {
          params: {
          },
          method: 'POST'
        }).then(response => {
        }).catch(error => {
          console.log(error)
        });
        this.$emit('logout');
        this.logged = false;
        this.success = true;
      },
      register () {
        axios('http://localhost:8080/Lab4/app/user/register', {
          params: {
            username: this.name,
            password: this.password
          },
          method: 'POST'
        }).then(response => {
          console.log(response.data['login'] + ' ' + response.data['id']);
          this.login();
        }).catch(error => {
          console.log(error)
          name.borderColor = 'red';
          password.borderColor = 'red';
        });
      }
    },
    data() {
      return {
        logged: false,
        name: '',
        password: '',
        success: true
      }
    }
  }
</script>

<style>
  .incorrect{
    border-color: red;
  }
</style>
