<template>
	<view class="" @click="downloadFile()">
		
		<view class="cu-item self"  v-if="message.from.id==user.id">
			<view class="padding-right">
				<view class="cu-avatar xl">
					<view class="cuIcon-file" >
					</view>
				</view>
				<view class="shadow" style="">
					<text class="text-blue"> {{message.data.extra.name}} </text>
				</view>
			</view>
			<chat-avatar :message="message"></chat-avatar>
			<view class="date">{{message.sended_at}}</view>
		</view>
		<view class="cu-item" v-else>
			<chat-avatar :message="message"></chat-avatar>
			<view class="padding-left">
				<view class="cu-avatar xl">
					<view class="cuIcon-file" >
					</view>
				</view>
				<view class="shadow">
					<text class="text-blue">{{message.data.extra.name}}</text>
				</view>
			</view>
			<view class="date "> {{message.sended_at}} </view>
		</view>
	</view>
</template>

<script>
	import app from '@/mixins/app.js'
	export default {
		data(){
			return {
				
			}
		},
		mixins:[app],
		methods:{
			downloadFile(){
				//#ifdef H5
					// var downloadFileUrl = this.message.data.content
					// var elemIF = document.createElement("iframe");
					// elemIF.src = downloadFileUrl;
					// // elemIF.style.display = "none";
					// document.body.appendChild(elemIF);
					// console.log(1111)
					const a = document.createElement('a'); // 创建a标签
					a.setAttribute('download',this.message.data.extra.name)
					// a.setAttribute('filename',this.message.data.extra.name)
					
					// a.setAttribute('target', '_blank');// download属性
					a.setAttribute('href', this.message.data.content);// href链接
					a.click();// 自执行点击事件

				//#endif
				//#ifndef H5
				uni.downloadFile({
				    url: this.message.data.content, //仅为示例，并非真实的资源
				    success: (res) => {
				        if (res.statusCode === 200) {
							
				            console.log('下载成功',res);
							uni.saveFile({
							      tempFilePath: res.tempFilePath,
							      success: function (res1) {
							        var savedFilePath = res1.savedFilePath;
									console.log('saveFile',res1)
									uni.openDocument({
										filePath: savedFilePath,
										success: function(res) {
											console.log('打开文档成功');
										}
									});
							      }
							    });
				        }
				    }
				});
				//#endif
				

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
