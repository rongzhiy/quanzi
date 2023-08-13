<template>
	<view class=""  style="height:calc(100vh - 100px);overflow-y: auto;">
		
		<view  class="cu-list menu-avatar " :class="[isCard?'card-menu margin-top-xl margin-bottom-xl shadow-lg':'']">
			<!-- @touchstart="ListTouchStart" @touchmove="ListTouchMove" @touchend="ListTouchEnd" :data-target="'move-box-' + index" -->
			<template v-for="(item,index) in messages">
				<view   class="cu-item" :class="modalName=='move-box-'+ index?'move-cur':''"  :key="index"
				 @touchstart="ListTouchStart" @touchmove="ListTouchMove" @touchend="ListTouchEnd" :data-target="'move-box-' + index"
				 >
					<view @tap="toChange({to_id:item.group_id,type:item.type})" class="cu-avatar radius lg" :style="[{backgroundImage:'url('+ getLatestMessageAvatar(item) +')'}]">
						<view class="cu-tag badge" v-if="item.unread_count!=0">
							<block>{{item.unread_count>99?'99+':item.unread_count}}</block>
						</view>
						<view v-if="item.type=='group'" class="flex justify-around flex-wrap" style="padding-top: 2px;width: 100%;height: 100%;">
							<view  class="bg-img" :class="true?'':'only-img'" style="width: 30%;height: 30%;" :style="[{backgroundImage:'url('+ item1.avatar +')'}]"
							 
							 v-for="(item1,index1) in get_group_users(item.group_id)" :key="index1" v-if="index1<9">
							</view>
						</view>
					</view>
					
					<view class="content" @tap="toChange({to_id:item.group_id,type:item.type})">
						<view class="text-grey" >
							<template v-if="item.type=='friend'">
								{{user.id==item.message.from.id?item.message.to.name:item.message.from.name}}
							</template>
							<template v-else>
								{{item.message.to.name}}
							</template>
						</view>
						<view class="text-gray text-sm text-cut">
							{{item.message.data.msg||item.message.data.content}}
						</view>
					</view>
					<view class="action" @tap="toChange({to_id:item.group_id,type:item.type})">
						<view class="text-grey text-xs">{{item.sended_at}}</view>
						<!-- <view class="cu-tag round bg-grey sm">5</view> -->
					</view>
					<view class="move">
						<view class="bg-grey">取消</view>
						<view class="bg-red" @tap="removeMessagesByIndex" :data-target-index="index">删除</view>
					</view>
				</view>
			</template>
			<template v-if="messages.length==0">
				<view class="flex justify-center align-center" style="height: 80vh;">
						<view class="">
							<view class="text-green" @tap="toEmit('modal_name','friend')">
								聊个天可好？
							</view>
						</view>
					
				</view>
			
				
			</template>
		</view>
	</view>
</template>

<script>
	import app from '@/mixins/app'
	import im from '@/mixins/im.js'
	export default {
		name:'messages',
		data() {
			return {
				listTouchStart: 0,
				listTouchDirection: null,
			};
		},
		props:{
			isCard:{
				type:[Boolean],
				default:false
			},
			change_type:{
				type:[Number],
				default:1
			}
		},
		mixins:[app,im],
		methods: {
			async removeMessagesByIndex(e){
				var index = e.currentTarget.dataset.targetIndex
				this.$store.dispatch('im/removeMessagesByIndex',index)
			},
			toChange(item){
				if(this.change_type==1){//首页信息
				
					this.toChat(item);
				}else if(this.change_type==2){//聊天页面切换信息
					uni.$emit('message-change',item)
				}
			},
			// ListTouch触摸开始
			ListTouchStart(e) {
				this.listTouchStart = e.touches[0].pageX
			},
			
			// ListTouch计算方向
			ListTouchMove(e) {
				this.listTouchDirection = e.touches[0].pageX - this.listTouchStart > 0 ? 'right' : 'left'
			},
			
			// ListTouch计算滚动
			ListTouchEnd(e) {
				if (this.listTouchDirection == 'left') {
					console.log('3232')
					this.modalName = e.currentTarget.dataset.target
				} else {
					console.log('3232来来快来看看看')
					this.modalName = null
				}
				this.listTouchDirection = null
			},

		},
	}
</script>

<style>
	
</style>
