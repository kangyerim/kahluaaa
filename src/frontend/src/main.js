import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router'
import vuex from 'vuex'
import axios from 'axios'
import {store} from './store'

Vue.config.productionTip = false
Vue.use(vuex)

new Vue({
  vuetify,
  router,
  vuex,
  axios,
  store,
  render: h => h(App)
}).$mount('#app')
