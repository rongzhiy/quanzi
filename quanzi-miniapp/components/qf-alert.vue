<template>
    <view :class="isOpen=='true'?'qf_alert qf_alert_open':'qf_alert'">
		<view class="qf_alert_model">
			<view class="alert_title" :style="contentType=='text'?'display:block;':'display:none;'">{{content}}</view>
			<view class="alert_main" :style="contentType=='input'?'display:block;':'display:none;'">
				<input class="uni-input" v-model="link" focus placeholder="请输入链接地址"  />
			</view>
			<view class="alert_main" :style="contentType=='image'?'display:block;':'display:none;'">
				<!-- <input class="uni-input" v-model="imageLink" focus placeholder="请输入图片地址"  /> -->
				<text class="alert_text">从手机选择图片</text>
				<view class="alert_image" @tap="chooseImage">
					<image class="choose_image" :src="imageLink" :data-src="imageLink"></image>
				</view>
			</view>
			<view class="alert_btns" :style="contentType=='input'||contentType=='image'||btns==2?'display:flex;':'display:none;'">
				<view class="alert_close" @click="closeAlert">取消</view>
				<view class="alert_submit" @click="submitAlert">确定</view>
			</view>
			<view class="alert_btns" :style="contentType=='text' && btns!=2?'display:block;':'display:none;'">
				<view class="alert_submit2" @click="submitAlert">确定</view>
			</view>
		</view>
	</view>
</template>

<script>
    export default {
        name: 'qf-alert',
        props: [
			"isOpen",
			"contentType",
			"content",
			"btns"
        ],
        data() {
            return {
                link:'',
				imageLink:''
            }
        },
        methods: {
            closeAlert() {
            	this.$emit("closeAlert");
            },
            submitAlert() {
            	this.$emit("submitAlert");
            },
			chooseImage: async function() {
				uni.chooseImage({
					sourceType: ['camera', 'album'],
					sizeType: ['compressed', 'original'],
					count: 1,
					success: (res) => {
						//this.imageList = this.imageList.concat(res.tempFilePaths);
						console.log(res.tempFilePaths);
						this.imageLink = res.tempFilePaths[0];
						/* uni.previewImage({
							urls: res.tempFilePaths
						}); */
					}
				})
			}
        }
    }
</script>

<style>
    .qf_alert{
		width: 100%;
		height: 100%;
		position: fixed;
		background: rgba(0,0,0,0.7);
		top: 0;
		left: 0;
		z-index: 99999999;
		display: none;
	}
	.qf_alert_open{
		display: block;
	}
	.qf_alert_model{
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%,-50%);
		background: white;
		border-radius: 5px;
		width: 80%;
		overflow: hidden;
	}
	.alert_title{
		padding: 10px;
		text-align: center;
	}
	.alert_main{
		border-top:solid 1px #eee ;
		border-bottom:solid 1px #eee ;
		padding: 10px 0;
	}
	.alert_btns{
		display: flex;
		justify-content: space-between;
		text-align: center;
	}
	.alert_close{
		width: 50%;
		padding: 10px 0;
	}
	.alert_submit{
		width: calc(50% - 1px);
		border-left: solid 1px #eee;
		padding: 10px 0;
		color: red;
	}
	.alert_submit2{
		width: 100%;
		padding: 10px 0;
		color: red;
	}
	.alert_text{
		color: #999;
		text-align: center;
		width: 100%;
		font-size: 12px;
		display: block;
	}
	.alert_image{
		width: 100px;
		height: 100px;
		border: solid 1px #d9d9d9;
		margin: 0 auto;
		margin-top: 10px;
		position: relative;
	}
	.alert_image:after{
		content: '';
		width: 40px;
		height: 1px;
		background: #D9D9D9;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%,-50%);
	}
	.alert_image:before{
		content: '';
		height: 40px;
		width: 1px;
		background: #D9D9D9;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%,-50%);
	}
	.choose_image{
		width: 100%;
		height: 100%;
	}
</style>
