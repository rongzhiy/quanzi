<template>
	<view @tap="twoAvatarClick()" class="cu-avatar radius" :style="[{backgroundImage:'url('+ message.from.avatar +')'}]">
		<text class="avatar-text text-ABC" v-if="!message.from.avatar">{{message.from.name}}</text>
	</view>
</template>

<script>
	import app from '@/mixins/app.js'
	import click from '@/mixins/click.js'
	export default {
		data(){
			return {
				
			}
		},
		mixins:[app,click],
		
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
