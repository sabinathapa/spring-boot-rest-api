import Vue from 'vue'
import App from './App.vue'
import employees from './employees.vue'

new Vue({
  el: '#employees',
  render: h => h(employees)
})
