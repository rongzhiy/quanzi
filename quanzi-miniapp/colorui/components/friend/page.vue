<template>
	<view class="">

		<view class="" v-if="hasLogin||fake">
			<view  class="cu-list menu" :class="[menuBorder?'sm-border':'',menuCard?'card-menu margin-top':'']">
				<!-- <view class="cu-item" :class="menuArrow?'arrow':''" @tap="showModal" data-target="DialogModal1">
					<view class="content">
						<text class="cuIcon-friendadd text-grey"></text>
						<text class="text-grey">新的朋友</text>
					</view>
				</view> -->
				<view class="cu-item" :class="menuArrow?'arrow':''" @tap="showModal" data-target="DialogModal1">
					<view class="content">
						<text class="cuIcon-group text-grey"></text>
						<text class="text-grey">群聊</text>
					</view>
				</view>
			</view>
			
			<friends></friends>
			
			<view class="cu-modal" :class="modalName=='DialogModal1'?'show':''">
				<view class="cu-dialog">
					<view class="cu-bar bg-white justify-end">
						<view class="content">请选择一个群</view>
						<view class="action" @tap="hideModal">
							<text class="cuIcon-close text-red"></text>
						</view>
					</view>
					<view class="padding" style="overflow-y: auto;max-height: 600rpx;" >
						<groups></groups>
					</view>
			
				</view>
			</view>
		</view>
		<view class="" v-else>
			<view class="flex justify-center align-center" style="height: 80vh;">
					<view class="">
						<view class="text-green" @tap="toEmit('modal_name','my')">
							先去登录吧...
						</view>
					</view>
				
			</view>
		
				
		</view>
		
	</view>
</template>

<script>
	import app from '@/mixins/app.js'
	export default{
		data(){
			return {
				modalName:null,
				menuBorder: false,
				menuArrow: false,
				menuCard: false,
			}
		},
		mixins:[app],
		methods:{
			friend_modal(){
				console.log('触发')
				this.hideModal()
			}
			
		},
		mounted(){
			uni.$on('friend-modal',this.friend_modal)
		},
		destroyed() {
			uni.$off('friend-modal',this.friend_modal)
		},
		beforeDestroy(){
		}

	}
</script>

<style>
</style>
