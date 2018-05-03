<template lang="pug">
  div.row.justify-center
    div.row.col-md-8.col-lg-8.col-sm-12
      h4.caption 课程简介
      div.col-12
        q-card.bg-white
          q-card-title 前言
          q-card-separator
          q-card-main(style="padding-bottom:10px" ) 化学与社会课程是面向高等学校在读本科生和社会公众开放的通识课程。本课程内容围绕9个专题展开，包括“化学发展简史”，“元素的起源、发现与应用”，“传统能源与新能源”等。课程的教学目的是为了增加学习者对化学与社会关系的了解，让学习者认识到化学作为一门中心学科，与能源、材料、医药、环境以及日常生活等都有密切的联系，化学学科的发展与进步对社会发展进程起到了重要的推动作用。这门课程将科学教育与人文教育有机结合起来，将学习者的视野引导到自然科学和社会科学的结合点上，为学习者展现了化学学科生动、有趣、引人入胜的一面。   
          q-card-main(style="padding-bottom:30px" ) 本课程主要是介绍当代化学的进展，客观地认识化学对人类文明和社会进步不可替代的作用。以社会普遍关注的环境、生活、食品、健康、能源和材料等热点问题，深入浅出地介绍其中基本的化学概念和原理，引导学生思考自然科学和社会科学的相互关系，认识到化学对于社会发展的巨大促进作用，使学生加深了解化学与人类社会及各自然科学学科的相关性，理解人类科学发展的基本动力，形成科学探索的创新意识。
      div.col-12.margin-top
        q-card.bg-white
          q-card-title 参考资料
          q-card-separator
          q-list(style="padding-bottom:30px" )
            div(v-for="(doc,index) in docs")
              q-item {{index+1}}.{{doc}}
      div.col-12.margin-top
        q-card.bg-white
          q-card-title 课程详情
          q-card-separator
          q-list(style="padding-bottom:30px" )
            div(v-for="(intro,index) in intros")
              q-item {{index+1}}.{{intro}}
      
</template>

<script>
  import {
    QCardMedia,
    QCardTitle,
    QParallax,
    QList
  } from 'quasar'
  export default {
    name: 'introduction',
    component: {
      QCardMedia,
      QCardTitle,
      QParallax,
      QList
    },
    data () {
      return {
        docs: [
          '《化学与社会》吉林大学主编，高教版，2011',
          '《化学与社会》   唐有祺等 主编，高等教育出版社',
          '《化学与社会发展》张胜义，安徽科学技术出版社，2001'
        ],
        intros: [
          '课程所需PPT和资料在课程资料页面自行下载',
          '补充资料由老师随课程上传',
          '课程随堂要求，作业信息，考试信息等都将由老师发布在课程公告页面，请及时查看'
        ]
      }
    }
  }
</script>

<style lang="stylus">
  .layout-padding
    padding-top 50
  .itemTitle
    font-weight bold
</style>
