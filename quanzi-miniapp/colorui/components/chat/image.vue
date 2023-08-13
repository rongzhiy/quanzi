<template>
	<view class="">
		<view class="cu-item self" v-if="message.from.id==user.id">
			<view class="main">
				<image mode="aspectFit" :src="$tool.chat_img_url(message.data.content)" :data-url="$tool.chat_img_url(message.data.content)" @tap="imViewImage"></image>
			</view>
			<chat-avatar :message="message"></chat-avatar>
			<view class="date">{{message.sended_at}}</view>
		</view>
		<view class="cu-item" v-else>
			<chat-avatar :message="message"></chat-avatar>
			<view class="date">{{message.sended_at}}</view>
			<view class="main">
				<image mode="aspectFit" :src="$tool.chat_img_url(message.data.content)" :data-url="$tool.chat_img_url(message.data.content)" @tap="imViewImage"></image>
			</view>
		</view>
	</view>
</template>

<script>
	import app from '@/mixins/app.js'
	export default {
		name:'chatimage',
		data(){
			return {
				
			}
		},
		mixins:[app],
		methods:{
			imViewImage(e) {
				uni.previewImage({
					urls: this.current_images,
					current: e.currentTarget.dataset.url
				});
			},
		},
		props: {
			message: {
				type: [Object],
				default: {}
			},
			current_images:{
				type:[Array],
				default:()=>{
					return []
				}
			}
			
		}
	}
</script>
	
<style>
</style>
