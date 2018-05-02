<template lang="pug">
div.row.justify-center.layout
  div.row.col-md-10.col-lg-10
    div.col-sm-12.col-md-4.col-lg-4
      //info card
      q-card.bg-white
        q-item
          q-item-side
            big
              q-item-tile(icon="warning", color='warning')
          q-item-main
              q-item-tile.card-title(label='') 公告
          q-item-side
            q-item-tile(right='', icon='more vert')
        q-card-main
          br
          p {{ content }}
        q-card-separator.card-separator
        q-item(link='', to='/introduction')
          q-item-side
            q-item-tile(icon="arrow forward")
          q-item-main
            q-item-tile(label='') 查看所有公告
      // summary card 
      q-card.bg-white
        q-item
          q-item-side
            big
              q-item-tile(icon="school")
          q-item-main
              q-item-tile.card-title(label='') 课程简介
          q-item-side
            q-item-tile(right='', icon='more vert')
        q-item
          q-item-side  
          q-item-main
            q-item-tile(label='') 课程名称
            q-item-tile(sublabel='') 化学与社会
        q-item  
          q-item-side
          q-item-main
            q-item-tile(label='') 上课时间
            q-item-tile(sublabel='') 二 1-2 五 1-2
        q-item  
          q-item-side
          q-item-main
            q-item-tile(label='') 教师名称
            q-item-tile(sublabel='') 陆文聪、李敏杰
        q-card-separator.card-separator
        q-item(link='', to='/introduction')
          q-item-side
            q-item-tile(icon="arrow forward")
          q-item-main
            q-item-tile(label='') 查看课程详情
      
    //middle colomn
    div.col-sm-12.col-md-4.col-lg-4
      // outline card 
      q-card.bg-white
        q-item
          q-item-side
            big
              q-item-tile(icon="subject")
          q-item-main
              q-item-tile.card-title(label='') 课程安排
          q-item-side
            q-item-tile(right='', icon='more vert')
        q-item
          q-item-side  
          q-item-main
            q-item-tile(label='') 本周将讲授
            q-item-tile(sublabel='', color='secondary') 第二讲 元素
        q-item  
          q-item-side
          q-item-main
            q-item-tile(label='') 下一周
            q-item-tile(sublabel='') 放假
        q-card-separator.card-separator
        q-item(link='', to='/introduction')
          q-item-side
            q-item-tile(icon="arrow forward")
          q-item-main
            q-item-tile(label='') 查看完整课程安排
      //context card
      q-card.bg-white
        q-item
          q-item-side
            big
              q-item-tile(icon="view list")
          q-item-main
              q-item-tile.card-title(label='') 课程内容
          q-item-side
            q-item-tile(right='', icon='more vert')
        q-list-header 课件
        q-item(v-for='slide in slides', :key="slides.name")
          q-item-side
            q-item-tile(icon='insert chart')
          q-item-main 
            q-item-tile(label='') {{slide.name}}
            q-item-tile(sublabel='') {{slide.description}}
          q-item-side
            q-btn(icon='file download',flat='' round='' small='' @click='downloadFile(slide.url)')
        q-list-header 其他文档
          p(v-if='docs.length == 0') 暂无文档可以显示
        q-item(v-for='doc in docs' :key='docs.desciption')
          q-item-side
            q-item-tile(icon='insert drive file')
          q-item-main
            q-item-tile(label='') {{doc.name}}
            q-item-tile(sublabel='') {{doc.description}}
          q-item-side
            q-btn(icon='file download',flat='' round='' small='' @click='downloadFile(doc.url)')
        q-card-separator.card-separator
        q-item(link='', to='/introduction')
          q-item-side
            q-item-tile(icon="arrow forward")
          q-item-main
            q-item-tile(label='') 查看所有课程内容
    //right colomn
    div.col-sm-12.col-md-4.col-lg-4
      // gallery card
      q-card.bg-white
        q-item
          q-item-side
            big
              q-item-tile(icon="slideshow")
          q-item-main
              q-item-tile.card-title(label='') 成果展示
          q-item-side
            q-item-tile(right='', icon='more vert')
        q-card-media
          q-gallery-carousel(:src="presentations.src")
        q-card-title {{presentations.topic}}
          span(slot="subtitle") {{presentations.time}} {{presentations.authorName}}
        q-card-main
          p {{presentations.title}}
          p.text-faded 
        q-card-separator.card-separatorr
        q-item(link='', to='/introduction')
          q-item-side
            q-item-tile(icon="arrow forward")
          q-item-main
            q-item-tile(label='') 查看更多学生成果展示
      
      



</template>

<script>
import axios from 'axios'
export default {
  name: 'summaryAll',
  data () {
    return {
      content: '',
      presentations: {
        src: [
          'statics/Run+Music/Slide1.JPG',
          'statics/Run+Music/Slide2.JPG',
          'statics/Run+Music/Slide3.JPG',
          'statics/Run+Music/Slide4.JPG',
          'statics/Run+Music/Slide5.JPG',
          'statics/Run+Music/Slide6.JPG',
          'statics/Run+Music/Slide7.JPG',
          'statics/Run+Music/Slide8.JPG'
        ],
        topic: 'Running + Music = ?',
        time: '2016年春季',
        authorName: '路人甲',
        title: 'asdaa',
        description: '开始用队列完成进入，利用临时栈完成调读',
        stars: '',
        url: ''
      },
      slides: [
        {
          type: 'ppt',
          name: '第二讲',
          description: '第二讲课件',
          url: '~/assets/a.pptx'
        },
        {
          type: 'pdf',
          name: 'sda',
          description: 'sdadasdas',
          url: 'sdad'
        }
      ],
      docs: []
    }
  },
  created () {
    this.getFirstInfo()
  },
  methods: {
    getFirstInfo () {
      axios({
        url: 'http://localhost:8080/getFirstInfo',
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
        withCredentials: true
      })
        .then(res => {
          console.log(1)
          console.log(res.data.result)
          this.content = res.data.result.content
        })
    },
    downloadFile (url) {
      window.location.href = url
    }
  }
}
</script>

<style lang="stylus">
  .card-separator
    margin-bottom 0
  .card-title
    font-size 18px
  .layout
    padding 10px 0 0 0
    background-color rgb(244,244,244)
</style>
