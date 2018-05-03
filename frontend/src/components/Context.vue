<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.row.justify-center.layout-padding
    div.row.col-md-10.col-lg-10
      div.col-lg-6.col-md-12
        q-card.bg-white.small-margin
          q-card-title 课件下载
            span(slot="subtitle") 老师上课的PPT
          q-card-separator
          q-list
            div(v-for="(slide,index) in slides")
              q-item(:id="slide",link=''  @click='downloadFile(slide.path)')
                q-item-side {{index+1}}
                q-item-main(label-lines="1" :label='slide.title') {{slide.name}}
                q-item-side {{slide.date}}
        q-card.bg-white.small-margin
          q-card-title 文档下载
            span(slot="subtitle") 文档资料下载
          q-card-separator
          q-list
            div(v-for="(doc,index) in documents")
              q-item(:id="doc",link=''  @click='downloadFile(doc.path)')
                q-item-side {{index+1}}
                q-item-main(label-lines="1" :label='doc.title') {{doc.name}}
                q-item-side {{doc.date}}
      div.col-lg-6.col-md-12
        q-card.bg-white.small-margin
          q-card-title 往期优秀作品
            span(slot="subtitle") 学生演讲优秀的作品展示
          q-card-separator
          q-list
            div(v-for="(show,index) in shows")
              q-item(:id="show",link=''  @click='downloadFile(show.path)')
                q-item-side {{index+1}}
                q-item-main(label-lines="1" :label='show.title') {{show.name}}
                q-item-side {{show.date}}
      
        


        //div.xs-gutter.col-lg-4.col-md-4.col-xs-12
          q-card.bg-white
            q-card-media
              q-video(src="statics/video/美丽化学.mp4")
            q-card-title 美丽化学
            q-card-separator
            q-card-actions
              q-btn(flat='', icon="thumb up") 99
              q-btn(flat='', icon="thumb down") 2
              q-btn(flat='', icon="file download") 下载该课件
        //div.xs-gutter.col-lg-8.col-md-8.col-xs-12
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

</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      edus: [],
      shows: [
        {
          url: '',
          name: '',
          date: ''
        }
      ]
    }
  },
  computed: {
    slides () {
      let sls = []
      this.edus.forEach(slide => {
        if (slide.type === 'SLIDE') {
          sls.push(slide)
        }
      })
      return sls
    },
    documents () {
      let docs = []
      this.edus.forEach(doc => {
        if (doc.type === 'DOCUMENT') {
          docs.push(doc)
        }
      })
      return docs
    }
  },
  created () {
    this.getEdus()
    this.getShows()
  },
  methods: {
    getEdus () {
      axios({
        url: 'http://localhost:8080/getAllFiles',
        params: {
          fileType: 'edu'
        },
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
        withCredentials: true
      })
        .then(res => {
          // console.log(1)
          // console.log(res.data.result)
          this.edus = res.data.result
        })
    },
    getShows () {
      axios({
        url: 'http://localhost:8080/getAllFiles',
        params: {
          fileType: 'show'
        },
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
        withCredentials: true
      })
        .then(res => {
          // console.log(1)
          // console.log(res.data.result)
          this.shows = res.data.result
        })
    },
    downloadFile (url) {
      // window.location.href = 'localhost:8080' + url
      window.open('localhost:8080' + url)
    },
    toLink (url) {
      window.location.href = url
    }
  }
}
</script>

<style lang="stylus">
.layout-padding
  padding-top 50
.small-margin
  margin-bottom 20px
</style>
