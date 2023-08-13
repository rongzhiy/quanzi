<template>
	<qs-page :footer="true">
		<!-- 页面主体 -->
		<view class="news-detail">

			<!-- #ifndef MP -->
			<u-gap height="40"></u-gap>
			<!-- #endif -->
			<view class="detail-title">这里是问题这里是问题这里是问题这里是问题这里是问题</view>
			<view class="user">
				<image class="user-avatar" src="https://vkceyugu.cdn.bspapp.com/VKCEYUGU-e42fdc3b-23cf-47f9-a5dd-f290a9ce3b87/8df8fd74-e9de-4aa6-8fcd-3924ff35197a.jpg" mode="widthFix" />
				<view class="user-info">
					<text class="nickname">阿泽</text>
					<u-icon class="level" name="level" color="#0055ff"></u-icon>
					<text>云南大学</text>
				</view>
				<view class="btn-box">
					<view class="joinBtn">
						关注
					</view>
				</view>
			</view>
			<view class="detail-content">
				<view class="u-m-b-20" v-for="i in 3">
					6月23日消息 今天在WWDC 2020大会上，苹果发布了iOS
					14、iPadOS14系统，首次（正式）介绍了其最新版的iPhone软件，它为iOS主屏幕带来了多年来最大的变化：小插件，另外还有App资源库、画中画模式等。
					今天苹果面向开发人员发布了iOS 14/iPadOS 14开发者预览版/公开测试版 Beta ，具体版本号为18A5301，开启新一轮的iOS/iPadOS系统测试，大家可以到【果粉圈】集中讨论。
					良维上周举行董事会，其董事长李淳正表示良维越南厂最快可于 2020 年第 4 季度实现量产，该厂将主要负责生产新款 iPhone，AirPods 与 iPad 等设备的
					Type-C的连接器和线材产品。

				</view>
			</view>
			
			<u-gap height="40"></u-gap>
		</view>

		<!-- 评论区 -->
		<view class="review-head">评论</view>
		<view class="review-input">
			<input maxlength="150" confirm-type="go" placeholder="评论才是真爱" />
			<view class="review-btn">
				<u-icon name="plus"></u-icon>
			</view>
		</view>
		<view class="comment" v-for="(res, index) in commentList" :key="res.id">
			<view class="left">
				<image :src="res.url" mode="aspectFill"></image>
			</view>
			<view class="right">
				<view class="top">
					<view class="name">{{ res.name }}</view>
					<view class="like" :class="{ highlight: res.isLike }">
						<view class="num">{{ res.likeNum }}</view>
						<u-icon v-if="!res.isLike" name="thumb-up" :size="30" color="#9a9a9a" @click="getLike(index)">
						</u-icon>
						<u-icon v-if="res.isLike" name="thumb-up-fill" :size="30" @click="getLike(index)"></u-icon>
					</view>
				</view>
				<view class="content">{{ res.contentText }}</view>
				<view class="reply-box">
					<view class="item" v-for="(item, index) in res.replyList" :key="item.index">
						<view class="username">{{ item.name }}</view>
						<view class="text">{{ item.contentStr }}</view>
					</view>
					<view class="all-reply" @tap="toAllReply" v-if="res.replyList != undefined">
						共{{ res.allReply }}条回复
						<u-icon class="more" name="arrow-right" :size="26"></u-icon>
					</view>
				</view>
				<view class="bottom">
					{{ res.date }}
					<view class="reply">回复</view>
				</view>
			</view>
		</view>
			
		<u-gap height="120"></u-gap>
		
		<!-- 页面底部 -->
		<block slot="footer">
			<view class="u-flex my-page-footer">
				<view class="footer-action" @click="goBack">
					<u-icon name="arrow-left" size="36"></u-icon>
				</view>
				<view class="u-flex-1">
					<u-search placeholder="说两句..." :show-action="false"></u-search>
				</view>
				<view class="footer-action" @click="tip">
					<u-icon name="arrow-upward" size="36"></u-icon>
				</view>
				<view class="footer-action" @click="tip">
					<u-icon name="star" size="36"></u-icon>
				</view>
				<view class="footer-action" @click="tip">
					<u-icon name="zhuanfa" size="36"></u-icon>
				</view>
				<view class="footer-action" @click="tip">
					<u-icon name="more-dot-fill" size="36"></u-icon>
				</view>
			</view>
		</block>

	</qs-page>
</template>

<script>
	export default {
		data() {
			return {
				commentList: []
			};
		},
		onLoad() {
			this.getComment();
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
			// 返回
			goBack() {
				uni.navigateBack();
			},

			// 跳转到全部回复
			toAllReply() {
				uni.navigateTo({
					url: '/pages/news/reply'
				});
			},
			// 点赞
			getLike(index) {
				this.commentList[index].isLike = !this.commentList[index].isLike;
				if (this.commentList[index].isLike == true) {
					this.commentList[index].likeNum++;
				} else {
					this.commentList[index].likeNum--;
				}
			},
			// 评论列表
			getComment() {
				this.commentList = [{
						id: 1,
						name: '叶轻眉',
						date: '12-25 18:58',
						contentText: '我不信伊朗会没有后续反应，美国肯定会为今天的事情付出代价的',
						url: 'https://cdn.uviewui.com/uview/template/SmilingDog.jpg',
						allReply: 12,
						likeNum: 33,
						isLike: false,
						replyList: [{
								name: 'uview',
								contentStr: 'uview是基于uniapp的一个UI框架，代码优美简洁，宇宙超级无敌彩虹旋转好用，用它！'
							},
							{
								name: '粘粘',
								contentStr: '今天吃什么，明天吃什么，晚上吃什么，我只是一只小猫咪为什么要烦恼这么多'
							}
						]
					},
					{
						id: 2,
						name: '叶轻眉1',
						date: '01-25 13:58',
						contentText: '我不信伊朗会没有后续反应，美国肯定会为今天的事情付出代价的',
						allReply: 0,
						likeNum: 11,
						isLike: false,
						url: 'https://cdn.uviewui.com/uview/template/niannian.jpg',
					},
					{
						id: 4,
						name: '叶轻眉3',
						date: '06-20 13:58',
						contentText: '我不信伊朗会没有后续反应，美国肯定会为今天的事情付出代价的',
						url: 'https://cdn.uviewui.com/uview/template/SmilingDog.jpg',
						allReply: 0,
						likeNum: 150,
						isLike: false
					}
				];
			}
		}
	};
</script>

<style lang="scss">
	.my-page-footer {
		height: 48px;
		background-color: $uni-bg-color-grey;
		padding: 0 10rpx;

		.footer-action {
			padding: 0 20rpx;
		}
	}

	.news-detail {
		background-color: #ffffff;

		.user {
			width: 100%;
			height: 60rpx;
			border-radius: 20rpx;
			display: flex;
			align-items: center;
			margin: 16rpx 0 0 40rpx;
		
			.user-avatar {
				width: 46rpx;
				height: 46rpx;
				border-radius: 50%;
				border: 1px solid #ced4c8;
			}
		
			.user-info {
				font-size: 24rpx;
				margin-left: 16rpx;
				.level {
					margin: 0 18rpx;
				}
			}
			.btn-box {
				margin-left: 200rpx;
				.joinBtn {
					border: 1px solid $dominantHue;
					color: $dominantHue;
					padding: 0 29upx;
					height: 50upx;
					line-height: 50upx;
					display: inline-block;
					border-radius: 20rpx;
					cursor: pointer;
					font-size: 28upx;
				}
				.joinBtn:active{
					background-color: $dominantHue;
					border: 1px solid $dominantHue;
					padding: 0 30upx;
					display: inline-block;
					height: 50upx;
					line-height: 50upx;
					border-radius: 20upx;
					color: #fff;
					cursor: pointer;
					font-size: 28upx;
					
				}
			}
			
		}
		
		.detail-title {
			border-left: 10rpx solid #d81e06;
			padding: 0 30rpx;
			font-size: $uni-font-size-title;
			font-weight: bold;
			color: $uni-color-title;
			line-height: 1.5;
		}

		
		.detail-content {
			padding: 30rpx 30rpx;
			font-size: $uni-font-size-paragraph;
			color: $uni-color-paragraph;
			line-height: 2;
		}
	}
	
	.review-head {
			font-size: 32rpx;
			font-weight: 700;
			padding-right: 40rpx 40rpx 40rpx 40rpx;
			background-color: #FFFFFF;
		}

		.review-input {
			$review: 84upx;
			height: $review;
			border-radius: 8upx;
			margin: 40upx 40upx;
			border: 1px solid $dominantHue;
			input {
				height: $review - 2upx;
				line-height: $review - 2upx;
				padding: 0 20upx;
				float: left;
				width: calc(100% - 112upx);
				font-size: 28upx;
				box-sizing:border-box;
			}

			.review-btn {
				float: right;
				height: $review - 2upx;
				line-height: $review - 2upx;
				width: 112upx;
				background-color: $dominantHue;
				text-align: center;

				.send {
					color: #fff;
					font-size: 48upx;
				}
			}
		}

	.comment {
		display: flex;
		padding: 30rpx;

		.left {
			image {
				width: 64rpx;
				height: 64rpx;
				border-radius: 50%;
				background-color: #f2f2f2;
			}
		}

		.right {
			flex: 1;
			padding-left: 20rpx;
			font-size: 30rpx;

			.top {
				display: flex;
				justify-content: space-between;
				align-items: center;
				margin-bottom: 10rpx;

				.name {
					color: #5677fc;
				}

				.like {
					display: flex;
					align-items: center;
					color: #9a9a9a;
					font-size: 26rpx;

					.num {
						margin-right: 4rpx;
						color: #9a9a9a;
					}
				}

				.highlight {
					color: #5677fc;

					.num {
						color: #5677fc;
					}
				}
			}

			.content {
				margin-bottom: 10rpx;
			}

			.reply-box {
				background-color: rgb(242, 242, 242);
				border-radius: 12rpx;

				.item {
					padding: 20rpx;
					border-bottom: solid 2rpx $u-border-color;

					.username {
						font-size: 24rpx;
						color: #999999;
					}
				}

				.all-reply {
					padding: 20rpx;
					display: flex;
					color: #5677fc;
					align-items: center;

					.more {
						margin-left: 6rpx;
					}
				}
			}

			.bottom {
				margin-top: 20rpx;
				display: flex;
				font-size: 24rpx;
				color: #9a9a9a;

				.reply {
					color: #5677fc;
					margin-left: 10rpx;
				}
			}
		}
	}
</style>
