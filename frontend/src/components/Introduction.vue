<template lang="pug">
  div.row.justify-center
    div.row.col-md-10.col-lg-10
      div(v-for="(introList,index) in introLists").col-12.margin-top
        q-card(id="introList").bg-white
          q-item(label='' style="padding-top:20px")
            q-item-side
              q-icon(v-bind:name='introList.iconName' color="red-13")
            q-item-main
              q-item-title(label='').itemTitle {{introList.title}}
          q-card-main(style="padding-bottom:30px" )
            q-list(no-border="")
              q-item(v-for="(content, index) in introList.contents", :key="contents")
                q-item-main
                  q-item-title {{content}}
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
        introLists: [
          {
            no: 1,
            iconName: 'bookmark',
            title: '前言',
            contents: [
              '本课程主要是介绍当代化学的进展，客观地认识化学对人类文明和社会进步不可替代的作用。以社会普遍关注的环境、生活、食品、健康、能源和材料等热点问题，深入浅出地介绍其中基本的化学概念和原理，引导学生思考自然科学和社会科学的相互关系，认识到化学对于社会发展的巨大促进作用，使学生加深了解化学与人类社会及各自然科学学科的相关性，理解人类科学发展的基本动力，形成科学探索的创新意识。'
            ]
          },
          {
            no: 2,
            iconName: 'markunread mailbox',
            title: '参考资料',
            contents: [
              '《化学与社会》吉林大学主编，高教版，2011',
              '《化学与社会》   唐有祺等 主编    高等教育出版社',
              '《化学与社会发展》张胜义，安徽科学技术出版社，2001',
              '其余各章节内容参考书，参见学习园地'
            ]
          },
          {
            no: 3,
            iconName: 'extension',
            title: '课程概述',
            contents: ['开课说明:',
              '1. 课程所需PPT在资料下载页面自行下载',
              '2. 补充资料由老师随课程上传',
              '化学与社会课程是面向高等学校在读本科生和社会公众开放的通识课程。本课程内容围绕9个专题展开，包括“化学发展简史”，“元素的起源、发现与应用”，“传统能源与新能源”等。课程的教学目的是为了增加学习者对化学与社会关系的了解，让学习者认识到化学作为一门中心学科，与能源、材料、医药、环境以及日常生活等都有密切的联系，化学学科的发展与进步对社会发展进程起到了重要的推动作用。这门课程将科学教育与人文教育有机结合起来，将学习者的视野引导到自然科学和社会科学的结合点上，为学习者展现了化学学科生动、有趣、引人入胜的一面。'
            ]
          }
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
