<template>
	<view class="page" ref="page" :style="[{'height':height}]" :class="[_isWidescreen?'right-window-chat-width':'']" style="overflow: auto;" >
		<scroll-view id="abc" @touchmove="abc" class="cu-chat" :class="[_isWidescreen?'right-window-chat-width':'']" scroll-y scroll-with-animation :scroll-top="verticalNavTop" :style="[{'height':height}]"   :scroll-into-view="'main-'+mainCur" @scroll="VerticalMain">
			
			<view id="box">
				
				<view class="abc cu-chat"  v-for="(message,index) in current_messages" :key="index" :id="'main-'+index">
					<!-- {from:{id:1,avatar:'https://ossweb-img.qq.com/images/lol/web201310/skin/big107000.jpg'},data:{content:'sadasd'}} -->
					
					<template v-if="message.message_type=='text'">
						<chat-text :message="message" :key="index"></chat-text>
					</template>
					<template v-else-if="message.message_type=='image'">
						<chat-image :message="message" :key="index" :current_images="current_images"></chat-image>
					</template>
					<template  v-else-if="message.message_type=='audio'">
						<chat-audio :message="message" :key="index"></chat-audio>
					</template>
					<template  v-else-if="message.message_type=='file'">
						<chat-file :message="message" :key="index"></chat-file>
					</template>
					<template  v-else-if="message.message_type=='video'">
						<chat-video :message="message" :key="index"></chat-video>
					</template>
					<template  v-else-if="message.message_type=='two-click-avatar'">
						<chat-two-click-avatar :message="message" :key="index"></chat-two-click-avatar>
					</template>
					<template  v-else-if="message.message_type=='two-click-text'">
						<chat-two-click-text :message="message" :key="index"></chat-two-click-text>
					</template>
					
				</view>
				<!-- <view class="cu-info round">对方撤回一条消息!</view> -->
				<view class="" style="height: 300rpx;">
					
				</view>
			
			</view>
				
			
		</scroll-view>
		<view style="display: none;">
			{{current_messages_length}}
		</view>
	</view>
</template>

<script>
	import app from '@/mixins/app.js'
	import im from '@/mixins/im.js'
	export default {
		name:'list',
		data(){
			return {
				mainCur: 0,
				verticalNavTop: 0,	
				list:[],
				timer:null
			}
		},
		mixins:[app],
		mounted(){

		},
		destroyed(){
			clearInterval(this.timer)
		},
		methods:{
			abc(e){
				return false
			},
			VerticalMain(e) {
				// #ifdef MP-ALIPAY
				   return false  //支付宝小程序暂时不支持双向联动 
				// #endif
				
				
			}
		
		},
		props: {
			current_messages:{
				type:[Array],
				default:()=>{
					return []
				}
			},
			is_pop_up:{
				type:[Boolean],
				default:false
			},
			is_keyboard:{
				type:[Boolean],
				default:false
			}	
			
		},
		computed:{
			height(){
				
				return '100vh'
				return 'calc(100vh - 200rpx)'
				// return this.PhoneHeight+'px'
				console.log(this.PhoneHeight,'PhoneHeight')
				if(this.is_keyboard){//暂无用
					this.verticalNavTop-=1
					// return (this.PhoneHeight-720)+'rpx'
					return 'calc(100vh - 720rpx)'
				}else if (this.is_pop_up){
					
					this.verticalNavTop-=1
					// return (this.PhoneHeight*2-720)+'rpx'
					return 'calc(100vh - 720rpx)'
				}
				// return (this.PhoneHeight*2-200)+'rpx'
				return 'calc(100vh - 200rpx)'
			},
			current_messages_length(){
				// this.list = this.current_messages
				this.$nextTick(function(){
					if(this.current_messages.length>2&&(!this.$store.state.im.pull_refresh)){
						const query = uni.createSelectorQuery().in(this);
						query.select("#box").boundingClientRect(data => {
								// this.list[i].top = tabHeight;
							if(data.height>500){
								this.verticalNavTop = data.height
							}
						
					
						}).exec();
						
					}
					
				})
				return this.current_messages.length
					
			},
	
		
			current_images(){
				
				var current_messages = this.current_messages
				var a = []
				current_messages.map(current_message=>{
					if(current_message.message_type=='image'){
						a.push(current_message.data.content)
					}
					return current_message
				})
				return a
				
			}
		}
	}
</script>
	
<style>
	.page{
		/* height:calc(100vh - 100px);s */
		overflow-y: auto;
		/* padding-bottom: 100rpx; */
	}
</style>
