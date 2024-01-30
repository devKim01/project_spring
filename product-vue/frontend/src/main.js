import './assets/common.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'

const app = createApp(App)
app.config.globalProperties.$axios = axios; //전역변수로 this.$axios 가능
app.config.globalProperties.$serverUrl = '//localhost:8081' //api server
app.use(router).mount('#app')
