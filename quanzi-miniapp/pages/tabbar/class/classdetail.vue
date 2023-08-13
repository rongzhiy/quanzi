<template>
	<view class="books-details">
		<view class="book-detail">
			
			<view class="detail-right">
				<view class="detail-right-box">
					<view class="title">详细评论详细评论详细评论细评论详细评论详细评论细评论详细评论详细评论？</view>
					<view class="author">(美) 戴尔·卡耐基 著</view>
					<view class="tag">
						<view class="tag-title">计算机</view>
						<view class="tag-title">人工智能</view>
					</view>
				</view>
				<view class="btn-box">
					<view class="readBtn">关注</view>
					<view class="joinBtn">收藏</view>
				</view>
			</view>
		</view>
		<!-- 阅读全文 -->
		<view class="book-jieshao">
			<u-read-more :toggle="true" show-height="400" :shadow-style="jieshaStyle" color="#0086E7" close-text="展开阅读全文"
			 font-size="26">
				<rich-text class="jiesha" :nodes="jiesha"></rich-text>
			</u-read-more>
		</view>
		
		<view class="review">
			<view class="review-head">评论</view>
			<view class="review-input">
				<input maxlength="150" confirm-type="go" placeholder="评论才是真爱" />
				<view class="review-btn">
					<u-icon name="plus"></u-icon>
				</view>
			</view>
			<view class="review-list">
				<view class="review-box" v-for="i in 10">
					<view class="user-message">
						<view class="message-img">
							<image class="user-img" src="https://s1.ax1x.com/2020/06/02/ttbbJU.jpg"></image>
						</view>
						<view class="message-name">
							<view class="head">
								Alan
							</view>
							<u-icon class="level" name="level" color="#0055ff"></u-icon>
							<text>{云南大学学生}</text>
						</view>
						<view class="message-praise">
							<view @click="iconActive" :class="{'icon-active':iconOFF}">
								<i class="iconfont love" />
							</view>
						</view>
					</view>
					<view class="con-tent">
						<p class="text">该书汇集了卡耐基的思想精华和激动人心的内容，是作者功的励志经典，出版后立即获得了广大读者的欢迎，成为西方世界的人文书。</p>
						<p class="time">2019-11-16</p>
					</view>
				</view>
				
				
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				jiesha: `《人性的弱点》自出版以来，已被译成 58 种文字畅销于世界各地，
				全球总销量达 9000 余万册，拥有 4 亿多读者，稳居成功励志类图书榜首，
				是人类出版史上继《圣经》之后的第二大畅销书。
				该书汇集了卡耐基的思想精华和激动人心的内容，是作者功的励志经典，
				出版后立即获得了广大读者的欢迎，成为西方世界的人文书。无数读者通过阅读和实践书中介绍的各种方法，
				不仅走出困境，有的还成为人仰慕的杰出人士。只要不断研读本书，相信你也可以发掘自己的无穷潜力，创造辉煌的人生。`,
				iconOFF:false, //爱心激活开关
				jieshaStyle: {
					backgroundImage: "linear-gradient(-180deg, rgba(255, 255, 255, 0) 0%, #fff 80%)",
					paddingTop: "80rpx",
					marginTop: "-80rpx",
				},
			};
		},
		methods: {
			rateBtn(value) {
				console.log(value)
			},
			iconActive(){
				this.iconOFF =! this.iconOFF
			}
		},
		mounted() {}
	}
</script>

<style lang="scss" scoped>
	.books-details {
		padding: 0 $bleed $navBoxHeight $bleed;
	}

	.book-detail {
		display: flex;
		padding-top: 40upx;

		.detail-right {
			height: 340upx;
			padding: 4upx 0;

			.detail-right-box {
				height: calc(100% - 64upx);
			}

			.title {
				font-size: 36upx;
				font-weight: 700;
				overflow: hidden;
				text-overflow: ellipsis;
				display: -webkit-box;
				-webkit-line-clamp: 2;
				-webkit-box-orient: vertical;
				margin-bottom: 10upx;
			}

			.author {
				font-size: 26upx;
				color: $mediumGrey;
				text-overflow: ellipsis;
				display: -webkit-box;
				-webkit-line-clamp: 1;
				-webkit-box-orient: vertical;
				padding-bottom: 20upx;
			}

			.tag {
				padding-bottom: 5upx;

				.tag-title {
					background-color: #EFF5FD;
					height: 48upx;
					line-height: 48upx;
					color: $mediumGrey;
					padding: 0 20upx;
					margin-right: 20upx;
					border-radius: 4upx;
					display: inline-block;
					font-size: 24upx;
				}
			}

			.btn-box {
				.readBtn {
					background-color: $dominantHue;
					border: 1px solid $dominantHue;
					padding: 0 30upx;
					display: inline-block;
					height: 64upx;
					line-height: 64upx;
					border-radius: 4upx;
					color: #fff;
					cursor: pointer;
					font-size: 28upx;
					margin-right: 26upx;
				}
				.readBtn:active{
					
				}
				.joinBtn {
					border: 1px solid $dominantHue;
					color: $dominantHue;
					padding: 0 29upx;
					height: 64upx;
					line-height: 64upx;
					display: inline-block;
					border-radius: 4upx;
					cursor: pointer;
					font-size: 28upx;
				}
			}
		}

	}

	.book-jieshao {
		padding: 40upx 0 30upx 0;
		overflow: hidden;

		.jiesha {
			width: 100%;
			word-wrap: break-word;
			color: $mediumGrey;
			line-height: 48upx;
			font-size: 26upx;
		}
	}

	
	.review {
		.review-head {
			font-size: 32upx;
			font-weight: 700;
			margin-bottom: 30upx;
		}

		.review-input {
			$review: 84upx;
			height: $review;
			border-radius: 8upx;
			border: 1px solid $dominantHue;
			margin-bottom: 60upx;
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
	}
	.review-list{
		.review-box{
			$imgWidth:96upx;
			padding-bottom: 40upx;
			.user-message{
				$userH:76upx;
				display: flex;
				height: $userH;
				.message-img{
					flex: 1;
					height: $userH;
					min-width: $imgWidth;
					max-width: $imgWidth;
					.user-img{
						width: $userH;
						height: $userH;
						border-radius: 50%;
						background-color: $skeletonColor;
					}
				}
				.message-name{
					flex: 1;
					.head{
						font-size: 28upx;
						height: 44upx;
					}
					.level {
						margin: 0 18rpx;
					}
				}
				.message-praise{
					flex: 1;
					line-height: $userH - 20upx;
					min-width: 40upx;
					max-width: 40upx;
					text-align: right;
					padding: 10upx 0;
					.icon-active{
						.love{
							color: $redAll;
						}
					}
					.love{
						font-size: 34upx;
						color: #A3B0C0;
					}
				}
				
			}
			.con-tent{
				
				padding:14upx 0 0 $imgWidth;
				.text{
					word-wrap : break-word;
					font-size: 26upx;
					line-height: 40upx;
					color: $mediumGrey;
				}
				.time{
					padding: 10upx 0 0 0;
					color: $lightGray;
					font-size: 24upx;
				}
			}
	
		}
	}
	
</style>
