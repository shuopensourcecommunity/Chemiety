<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.row.justify-center.layout-padding
    div.row.col-md-10.col-lg-10
      div.col-12.row
        div.xs-gutter.col-lg-4.col-md-4.col-xs-12
          q-card.bg-white
            q-card-media
              q-video(src="statics/video/美丽化学.mp4")
            q-card-title 美丽化学
            q-card-separator
            q-card-actions
              q-btn(flat='', icon="thumb up") 99
              q-btn(flat='', icon="thumb down") 2
              q-btn(flat='', icon="file download") 下载该课件
          q-card.bg-white
            q-card-media
              q-video(src="")
            q-card-title 基因视频
            q-card-separator
            q-card-actions
              q-btn(flat='', icon="thumb up") 99
              q-btn(flat='', icon="thumb down") 2
              q-btn(flat='', icon="file download") 下载该课件
        div.xs-gutter.col-lg-8.col-md-8.col-xs-12
          q-card.col-12.bg-white
              q-card-media
                q-gallery-carousel(:src="slide1")
              q-card-title 主题：化妆品的艺术
                span(slot="subtitle") @2017冬 第四小组 路人甲
                q-rating(slot="right", :max="5", v-model="stars", color="amber", icon="star")
              q-card-main
                p 栈和队列的应用
                p.text-faded 开始用队列完成进入，利用临时栈完成调度
              q-card-separator
              q-card-actions
                q-btn(flat='', icon="thumb up") 99
                q-btn(flat='', icon="thumb down") 2
                q-btn(flat='', icon="file download") 下载该课件
          q-card.col-12.bg-white
            q-card-media
              q-gallery-carousel(:src="slide2")
            q-card-title 主题：化妆品的艺术
              span(slot="subtitle") @2016春 第二小组 路人甲
              q-rating(slot="right", :max="5", v-model="stars", color="amber", icon="star")
            q-card-main
              p 当音乐和运动相结合
              p.text-faded 开始用队列完成进入，利用临时栈完成调
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
