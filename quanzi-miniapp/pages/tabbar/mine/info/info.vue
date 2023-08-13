<template>
	<view>
		<view class="item" v-for="(res, index) in siteList" :key="res.id">
			<view class="top">
				<view class="name">{{ res.name }}</view>
				<view class="phone">{{ res.phone }}</view>
				<view class="tag">
					<text v-for="(item, index) in res.tag" :key="index" :class="{red:item.tagText=='默认'}">{{ item.tagText }}</text>
				</view>
			</view>
			<view class="bottom u-m-t-20" >
				邮箱：2735545128@qq.com
			</view>
			<view class="bottom">
				学校：云南大学
			</view>
			<view class="bottom">
				专业：计算机科学与技术
			</view>
			<view class="bottom">
				地址：云南大学楸苑二栋
			</view>
		</view>
		<view class="addSite" @tap="toAddSite">
			<view class="add">
				<u-icon name="edit-pen" color="#ffffff" class="icon" :size="30"></u-icon>修改个人信息
			</view>
		</view>
	</view>
</template>

<script>
export default {
	data() {
		return {
			siteList: []
		};
	},
	onLoad() {
		this.getData();
	},
	methods: {
		getData() {
			this.siteList = [
				{
					id: 1,
					name: '杨荣智',
					phone: '183****5523',
					tag: [
						{
							tagText: '默认'
						}
					],
					site: '广东省深圳市宝安区 自由路66号'
				}
			];
		},
		toAddSite(){
			uni.navigateTo({
			    url: '/pages/tabbar/mine/info/editInfo/editInfo'
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.item {
	padding: 40rpx 20rpx;
	.top {
		display: flex;
		font-weight: bold;
		font-size: 34rpx;
		.phone {
			margin-left: 60rpx;
		}
		.tag {
			display: flex;
			font-weight: normal;
			align-items: center;
			text {
				display: block;
				width: 60rpx;
				height: 34rpx;
				line-height: 34rpx;
				color: #ffffff;
				font-size: 20rpx;
				border-radius: 6rpx;
				text-align: center;
				margin-left: 30rpx;
				background-color:rgb(49, 145, 253);
			}
			.red{
				background-color:red
			}
		}
	}
	.bottom {
		display: flex;
		margin-top: 20rpx;
		font-size: 28rpx;
		justify-content: space-between;
		color: #999999;
	}
}
.addSite {
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
