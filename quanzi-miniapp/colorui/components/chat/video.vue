<template>
	<view class=""v-if="true">
		
		<view class="cu-item self"  v-if="message.from.id==user.id">
			<view class="content padding-right">
				<video style="width:280px" :src="message.data.content"
				                    id="myVideo" controls></video>
									
			</view>
			<chat-avatar :message="message"></chat-avatar>
			<view class="date">{{message.sended_at}}</view>
		</view>
		<view class="cu-item" v-else>
			<chat-avatar :message="message"></chat-avatar>
			<view class="content padding-left">
				<video style="width:280px"  id="myVideo" :src="message.data.content"
				                    controls></video>
			</view>
			<view class="date "> {{message.sended_at}} </view>
		</view>
	</view>
</template>

<script>
	import app from '@/mixins/app.js'
	export default {
		data(){
			return {
				src:'https://img.cdn.aliyun.dcloud.net.cn/guide/uniapp/%E7%AC%AC1%E8%AE%B2%EF%BC%88uni-app%E4%BA%A7%E5%93%81%E4%BB%8B%E7%BB%8D%EF%BC%89-%20DCloud%E5%AE%98%E6%96%B9%E8%A7%86%E9%A2%91%E6%95%99%E7%A8%8B@20200317.mp4'
			}
		},
		mixins:[app],
		methods:{
			
				
		},
		props: {
			message: {
				type: [Object],
				default: {}
			},
			
		},
		mounted() {
			console.log(this.message,'messgae')
			console.log(this.user,'user')
		}
	}
</script>
	
<style>
</style>
