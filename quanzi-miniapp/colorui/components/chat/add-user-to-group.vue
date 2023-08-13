<template>
	
		<checkbox-group @change="CheckboxChange" >
			<view class="cu-list menu-avatar" :class="[isCard?'card-menu margin-top-xl margin-bottom-xl shadow-lg':'']"   >
				<view class="cu-item" v-for="(divide_group_user,index) in checkbox" :key="index" v-if="!$tool.in_array(divide_group_user.id,im.grouping_user_ids)">
					<view class="action cu-form-group" >
						<checkbox class='round' :class="divide_group_user.checked?'checked':''" :checked="divide_group_user.checked?true:false" :value="divide_group_user.value"></checkbox>
					</view>
					<view class="cu-avatar radius" :style="[{'background-image':'url('+divide_group_user.avatar+')'}]">
						<view class="cu-tag badge" v-if="divide_group_user.id==user.id">我</view>
					</view>
					<view class="content">
						<view class="text-grey">{{divide_group_user.name}}</view>
					</view>
				
					
				</view>
			</view>
			<view style="display: none;">
				{{test.id}}
			</view>
		</checkbox-group>
		
</template>

<script>
	import app from '@/mixins/app.js'
	import im from '@/mixins/im.js'
	export default {
		data(){
			
		
			
			return {
				// checkbox: [],
				checkbox: [],
			}
		},
		props:{
		   isCard:{
		   	type:[Boolean],
		   	default:true
		   },
		   change_type: {
		   	type: [Number],
		   	default: 1
		   },	
		},
		mixins:[app,im],
		methods:{
			async CheckboxChange(e) {
				var items = this.checkbox,
					values = e.detail.value;
				for (var i = 0, lenI = items.length; i < lenI; ++i) {
					items[i].checked = false;
					for (var j = 0, lenJ = values.length; j < lenJ; ++j) {
						if (items[i].value == values[j]) {
							items[i].checked = true;
							break
						}
					}
				}
				
				this.checkbox = items
				
				var group_checked_user_ids = []
				
				this.checkbox.map(re=>{
					if(re.checked){
						group_checked_user_ids.push(re.id)
					}
				})
				console.log(group_checked_user_ids,'group_checked_user_ids11111')
				if(group_checked_user_ids.length>0){
					await this.$store.dispatch('im/group_checked_user_ids',group_checked_user_ids)
				}else{
					await this.$store.dispatch('im/group_checked_user_ids',[])
				}
				
				
			},
		},
		computed:{
			test(){
				var user_friends = JSON.parse(JSON.stringify(this.user_friends)) 
				var checkbox = user_friends.map(checkbo=>{
					checkbo.checked=false
					checkbo.value= checkbo.id+''
					return checkbo;
				})
				this.checkbox = checkbox
				return user_friends.length>0?user_friends[0]:{}
			}
		}
	}
</script>

<style>
</style>
