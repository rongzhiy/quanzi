import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const store = new Vuex.Store({
	//data
	state: {
		userinfo: {},
		needAuth: true,
		isLogin: false,
		token: '123654789'
	},

	//computed
	getters: {
		getUserinfo(state) {
			return state.userinfo
		},
		getNeedAuth(state) {
			return state.needAuth
		},
		getIsLogin(state) {
			return state.isLogin
		}
	},
	//methods 同步
	mutations: {
		setUserinfo(state, userinfo) {
			state.userinfo = userinfo;
		},
		setNeedAuth(state, needAuth) {
			state.needAuth = needAuth;
		},
		setIsLogin(state, isLogin) {
			state.isLogin = isLogin;
		},
	},
	//异步的方法
	actions: {
		login(context) {
			return new Promise((resolve, reject) => {
				uni.login({
					provider: 'weixin',
					success: res => {
						console.log("微信返回的code:" + res.code);
						Vue.prototype.$u.api.login({ //访问后端接口
							appid: Vue.prototype.appid,
							code: res.code,
							token: uni.getStorageSync('token')
						}).then(res => {
							console.log(res);
							uni.setStorageSync('token', res.data.token);
							if (res.msg == "登录成功") {
								context.commit('setUserinfo', res.data.user);
								context.commit('setNeedAuth', false);
								// console.log(store.state.needAuth);
								context.commit('setIsLogin', true);
							}
							resolve("login执行完毕");
						})
					},
					fail: res => {
						Vue.prototype.$u.toast("获取code失败");
						reject("获取code失败");
					}
				});
			})


		},
		// 授权用户信息
		authUserInfo(context) {
			
			return new Promise((resolve, reject) => {
				console.log("正在授权ing");
				wx.getUserProfile({
					lang: 'zh_CN', //获取的省份城市等为中文
					desc: '注册账户',
					success(res) {
						// console.log('用户：'+JSON.stringify(res));
						//成功获取到userinfo
						console.log("userinfo", res.userInfo);

						context.commit('setUserinfo', {
							nickname: res.userInfo.nickName,
							sex: res.userInfo.gender,
							avatar: res.userInfo.avatarUrl,
							city: res.userInfo.city
						})

						uni.showLoading({
							mask: true,
							title: '正在授权'
						});

						Vue.prototype.$u.api.auth(context.state.userinfo).then(res => { //注意使用方式
							// console.log("context.state.userinfo: ",JSON.stringify(context.state.userinfo));
							console.log("授权结果", res);
							if (res.msg == "授权成功") {
								context.commit('setIsLogin', true);

								uni.hideLoading();
								//设置授权按钮为隐藏
								context.commit('setNeedAuth',
									false); //无需授权，注意actions里面的修改数据源的方式
								Vue.prototype.$u.toast("授权成功")
							} else {
								Vue.prototype.$u.toast("授权失败")
							}
							resolve("授权执行完毕");
						}).catch(err => {
							console.log(err);
							uni.hideLoading();
							Vue.prototype.$u.toast('授权出错');
							reject("获取出错");
						})
					},
					fail(err) {
						console.log("获取用户信息失败", err);
						uni.hideLoading();
						Vue.prototype.$u.toast('获取用户信息失败');
						reject("获取信息出错")
					}
				})

			})
		}


	}
})
export default store
