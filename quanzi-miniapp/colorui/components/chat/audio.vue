<template>
	<view class="">
		
		<view class="cu-item self" v-if="message.from.id==user.id" >
			
			<view class="main" @tap="play()">
				<view class="action text-bold text-grey">
					{{message.data.extra.time}}"
				</view>
				<view class="content shadow">
					<text class="cuIcon-sound text-xxl padding-right-xl"> </text>
				</view>
			</view>
			<chat-avatar :message="message"></chat-avatar>
			<view class="date">{{message.sended_at}}</view>
			
		</view>
		<view class="cu-item" v-else>
			<chat-avatar :message="message"></chat-avatar>
			<view class="main"  @tap="play()">
				<view class="content shadow">
					<text class="cuIcon-sound text-xxl padding-right-xl"> </text>
				</view>
				<view class="action text-bold text-grey">
					{{message.data.extra.time}}"
				</view>
			</view>
			<view class="date">{{message.sended_at}}</view>
		</view>
	</view>
</template>

<script>
	import app from '@/mixins/app.js'
	const innerAudioContext = uni.createInnerAudioContext();
	innerAudioContext.autoplay = false;
	
	export default {
		name:'chat-audio',
		data(){
			return {
				playing:false
			}
		},
		mixins:[app],
		methods:{
			play(){
				if(this.playing){
					this.playing = false
					console.log('停止了播放')
					innerAudioContext.stop()
					return 
				}
				innerAudioContext.src = this.message.data.content;
				innerAudioContext.play()
				innerAudioContext.onPlay(() => {
				  console.log('开始播放');
				});
				innerAudioContext.onEnded(() => {
				  console.log('播放结束');
				  // alert('播放结束')
				  this.playing = false
				  innerAudioContext.stop()
				});
				innerAudioContext.onError((res) => {
				  console.log(res.errMsg);
				  console.log(res.errCode);
				});
				this.playing = true
			}
		},
		props: {
			message: {
				type: [Object],
				default: {}
			},
			
		},
	}
</script>
	
<style>
</style>
