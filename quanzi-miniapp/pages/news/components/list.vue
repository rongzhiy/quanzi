<template>
	<view>
		<!-- 问答列表 -->
		<view class="news-list" @click="openPage('news/detail')" v-for="i in 10">
			<u-gap height="10" bg-color="#f9f9f9"></u-gap>
			<view class="question-title">
				<text>
					{这里是问是问题的题标题这里是问题标题这里题的标题这里是问题标题这里是问题标题这里是问题标题这里是问题?}
				</text>
			</view>
			<view class="user">
				<image class="user-avatar" src="https://vkceyugu.cdn.bspapp.com/VKCEYUGU-e42fdc3b-23cf-47f9-a5dd-f290a9ce3b87/8df8fd74-e9de-4aa6-8fcd-3924ff35197a.jpg" mode="widthFix" />
				<view class="user-info">
					<text class="nickname">{用户名}</text>
					<u-icon class="level" name="level" color="#0055ff"></u-icon>
					<text>{认证单位}</text>
				</view>
			</view>
			<view class="u-flex u-col-top list-item">
				<view class="u-flex-1 list-item-main">
					<view class="u-line-2 news-title">
						<text>
							{这里里是回答的内容是回答的内容是回答的内容是回答的内容是回答的内容，里是回答的内容，里是回答的内容，是回答的内容，回答的内容}
						</text>
					</view>
					<view class="u-flex news-extra">
						<view>{22222}人赞同</view>
						<view class="circle"></view>
						<view>{122}条评论</view>
						<view class="more" @click.stop="tip()">
							<u-icon name="more-dot-fill"></u-icon>
						</view>
					</view>
				</view>
			</view>
			<u-gap height="15" bg-color="#f9f9f9"></u-gap>
		</view>

		<!-- 图文列表 -->
		<view class="news-list">
			<view class="u-flex u-col-top list-item" v-for="item in list" :key="item.id"
				@click="openPage('news/detail')">
				<view class="list-item-side">
					<image class="news-pic"
						:src="item.imageUrl == '' ? 'https://i.loli.net/2021/04/16/jvB9MRVDrXcmeop.png' : item.imageUrl"
						mode="widthFix" />
				</view>
				<view class="u-flex-1 list-item-main">
					<view class="news-content">
						<view class="u-line-2 news-title">{ item.title }</view>
					</view>
					<view class="u-flex u-row-between news-extra">
						<view> { item.date }</view>
						<view>{ item.comment } 评</view>
					</view>
				</view>
			</view>
			<u-gap height="30" bg-color="#f9f9f9"></u-gap>
		</view>

		<!-- <view class="news-list">
		<view class="u-flex u-col-top list-item" v-for="item in list" :key="item.id"  @click="openPage('news/detail')">
			<view class="list-item-side">
				<image
					class="news-pic"
					:src="item.imageUrl == '' ? 'https://i.loli.net/2021/04/16/jvB9MRVDrXcmeop.png' : item.imageUrl"
					mode="widthFix"
				/>
			</view>
			<view class="u-flex-1 list-item-main">
				<view class="news-content">
					<view class="u-line-2 news-title">{{ item.title }}</view>
				</view>
				<view class="u-flex u-row-between news-extra">
					<view>{{ item.date }}</view>
					<view>{{ item.comment }} 评</view>
				</view>
			</view>
		</view>
	</view> -->

	</view>
</template>

<script>
	export default {
		props: {
			list: {
				// 数据列表
				type: Array,
				default () {
					return [];
				}
			}
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
			}
		}
	};
</script>

<style lang="scss" scoped>
	.news-list {
		background-color: #fff;
		
		.question-title {
			padding: 10rpx 20rpx 0rpx 20rpx;
			margin-left: 20rpx;
			font-size: 35rpx;
			font-weight: 600;
			//文本截断
			text {
				overflow: hidden;
				text-overflow: ellipsis;
				display: -webkit-box;
				-webkit-line-clamp: 2;
				-webkit-box-orient: vertical;
			}
		}

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
		}

		.list-item {
			padding: 30rpx 30rpx;
			border-bottom: 1rpx solid #F5F5F5;
			font-size: 34rpx;

			.list-item-side {
				width: 160rpx;
				height: 120rpx;
				margin-right: 20rpx;
			}
		}

		.news-pic {
			width: 160rpx;
			height: 120rpx;
		}

		.news-title {
			// font-size: 26rpx;
			font-weight: 400;

			text {
				overflow: hidden;
				text-overflow: ellipsis;
				display: -webkit-box;
				-webkit-line-clamp: 2;
				-webkit-box-orient: vertical;
			}
		}

		.news-extra {
			font-size: 24rpx;
			color: $uni-text-color-grey;
			margin-top: 20rpx;

			.circle {
				width: 6rpx;
				height: 6rpx;
				margin: 0 16rpx;
				background-color: $uni-text-color-grey;
			}

			.more {
				margin-left: auto;
			}
		}
	}
</style>
