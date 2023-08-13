<template>
	<view class="content">
		<view class="msg_16">
			<view class="msg_2">
				<view class="msg_12" @click="commont('评论')">
					<image src="/static/img/icon/pl.png" mode="scaleToFill" border="0"
						class="icon"></image>
					<text decode="true" class="word">评论</text>
				</view>
				<view class="msg_13" @click="follow('粉丝')">
					<image  src="/static/img/icon/gz.png" mode="scaleToFill" border="0"
						class="icon"></image>
					<text decode="true" class="word">粉丝</text>
				</view>
				<view class="msg_14" @click="like('点赞')">
					<image src="/static/img/icon/souc.png" mode="scaleToFill" border="0"
						class="icon"></image>
					<text decode="true" class="word">点赞</text>
				</view>
			</view>
			<view class="Messages" @click="goToPage('/pages/tabbar/message/chat/chat')">
				<view v-for="(item_Messages, index) in list_Messages" :key="index">
					<view class="row">
						<image v-on:click="icon_40_click(item_Messages)" :src="item_Messages.icon" mode="scaleToFill"
							border="0" class="icon"></image>
						<view class="msg_41">
							<view class="msg_42">
								<text decode="true" class="nickname">{{item_Messages.nickname}}</text>
								<text decode="true" class="time">{{item_Messages.time}}</text>
							</view>
							<view class="msg_43">
								<text decode="true" class="content">{{item_Messages.content}}</text>
								<text decode="true" class="vote">{{item_Messages.vote}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>

	</view>
</template>

<script>
	// 定义全局参数,控制数据加载
	var _self, page = 1;

	export default {
		data() {
			return {
				list_Messages: [{
						nickname: '推送助手官方',
						time: '11:10',
						content: '16岁少女检测2次呈阴性突然发病去世',
						vote: '25',
						icon: 'https://uviewui.com/common/logo.png',

					},
					{
						nickname: '推送助手官方',
						time: '11:10',
						content: '16岁少女检测2次呈阴性突然发病去世',
						vote: '25',
						icon: 'https://uviewui.com/common/logo.png',

					}
					,
					{
						nickname: '推送助手官方',
						time: '11:10',
						content: '16岁少女检测2次呈阴性突然发病去世',
						vote: '25',
						icon: 'https://uviewui.com/common/logo.png',
					
					}
				]

			}
		},
		
		methods:{
			commont(e){
				console.log(e);
			},
			follow(e){
				console.log(e);
			},
			like(e){
				console.log(e);
			},
			goToPage(url) {
				if (!url) return;
				uni.navigateTo({
					url
				});
			}
		},
		
		
		
		
	}
</script>

<style lang="scss" scoped>
	button::after {
		border: none;
		width: auto;
	}

	input {
		outline: none;
		border: none;
		list-style: none;
		width: auto;
	}

	.list_item {
		float: left;
	}

	.ym_hide {
		display: none;
	}

	.ym_show {
		display: block;
	}

	.slide-image {
		width: 100%;
		height: 100%;
	}

	.list_horizontal {
		width: auto;
		display: inline-block;
	}

	.msg_16 {
		white-space: normal;
		width: 749upx;
		min-height: 1331upx;
		padding: 0upx;
		clear: both;
		float: left;
		background-color: #f4f5f4;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
	}

	.msg_16 .msg_1 {
		white-space: normal;
		width: 749upx;
		height: 85upx;
		padding: 0upx;
		clear: both;
		margin-top: 0upx;
		margin-left: 0upx;
		float: left;
		background-color: #ffffff;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
	}

	.msg_16 .msg_1 .msg_17 {
		white-space: normal;
		width: 21upx;
		height: 36upx;
		padding: 0upx;
		margin-top: 25upx;
		margin-left: 34upx;
		float: left;
		text-align: left;
		border-radius: 0upx;
		font-size: 35upx;
		line-height: 36upx;
	}

	.msg_16 .msg_1 .title {
		white-space: normal;
		width: 149upx;
		height: 43upx;
		padding: 0upx;
		margin-top: 22upx;
		margin-left: 245upx;
		float: left;
		background-color: #ffffff;
		text-align: center;
		justify-content: center;
		border-radius: 0upx;
		color: #000000;
		font-size: 30upx;
		line-height: 43upx;
	}

	.msg_16 .msg_2 {
		white-space: normal;
		width: 749upx;
		height: 207upx;
		padding: 0upx;
		clear: both;
		margin-top: 0upx;
		margin-left: 0upx;
		float: left;
		background-color: #ffffff;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
	}

	.msg_16 .msg_2 .msg_12 {
		white-space: normal;
		width: 148upx;
		height: 176upx;
		padding: 0upx;
		margin-top: 13upx;
		margin-left: 51upx;
		float: left;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
	}

	.msg_16 .msg_2 .msg_12 .icon {
		white-space: normal;
		width: 92upx;
		height: 92upx;
		padding: 0upx;
		clear: both;
		margin-top: 21upx;
		margin-left: 31upx;
		float: left;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
		line-height: 92upx;
	}

	.msg_16 .msg_2 .msg_12 .word {
		white-space: normal;
		width: 70upx;
		height: 31upx;
		padding: 0upx;
		clear: both;
		margin-top: 9upx;
		margin-left: 43upx;
		float: left;
		background-color: #ffffff;
		text-align: center;
		justify-content: center;
		border-radius: 0upx;
		color: #000000;
		font-size: 24upx;
		line-height: 31upx;
	}

	.msg_16 .msg_2 .msg_13 {
		white-space: normal;
		width: 158upx;
		height: 176upx;
		padding: 0upx;
		margin-top: 13upx;
		margin-left: 94upx;
		float: left;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
	}

	.msg_16 .msg_2 .msg_13 .icon {
		white-space: normal;
		width: 92upx;
		height: 92upx;
		padding: 0upx;
		clear: both;
		margin-top: 21upx;
		margin-left: 34upx;
		float: left;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
		line-height: 92upx;
	}

	.msg_16 .msg_2 .msg_13 .word {
		white-space: normal;
		width: 70upx;
		height: 31upx;
		padding: 0upx;
		clear: both;
		margin-top: 9upx;
		margin-left: 45upx;
		float: left;
		background-color: #ffffff;
		text-align: center;
		justify-content: center;
		border-radius: 0upx;
		color: #000000;
		font-size: 24upx;
		line-height: 31upx;
	}

	.msg_16 .msg_2 .msg_14 {
		white-space: normal;
		width: 133upx;
		height: 176upx;
		padding: 0upx;
		margin-top: 13upx;
		margin-left: 97upx;
		float: left;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
	}

	.msg_16 .msg_2 .msg_14 .icon {
		white-space: normal;
		width: 91upx;
		height: 92upx;
		padding: 0upx;
		clear: both;
		margin-top: 21upx;
		margin-left: 23upx;
		float: left;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
		line-height: 92upx;
	}

	.msg_16 .msg_2 .msg_14 .word {
		white-space: normal;
		width: 70upx;
		height: 31upx;
		padding: 0upx;
		clear: both;
		margin-top: 9upx;
		margin-left: 34upx;
		float: left;
		background-color: #ffffff;
		text-align: center;
		justify-content: center;
		border-radius: 0upx;
		color: #000000;
		font-size: 25upx;
		line-height: 31upx;
	}

	.msg_16 .Messages {
		white-space: normal;
		width: 749upx;
		min-height: 979upx;
		padding: 0upx;
		clear: both;
		margin-top: 14upx;
		margin-left: 0upx;
		float: left;
		background-color: #ffffff;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
	}

	.msg_16 .Messages .row {
		white-space: normal;
		width: 724upx;
		height: 138upx;
		padding: 0upx;
		margin-top: 20upx;
		margin-left: 13upx;
		float: left;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
	}

	.msg_16 .Messages .row .icon {
		white-space: normal;
		width: 104upx;
		height: 104upx;
		padding: 0upx;
		margin-top: 15upx;
		margin-left: 8upx;
		float: left;
		text-align: left;
		border-radius: 75upx;
		font-size: 8upx;
		line-height: 104upx;
	}

	.msg_16 .Messages .row .msg_41 {
		white-space: normal;
		width: 586upx;
		height: 93upx;
		padding: 0upx;
		margin-top: 23upx;
		margin-left: 15upx;
		float: left;
		text-align: left;
		border-radius: 0upx;
		font-size: 8upx;
	}

	.msg_16 .Messages .row .msg_41 .msg_42 {
		white-space: normal;
		width: 584upx;
		height: 40upx;
		padding: 0upx;
		clear: both;
		margin-top: 4upx;
		margin-left: 2upx;
		float: left;
		text-align: left;
		border-radius: 0upx;
		font-size: 37upx;
		line-height: 40upx;
	}

	.msg_16 .Messages .row .msg_41 .msg_42 .nickname {
		white-space: normal;
		width: 405upx;
		height: 34upx;
		padding: 0upx;
		margin-top: 6upx;
		margin-left: 3upx;
		float: left;
		background-color: #ffffff;
		text-align: left;
		border-radius: 0upx;
		color: #000000;
		font-size: 29upx;
		line-height: 34upx;
	}

	.msg_16 .Messages .row .msg_41 .msg_42 .time {
		white-space: normal;
		width: 131upx;
		height: 20upx;
		padding: 0upx;
		margin-top: 9upx;
		margin-left: 41upx;
		float: left;
		background-color: #ffffff;
		text-align: right;
		border-radius: 0upx;
		color: #c8c8c8;
		font-size: 17upx;
		line-height: 20upx;
	}

	.msg_16 .Messages .row .msg_41 .msg_43 {
		white-space: normal;
		width: 584upx;
		height: 40upx;
		padding: 0upx;
		clear: both;
		margin-top: 4upx;
		margin-left: 2upx;
		float: left;
		text-align: left;
		border-radius: 0upx;
		font-size: 38upx;
		line-height: 40upx;
	}

	.msg_16 .Messages .row .msg_41 .msg_43 .content {
		white-space: normal;
		width: 490upx;
		height: 26upx;
		padding: 0upx;
		margin-top: 3upx;
		margin-left: 4upx;
		float: left;
		background-color: #ffffff;
		text-align: left;
		border-radius: 0upx;
		color: #c8c8c8;
		font-size: 25upx;
		line-height: 26upx;
	}

	.msg_16 .Messages .row .msg_41 .msg_43 .vote {
		white-space: normal;
		width: 43upx;
		height: 31upx;
		padding: 0upx;
		margin-top: 4upx;
		margin-left: 42upx;
		float: left;
		background-color: #f84336;
		text-align: center;
		justify-content: center;
		border-radius: 10upx;
		color: #ffffff;
		font-size: 24upx;
		line-height: 31upx;
	}
</style>
