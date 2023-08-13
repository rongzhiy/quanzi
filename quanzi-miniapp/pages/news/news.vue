<template>
	<qs-page :header="true">
		<!-- 页面头部 -->
		<block slot="header">
			<!-- #ifdef H5 -->
			<status-bar></status-bar>
			<nav-bar>
			</nav-bar>
			<!-- #endif -->
			
			<!-- tabs -->
			<u-tabs ref="tabs" :list="tabs.items" :current="tabs.current" @change="tabsChange" height="80" active-color="#005ce6" inactive-color="#606266"></u-tabs>
		</block>
		
		<block slot="header-placeholder">
			<!-- <status-bar></status-bar> -->
			<nav-bar></nav-bar>
		<!-- //#ifdef MP-WEIXIN
			<u-gap height="80"></u-gap>
			//#endif -->
		</block>
	
		<!-- 页面主体 -->
		<swiper :style="{ height: height }" :current="tabs.current" @change="swiperChange">
			<swiper-item v-for="(tab, i) in tabs.items" :key="i">
				<mescroll-item :i="i" :index="tabs.current" :tabs="tabs.items"></mescroll-item>
			</swiper-item>
		</swiper>
	</qs-page>
</template>

<script>
import MescrollItem from './components/mescroll-item.vue';
import tabData from '@/common/class.js'

export default {
	components: {
		MescrollItem
	},
	data() {
		return {
			height: '400px', // 需要固定swiper的高度
			tabs: {
				items: tabData,
				current: 0
			}
		};
	},
	methods: {
		// 打开页面
		openPage(path) {
			this.$u.route({
				url: '/pages/' + path
			});
		},
		// 提示
		tip() {
			return this.$u.toast('暂未开通');
		},
		// 标签栏
		tabsChange(i) {
			this.tabs.current = i;
		},
		// 轮播
		swiperChange(e) {
			this.tabs.current = e.detail.current;
		}
	},
	onLoad() {
		// 需要固定swiper的高度
		this.height = uni.getSystemInfoSync().windowHeight + 'px';
	}
};
</script>

<style lang="scss" scoped></style>
