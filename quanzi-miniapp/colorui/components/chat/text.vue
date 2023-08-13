<template>
	<view class="">
		
<!-- 		<view class="" style="position: fixed;top: 100px;left: 50%;"> 
			<view class="popup" >
				<text>hello world</text>
				<text>hello world</text>
				<text>hello world</text>
				<text>hello world</text>
				<text>hello world</text>
			</view>
		</view> -->
		
		<view class="cu-item self " v-if="message.from.id==user.id">
			<view class="main">
				<view class="content bg-green shadow " @tap="twoTextClick()">
					<text class="">{{message.data.content}}</text>
				</view>
			</view>
			<chat-avatar :message="message"></chat-avatar>
			<view class="date">{{message.sended_at}}</view>
		</view>
		<view class="cu-item" v-else>
			<chat-avatar :message="message"></chat-avatar>
			<view class="main">
				<view class="content shadow" @tap="twoTextClick()">
					<text class="">{{message.data.content}}</text>
				</view>
			</view>
			<view class="date "> {{message.sended_at}} </view>
		</view>
	</view>
</template>

<script>
	import app from '@/mixins/app.js'
	import click from '@/mixins/click.js'
	export default {
		data(){
			return {
				
			}
		},
		mixins:[app,click],
		
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
