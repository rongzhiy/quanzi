<template>
	<view class="cu-list menu-avatar" :class="[isCard?'card-menu margin-top-xl margin-bottom-xl shadow-lg':'']">
		<view class="cu-item" v-for="item,index in user.groups" :key="index">
			<view class="cu-avatar round lg" :style="[{'background-image':'url('+item.avatar+')'}]"></view>
			<view class="content">
				<view class="text-cut text-grey">{{item.name}}</view>
				<view class="text-gray text-sm flex">
					<view class="text-cut">
						<!-- <text class="cuIcon-infofill text-red  margin-right-xs"></text> -->
						当前群有{{item.users.length||0}}人
					</view> </view>
			</view>
			<view class="btn-group justify-around">
				<button class="cu-btn bg-green shadow-blur round" @tap="toChange({to_id:item.id,type:'group'})">进入</button>
			</view>
		</view>
	</view>
		
</template>

<script>
	import app from '@/mixins/app.js'
	import im from '@/mixins/im.js'
	export default {
		data(){
			return {
				
			}
		},
		mixins:[app,im],
		props: {
			isCard:{
				type:[Boolean],
				default:false
			},
			change_type: {
				type: [Number],
				default: 1
			},
			
		},
		methods:{
			toChange(item){
				if(this.change_type==1){//页面群
					this.toEmit('friend-modal',{})
					this.toChat(item);
				}else if(this.change_type==2){//聊天页面切换群
					uni.$emit('message-change',item)
				}
			},
		}
	}
</script>
	
<style>
</style>
