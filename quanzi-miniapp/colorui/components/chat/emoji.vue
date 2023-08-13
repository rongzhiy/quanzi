<template>
	<view class="" style="">
		<view class="" style="height: 520rpx;overflow-y: auto;">
			<view class="cu-list grid" :class="['col-' + gridCol,gridBorder?'':'no-border']">
				<view @tap="toEmit('chat-content',item)" class="" v-for="(item,index) in emojis" :key="index" style="width: 12.5%;">
					<text class="text-sl" style="font-size: 60rpx;">{{item}}</text>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import emojis from "@/js_sdk/emoji.js"
	import app from "@/mixins/app.js"
	export default {
		data(){
			return {
				emojis:emojis,
				
				gridCol: 5,
				gridBorder: false,
			}
		},
		mixins:[app],
	}
</script>

<style>
</style>
