import Vue from 'vue'
import App from './App'

// 引入全局uView
import uView from 'uview-ui';
Vue.use(uView);

// 引入全局cu-custom
import cuCustom from './colorui/components/cu-custom.vue'
Vue.component('cu-custom',cuCustom)

import store from './store'
Vue.prototype.$store=store   //引入vuex
 
Vue.prototype.baseUrl="http://localhost:7777/citylife" //后端请求接口
Vue.prototype.appid=""  //小程序appid

Vue.config.productionTip = false //阻止显示生产模式的消息

App.mpType = 'app'

const app = new Vue({
    ...App,
	store
})

// http拦截器，此为需要加入的内容，如果不是写在common目录，请自行修改引入路径
import httpInterceptor from '@/common/http.interceptor.js'
// 这里需要写在最后，是为了等Vue创建对象完成，引入"app"对象(也即页面的"this"实例)
Vue.use(httpInterceptor, app)

// http接口API集中管理引入部分
import httpApi from '@/common/http.api.js'
Vue.use(httpApi, app)


app.$mount()
