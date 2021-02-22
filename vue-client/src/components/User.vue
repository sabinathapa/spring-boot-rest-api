<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div v-for="user in users" v-bind:key="user">
       <h4>{{user.username}}</h4>
       <p>{{user.email}}</p>

      </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'User',
  props: {
    msg: String
  },
  data () {
      return {
        users: []
      }
    },
    mounted () {
      axios
        .get('http://localhost:8080/api/users')
        .then(response => (this.users = response.data))
    }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
