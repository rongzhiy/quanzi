<template>
	<view class="wrap">
		<view class="top">
			<view class="item">
				<view class="left">昵称</view>
				<input type="text" placeholder-class="line" placeholder="修改昵称" />
			</view>
			<view class="item">
				<view class="left">手机号码</view>
				<input type="text" placeholder-class="line" placeholder="请填写你的手机号" />
			</view>
			<view class="item" >
				<view class="left">邮箱</view>
				<input disabled type="text" placeholder-class="line" placeholder="填写你的邮箱地址" />
			</view>
			<view class="item" >
				<view class="left">大学</view>
				<input disabled type="text" placeholder-class="line" placeholder="选择你所在的学校" />
			</view>
		
			<view class="site-clipboard">
				<textarea placeholder-class="line" value="" placeholder="粘贴文本,可自动识别姓名和地址等" />
				<view class="clipboard">
					地址粘贴板
				</view>
			</view>
		</view>
		<view class="save" @tap="toAddSite">
			<view class="add">
				<u-icon name="checkmark-circle" color="#ffffff" class="icon" :size="30"></u-icon>保存
			</view>
		</view>
		
	</view>
</template>

<script>
export default {
	data() {
		return {
			show: false
		};
	},
	methods: {
	}
};
</script>

<style lang="scss" scoped>
/deep/ .line {
	color: $u-light-color;
	font-size: 28rpx;
}
.wrap {
	background-color: #f2f2f2;
	.top {
		background-color: #ffffff;
		border-top: solid 2rpx $u-border-color;
		padding: 22rpx;
		.item {
			display: flex;
			font-size: 32rpx;
			line-height: 100rpx;
			align-items: center;
			border-bottom: solid 2rpx $u-border-color;
			.left {
				width: 180rpx;
			}
			input {
				text-align: left;
			}
		}
		
		.address {
			padding: 20rpx 0;
			textarea {
				// width: 100%;
				height: 150rpx;
				background-color: #f7f7f7;
				line-height: 60rpx;
				margin: 40rpx auto;
				padding: 20rpx;
			}
		}
		.site-clipboard {
			padding-right: 40rpx;
			textarea {
				// width: 100%;
				height: 150rpx;
				background-color: #f7f7f7;
				line-height: 60rpx;
				margin: 40rpx auto;
				padding: 20rpx;
			}
			.clipboard {
				display: flex;
				justify-content: center;
				align-items: center;
				font-size: 26rpx;
				color: $u-tips-color;
				height: 80rpx;
				.icon {
					margin-top: 6rpx;
					margin-left: 10rpx;
				}
			}
		}
	}
	.bottom {
		margin-top: 20rpx;
		padding: 40rpx;
		padding-right: 0;
		background-color: #ffffff;
		font-size: 28rpx;

		.default {
			margin-top: 50rpx;
			display: flex;
			justify-content: space-between;
			border-bottom: solid 2rpx $u-border-color;
			line-height: 64rpx;
			.tips {
				font-size: 24rpx;
			}
			.right {
			}
		}
	}
}
.save{
		display: flex;
		justify-content: space-around;
		width: 600rpx;
		line-height: 100rpx;
		position: absolute;
		bottom: 30rpx;
		left: 80rpx;
		background-color: red;
		border-radius: 60rpx;
		font-size: 30rpx;
		.add{
			display: flex;
			align-items: center;
			color: #ffffff;
			.icon{
				margin-right: 10rpx;
			}
		}
	
}
</style>
