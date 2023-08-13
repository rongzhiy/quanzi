<template>
	<view>
		<robin-editor class="editor" 
		    @cancel="hideEditor" 
		    @save="saveEditor" 
		    v-model="html"
		    :imageUploader="uploadImg" 
		    :muiltImage="true">
		</robin-editor>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
