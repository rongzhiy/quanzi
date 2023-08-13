<template>
	<view>
		<view class="cu-chat">
			<view class="cu-item self">
				<view class="main">
					<view class="content uni-bg-blue shadow">
						<text>喵喵喵！喵喵喵！喵喵喵！喵喵！喵喵！！喵！喵喵喵！</text>
					</view>
				</view>
				<view class="cu-avatar radius"
					style="background-image:url(https://ossweb-img.qq.com/images/lol/web201310/skin/big107000.jpg);">
				</view>
				<view class="date">2018年3月23日 13:23</view>
			</view>
			<view class="cu-item">
				<view class="cu-avatar radius"
					style="background-image:url(https://ossweb-img.qq.com/images/lol/web201310/skin/big143004.jpg);">
				</view>
				<view class="main">
					<view class="content uni-bg-blue shadow">
						<text>喵喵喵！喵喵喵！</text>
					</view>
				</view>
				<view class="date ">2018年3月23日 13:23</view>
			</view>

			<view class="cu-item self">
				<view class="main">
					<image src="https://ossweb-img.qq.com/images/lol/web201310/skin/big10006.jpg" class="radius"
						mode="widthFix"></image>
				</view>
				<view class="cu-avatar radius"
					style="background-image:url(https://ossweb-img.qq.com/images/lol/web201310/skin/big107000.jpg);">
				</view>
				<view class="date">2018年3月23日 13:23</view>
			</view>
			
		</view>

		<!--  输入区 -->
		<view class="cu-bar foot input" :style="[{bottom:InputBottom+'px'}]">
			<view class="action">
				<text class="cuIcon-sound text-grey"></text>
			</view>
			<input class="solid-bottom" :adjust-position="false" :focus="false" maxlength="300" cursor-spacing="10"
				@focus="InputFocus" @blur="InputBlur"></input>
			<view class="action">
				<text class="cuIcon-emojifill text-grey"></text>
			</view>
			<button class="cu-btn uni-bg-blue shadow">发送</button>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				InputBottom: 0
			};
		},
		methods: {
			InputFocus(e) {
				this.InputBottom = e.detail.height
			},
			InputBlur(e) {
				this.InputBottom = 0
			}
		}
	}
</script>

<style>
	page {
		padding-bottom: 100upx;
	}
</style>
