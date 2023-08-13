<template>
	<view class="">
		<view class="cu-bar bg-white margin-top">
			<view class="action">
				聊天信息（{{grouping_user_ids.length}})
			</view>
			<view class="action">
				
			</view>
		</view>
		<view class="grid col-4 grid-square flex-sub padding">
			<view class="" v-for="(item,index) in grouping_user_ids" :key="index" :data-url="getUserAvatarByUserId(item)">
			 <image :src="getUserAvatarByUserId(item)" mode="aspectFill"></image>
				<view class="cu-tag bg-red" @tap.stop="DelImg" :data-index="index">
					<text class='cuIcon-close'></text>
				</view>
			</view>
			<view class="solids" @tap="ChooseImage">
				<text class='cuIcon-add'></text>
			</view>
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
				imgList: [],
			}
		},
		mixins:[app,im],
		props:{

		},
		methods:{
			ChooseImage() {
				uni.$emit('display-drawer-window',{})//打开add-user-to-group
			},
			getUserAvatarByUserId(user_id){
				
				var length = this.user_friends.length
				for(let i=0;i<length;i++){
					if(this.user_friends[i].id==user_id){
						return this.user_friends[i].avatar
					}
				}
			},

			DelImg(e) {
				// uni.showToast({
				// 	icon:'none',
				// 	title:'暂不支持',
				// })
				// return 
				var grouping_user_ids = JSON.parse(JSON.stringify(this.im.grouping_user_ids))
				grouping_user_ids.splice(e.currentTarget.dataset.index, 1);
				this.$store.dispatch('im/grouping_user_ids',grouping_user_ids)
			},
		},
		computed:{
			grouping_user_ids(){
				console.log(this.im.grouping_user_ids,'fsfdsfsdf')
				return this.im.grouping_user_ids
			}
		}
	}
</script>

<style>
</style>
