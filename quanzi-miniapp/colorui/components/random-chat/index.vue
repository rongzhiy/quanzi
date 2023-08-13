<template>
	<view class="">
		<view class="cu-list menu-avatar" :class="[isCard?'card-menu margin-top-xl margin-bottom-xl shadow-lg':'']">
			<view class="cu-item" v-for="item,index in random_chat.lists" :key="index">
				<view class="cu-avatar round lg" :style="[{'background-image':'url('+item.avatar+')'}]"></view>
				<view class="content">
					<view class="text-cut text-grey">{{item.name}}</view>
					<view class="text-gray text-sm flex">
						<view class="text-cut">
							<!-- <text class="cuIcon-infofill text-red  margin-right-xs"></text> -->
							当前兴趣小组有{{item.users_count||0}}人
						</view> 
					</view>
					<view class="text-gray text-sm flex">
						<view class="text-cut" v-if="(item.all_count-item.users_count)>0">
								还需{{item.all_count-item.users_count||0}}人
						</view>	
					</view>
					
					
				
				</view>
				<view class="btn-group justify-around">
					<button class="cu-btn bg-green shadow-blur round" @tap="toChange(item)">{{getStatus(item)}}</button>
				</view>
			</view>
			
		</view>
		<view class="cu-modal padding" :class="modalName=='DialogModal1'?'show':''">
			<view class="cu-dialog">
				<view class="cu-bar bg-white justify-end">
					<view class="content">{{random_chat_item.name}}</view>
					<view class="action" @tap="hideModal">
						<text class="cuIcon-close text-red"></text>
					</view>
				</view>
				<view class="padding" style="overflow-y: auto;height: 300rpx;" >
					<view class="text-cut text-black">
						<!-- <text class="cuIcon-infofill text-red  margin-right-xs"></text> -->
						当前兴趣小组已有
						<view class="cu-tag">
							{{random_chat_item.users_count||0}}
						</view>
						人
					</view>
					<view class="text-cut text-black" v-if="(random_chat_item.all_count-random_chat_item.users_count)>0">
							还需
							<view class="cu-tag">
								{{random_chat_item.all_count-random_chat_item.users_count||0}}
							</view>人
					</view>
				</view>		
			</view>
		</view>
	</view>
</template>

<script>
	import random_chat from '@/mixins/random_chat.js'
	import app from '@/mixins/app.js'
	export default {
		data(){
			return {
				random_chat_item: {}
			}
		},
		mixins:[app,random_chat],
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
			getStatus(item){
				var length = item.users.length
				var status = ''
				for(let i=0;i<length;i++){
					if(item.users[i].id==this.user.id){
						status = item.users[i].status
						break;
					}
				}
				return status || item.status
				
			},
			toChange(item){
				var status = this.getStatus(item);
				switch(status){
					case 'joining':
						this.random_chat_join({random_chat_id:item.id}).then(res=>{
							if(res.data.code==0){
								// this.random_chat_item = item
								// this.modalName='DialogModal1'
							}
						})
						break;
					case 'waiting':
						uni.showToast({
							icon:'none',
							title:'请等待凑够人数'
						})
						break;
					case 'chating':
						uni.$emit('message-change',{
							to_id:item.child_group_id,
							type:'group',
						})
						break;
				}

			},
		}
	}
</script>
	
<style>
</style>
