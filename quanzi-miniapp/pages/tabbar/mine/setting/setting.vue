<template>
	<view>
		<view>
			<u-cell-group >
				<u-cell-item title="账号与安全" icon="lock"></u-cell-item>
			</u-cell-group>
		</view>
		<view class="u-m-t-20">
			<u-cell-group>
				<u-cell-item icon="hourglass" title="主题颜色"></u-cell-item>
				<u-cell-item icon="list" title="使用协议" ></u-cell-item>
				<u-cell-item icon="grid" title="多语言" ></u-cell-item>
				<u-cell-item icon="minus" title="清理缓存" ></u-cell-item>
			</u-cell-group>
		</view>
		
		<view class="u-m-t-20">
			<u-cell-group>
				<u-cell-item icon="kefu-ermai" title="关于云大圈子" ></u-cell-item>
				<u-cell-item icon="order" title="帮助与反馈"></u-cell-item>
			</u-cell-group>
		</view>
		
		<view class="u-m-t-20">
			<u-cell-group>
				<u-cell-item title="退出登录" icon="warning" :center="false" :arrow="false" ></u-cell-item>
			</u-cell-group>
		</view>
	</view>
</template>

<script>
	export default {
		
		
		onLoad() {
			
		},
		methods: {
			goToPage(url) {
				if (!url) return;
				uni.navigateTo({
					url
				});
			}
			
		}
	}
</script>

<style lang="scss">
page{
	background-color: #ededed;
}

.camera{
	width: 54px;
	height: 44px;
	
	&:active{
		background-color: #ededed;
	}
}
.user-box{
	background-color: #fff;
}
</style>
