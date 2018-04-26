<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.row.justify-center.layout-padding
    div.row.col-md-9.col-lg-9
      div.col-12
        div.row.xs-gutter
          q-card.bg-white.col-lg-3.col-md-3.col-xs-12
            q-card-media
              q-video(src="statics/video/美丽化学.mp4")
            q-card-title 美丽化学
            q-card-separator
            q-card-actions
              q-btn(flat='', icon="thumb up") 99
              q-btn(flat='', icon="thumb down") 2
              q-btn(flat='', icon="file download") 下载该课件
          q-card.bg-white.col-lg-3.col-md-3.col-xs-12
            q-card-media
              q-video(src="")
            q-card-title 基因视频
            q-card-separator
            q-card-actions
              q-btn(flat='', icon="thumb up") 99
              q-btn(flat='', icon="thumb down") 2
              q-btn(flat='', icon="file download") 下载该课件
          q-card.bg-white.col-lg-3.col-md-3.col-xs-12
            q-card-media
              q-video(src="")
            q-card-title 食品安全的中国梦
            q-card-separator
            q-card-actions
              q-btn(flat='', icon="thumb up") 99
              q-btn(flat='', icon="thumb down") 2
              q-btn(flat='', icon="file download") 下载该课件
          q-card.bg-white.col-lg-3.col-md-3.col-xs-12
            q-card-media
              q-video(src="")
            q-card-title 舌尖上的中国
            q-card-separator
            q-card-actions
              q-btn(flat='', icon="thumb up") 99
              q-btn(flat='', icon="thumb down") 2
              q-btn(flat='', icon="file download") 下载该课件

</template>

<script>
export default {
  data () {
    return {
      video: [
        {
          name: '',
          path: '',
          pro: 0,
          con: 0
        },
        {

        }
      ]
    }
  },
  methods: {
    hh () {
    }
  }
}
</script>

<style lang="stylus">
.layout-padding
  padding-top 50
</style>
