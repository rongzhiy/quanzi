<template>
	<view class="">
		<!-- 分类 -->
		<u-tabs v-if="control" bg-color="#fafafa" :bold="bold" :list="list" @change="change" :current="current"
			:is-scroll="isScroll" :offset="offset"></u-tabs>

		
		
		
	</view>
</template>

<script>
	import banner from '../../../components/banner/banner.vue'
	import classData from '@/common/class.js'
	
	export default {
		
		data() {
			return {
				list: [],
				data: classData,
				current: 1,
				isScroll: true,
				bold: true,
				control: true,
				offset: [5, -5]
			}

		},
		onLoad() {
			this.list = this.data;
		},
		methods: {
			change(index) {
				this.current = index;
				console.log(index);
			},
			selectBtn(selectKey) {
				// 精选区按钮 
				console.log('你点了第' + selectKey + '个选项')
				uni.navigateTo({
					url: '/pages/tabbar/index/rankList/rankList'
				})
			},
		}
	}
</script>


	// 分类item
<style lang="scss" scoped>
.order {
	width: 710rpx;
	background-color: #ffffff;
	margin: 20rpx auto;
	border-radius: 20rpx;
	box-sizing: border-box;
	padding: 20rpx;
	font-size: 28rpx;
	
	.item {
		display: flex;
		margin: 20rpx 0 0;
		.left {
			margin-right: 20rpx;
			image {
				width: 200rpx;
				height: 200rpx;
				border-radius: 10rpx;
			}
		}
		.content {
			.title {
				font-size: 28rpx;
				line-height: 50rpx;
			}
			.type {
				margin: 10rpx 0;
				font-size: 24rpx;
				color: $u-tips-color;
			}
			.delivery-time {
				color: #e5d001;
				font-size: 24rpx;
			}
		}
		.right {
			margin-left: 10rpx;
			padding-top: 20rpx;
			text-align: right;
			.decimal {
				font-size: 24rpx;
				margin-top: 4rpx;
			}
			.number {
				color: $u-tips-color;
				font-size: 24rpx;
			}
		}
	}
	.total {
		margin-top: 20rpx;
		text-align: right;
		font-size: 24rpx;
		.total-price {
			font-size: 32rpx;
		}
	}
	.bottom {
		display: flex;
		margin-top: 40rpx;
		padding: 0 10rpx;
		justify-content: space-between;
		align-items: center;
		.btn {
			line-height: 52rpx;
			width: 160rpx;
			border-radius: 26rpx;
			border: 2rpx solid $u-border-color;
			font-size: 26rpx;
			text-align: center;
			color: $u-type-info-dark;
		}
		.evaluate {
			color: $u-type-warning-dark;
			border-color: $u-type-warning-dark;
		}
	}
}

</style>
