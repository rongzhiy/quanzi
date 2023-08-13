<template>
	<view class="page cu-list menu-avatar" :class="[isCard?'card-menu margin-top-xl margin-bottom-xl shadow-lg':'']">
		
			
			<view class="cu-item" v-for="(divide_group_user,index) in user_friends" :key="index" @tap="toChange({id:divide_group_user.id})">
				<view class="cu-avatar radius" :style="[{'background-image':'url('+divide_group_user.avatar+')'}]">
					<view class="cu-tag badge" v-if="divide_group_user.id==user.id">我</view>
				</view>
				<view class="content">
					<view class="text-grey">{{divide_group_user.name}}</view>
					
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
				if(this.change_type==1){//页面好友
					
					this.toChatFriend(item);
					
				}else if(this.change_type==2){//聊天页面切换好友
					var friend_group = this.geCurrenttFriendGroupByToUser(item)
					this.toEmit('message-change',{to_id:friend_group.id,type:'friend'})
				}
			},
		}
	}
</script>
	
<style>
	.page{
		padding-bottom: 85px;
	}
</style>
