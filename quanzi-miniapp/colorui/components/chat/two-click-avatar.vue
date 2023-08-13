<template>
		<view class="cu-info round">{{message.data.content}}</view>
</template>

<script>
	
	export default{
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
