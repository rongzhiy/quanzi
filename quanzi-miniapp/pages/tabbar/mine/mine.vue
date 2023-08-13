<template>
	<view>
		<!-- 未授权登录 -->
		<u-modal v-model="show" title='请授权' show-title='false' show-cancel-button='true' :content='content'
			@confirm='confirm' @cancel="cancel">

		</u-modal>

		<!-- 登录成功 -->
		<view class="u-flex user-box u-p-l-30 u-p-r-20 u-p-b-30">
			<view class="u-m-r-10">
				<u-avatar :src="pic" size="140"></u-avatar>
			</view>
			<view class="u-flex-1">
				<view class="u-font-18 u-p-b-20">{{Object.keys(userinfo).length?userinfo.nickname:"未登录"}}</view>
				<view class="u-font-14 u-tips-color">城市:{{Object.keys(userinfo).length?userinfo.city:"未知"}}</view>
			</view>
			<view class="u-m-l-10 u-p-10">
				<text class="u-font-14 u-tips-color" @click="goToPage('/pages/tabbar/mine/user/user')">个人信息</text>
			</view>
			<view class="u-m-l-10 u-p-10">
				<u-icon name="arrow-right" color="#969799" size="28"></u-icon>
			</view>
		</view>
		<!-- 跟踪 -->
		<view class="trace-box">
			<u-grid :col="4" :border="false">
				<u-grid-item v-for="(item, index) in trace.model" :key="index">
					<u-icon :name="item.icon" :label="item.text" @click="tip" size="48" label-size="22" margin-top="14"
						label-pos="bottom"></u-icon>
				</u-grid-item>
			</u-grid>
		</view>


		<view class="u-m-t-20">
			<u-cell-group>
				<u-cell-item icon="rmb-circle" title="我的云币" hover-class="cell-hover-class"
					@click="goToPage('/pages/tabbar/mine/coupon/coupon')"></u-cell-item>
				<u-cell-item icon="shopping-cart" title="我的购买" hover-class="cell-hover-class"
					@click="goToPage('/pages/tabbar/mine/coupon/coupon')"></u-cell-item>
				<u-cell-item icon="level" title="我的认证" hover-class="cell-hover-class"
					@click="goToPage('/pages/tabbar/mine/history/history')"></u-cell-item>
				<u-cell-item icon="eye" title="查看历史" hover-class="cell-hover-class"
					@click="goToPage('/pages/tabbar/mine/history/history')"></u-cell-item>
			</u-cell-group>
		</view>

		<view class="u-m-t-20">
			<u-cell-group>
				<u-cell-item icon="zhuanfa" title="分享给好友" hover-class="cell-hover-class">
					
				</u-cell-item>
				<u-cell-item icon="zhuanfa" title="关于" hover-class="cell-hover-class"
				@click="goToPage('/pages/tabbar/mine/about/about')">
					<!-- <u-link :color="color" :font-size="fontSize" :under-line="underLine" :href="href">官网</u-link> -->
				</u-cell-item>
				<u-cell-item icon="setting-fill" title="设置" hover-class="cell-hover-class"
					@click="goToPage('/pages/tabbar/mine/setting/setting')"></u-cell-item>
			</u-cell-group>
		</view>


	</view>
</template>

<script>
	import {
		mapState,
		mapActions,
	} from 'vuex'

	export default {
		computed: {
			...mapState(['token', 'userinfo', 'isLogin', 'needAuth']),

		},
		data() {
			return {
				href: 'http://alanxin.top',
				underLine: true,
				fontSize: 28,
				color: '#2979ff',
				
				pic: 'https://uviewui.com/common/logo.png',
				show: true,
				content: '',
				trace: {
					model: [{
							icon: 'chat',
							text: '评论'
						},
						{
							icon: 'bookmark',
							text: '关注'
						},
						{
							icon: 'star',
							text: '收藏'
						},
						{
							icon: 'eye',
							text: '足迹'
						}
					]
				}

			}
		},

		onLoad() {
			this.init(); //初始化，用户登录

		},
		methods: {
			...mapActions(['login', 'authUserInfo']),
			async init() {
				await this.login();
				console.log("是否需要登录：", this.$store.state.needAuth);
				this.show = this.$store.state.needAuth;
			},
			confirm() {
				this.authUserInfo();
			},
			cancel() {
				uni.showToast({
					title: '已取消授权',
					duration: 2000,
					icon: 'none'
				})
			},
			goToPage(url) {
				if (!url) return;
				uni.navigateTo({
					url
				});
			}

		}
	}
</script>

<style lang="scss">
	page {
		background-color: #ededed;
	}

	.auth {
		width: 100%;
		height: 200rpx;
		margin-top: 200rpx;
		justify-content: center;

	}

	.trace-box {
		background-color: #ffffff;
		padding: 0 10rpx 10rpx 10rpx;
	}

	.camera {
		width: 54px;
		height: 44px;

		&:active {
			background-color: #ededed;
		}
	}

	.user-box {
		background-color: #fff;
	}

	/* 或者单是设置透明度 */
	.cell-hover-class {
		opacity: 0.5;
	}
</style>
