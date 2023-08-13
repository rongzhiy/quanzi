<template>
	<view>
		<view>
			<view class="toolbar">
				<view class="iconfont icon-bold" @click="toolBarClick('bold')"></view>
				<view class="iconfont icon-italic" @click="toolBarClick('italic')"></view>
				<view class="iconfont icon-xiahuaxian1" @click="toolBarClick('header')"></view>
				<view class="iconfont icon-underline" @click="toolBarClick('underline')"></view>
				<view class="iconfont icon-strike" @click="toolBarClick('strike')"></view>
				<view class="iconfont icon-alignleft" @click="toolBarClick('alignleft')"></view>
				<view class="iconfont icon-aligncenter" @click="toolBarClick('aligncenter')"></view>
				<view class="iconfont icon-alignright" @click="toolBarClick('alignright')"></view>
				<view class="iconfont icon-link" @click="toolBarClick('link')"></view>
				<view class="iconfont icon-image" @click="toolBarClick('imgage')"></view>
				<view class="iconfont icon-qingkong" @click="toolBarClick('clear')"></view>
				<view class="iconfont editor_submit" @click="toolBarClick('submit')">保存</view>
			</view>
			<view class="my_textarea" contentEditable="true" v-model="myTextarea">
				
			</view>
			<qfAlert @closeAlert='closeAlert()' contentType='input' :isOpen='isOpen' ref='qfAlert_ipt' @submitAlert='submitLink'></qfAlert>
			<qfAlert @closeAlert='closeImageAlert()' contentType='image' :isOpen='isOpen4' ref='qfAlert' @submitAlert='submitImageLink'></qfAlert>
			<qfAlert contentType='text' content='请先选中要添加链接的文本!' :isOpen='isOpen2' @submitAlert='closeTip()'></qfAlert>
			<qfAlert @closeAlert='closeClean()' contentType='text' content='确定清空吗？' :isOpen='isOpen3' @submitAlert='isClean()'></qfAlert>
		</view>
	</view>
</template>

<script>
	import uParse from '../../../components/uParse/src/wxParse.vue'
	import qfAlert from '../../../components/qf-alert.vue'
	export default {
		name: "qf-editor",
		components: {
			uParse, 
			qfAlert
		},
		data: function () {
			return {
				myTextarea:'',
				link:'',
				imageLink:'',
				isOpen:false,
				isOpen2:false,
				isOpen3:false,
				isOpen4:false,
				endOffset:0,
				startOffset:0,
				endContainer:'',
				startContainer:''
			}
		},
		props: {
			
		},
		methods: {
			toolBarClick(type) {
				if (type == 'bold') {
					var bold = document.execCommand("bold", false, null)
				} else if (type == "italic") {
					document.execCommand("italic", false, null)
				} else if (type == "header") {
					uni.showActionSheet({
						itemList: ["标题1", "标题2", "标题3", "标题4", "标题5", "标题6"],
						success: res => {
							switch (res.tapIndex) {
								case 0:
									document.execCommand("fontsize", false, 1);
									return;
								case 1:
									document.execCommand("fontsize", false, 2);
									return;
								case 2:
									document.execCommand("fontsize", false, 3);
									return;
								case 3:
									document.execCommand("fontsize", false, 4);
									return;
								case 4:
									document.execCommand("fontsize", false, 5);
									return;
								case 5:
									document.execCommand("fontsize", false, 6);
									return;
							}
						}
					})
				} else if (type == "underline") {
					alert("ok");
					document.execCommand("underline", false, null);
				} else if (type == "strike") {
					document.execCommand("strikeThrough", false, null)
				} else if (type == "alignleft") {
					document.execCommand("justifyLeft", false, null)
				} else if (type == "aligncenter") {
					document.execCommand("justifyCenter", false, null)
				} else if (type == "alignright") {
					document.execCommand("justifyRight", false, null)
				} else if (type == "link") {
					let selection  =  document.getSelection();
					console.log(selection.getRangeAt(0));
					if(selection.type == "Range"){
						var range = selection.getRangeAt(0);
						this.endOffset = range.endOffset;
						this.startOffset = range.startOffset;
						this.endContainer = range.endContainer;
						this.startContainer = range.startContainer;
						this.isOpen = 'true';
					} else {
						this.isOpen2 = 'true';
					}
				} else if (type == "imgage") {
					//document.execCommand("insertimage", false, "http://dinxin.suchenqiang.cn/public/upload/image/20190402/59310adb40594ae1fbdb5dd1fd009a15.jpg")
					let selection  =  document.getSelection();
					console.log(selection)
					if(selection.type != "None"){
						this.isOpen4 = 'true';
					}
				} else if (type == "clear") {
					/* uni.showModal({
						title: "提示",
						content: "确定清空?",
						success: res => {
							if (res.confirm) {
								this.myTextarea.target.innerHTML = "";
							}
						}
					}) */
					this.isOpen3 = 'true';
				} else if (type == "submit") {
					if(this.myTextarea!=''){
						alert(this.myTextarea.target.innerHTML);
						console.log(this.myTextarea.target.innerHTML);
					}
				} 
			},
			closeAlert() {
				this.isOpen = false;
			},
			closeImageAlert() {
				this.isOpen4 = false;
				this.$refs.qfAlert.imageLink = '';
			},
			closeTip() {
				this.isOpen2 = false;
			},
			closeClean() {
				this.isOpen3 = false;
			},
			submitLink(data) {
				this.link = this.$refs.qfAlert_ipt.link;
				this.isOpen = false;
				let selection  =  window.getSelection();
				let range  =  document.createRange();
				selection.removeAllRanges();
				range.setStart(this.startContainer,  this.startOffset);
				range.setEnd(this.endContainer,  this.endOffset);
				selection.addRange(range);
				document.execCommand("createlink", false, this.link);
			},
			submitImageLink(data) {
				this.isOpen4 = false;
				this.imageLink = this.$refs.qfAlert.imageLink;
				document.execCommand('insertHTML', false, "<image style='width:80%' src='"+this.imageLink+"'></image>");
				this.$refs.qfAlert.imageLink = '';
			},
			isClean() {
				this.closeClean();
				if(this.myTextarea!=''){
					this.myTextarea.target.innerHTML = "";
				}
			}
		}
	}
</script>

<style>
	
	@import '../../../static/LevineHua-editor/markdown.css';
	@import url("../../../components/uParse/src/wxParse.css");
	
	.toolbar {
		width: 100%;
		border: none;
		box-shadow: 0 0upx 4upx rgba(0, 0, 0, 0.157), 0 0upx 4upx rgba(0, 0, 0, 0.227);
	}

	.toolbar .iconfont {
		display: inline-block;
		cursor: pointer;
		height: 61.6upx;
		width: 61.6upx;
		margin: 13upx 0 11upx 0upx;
		font-size: 33upx;
		padding: 10upx 13upx 11upx 8upx;
		color: #757575;
		border-radius: 11upx;
		text-align: center;
		background: none;
		border: none;
		outline: none;
		line-height: 2.2;
		vertical-align: middle;
	}
	.my_textarea{
		width: 100%;
		height: 200px;
		box-sizing: border-box;
		outline: none;
		padding: 10px;
	}
	.my_textarea .img{
		width: 80%!important;
	}
	.toolbar .editor_submit{
		font-size: 12px;
		line-height: 35px;
	}
</style>
