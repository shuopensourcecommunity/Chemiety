<template lang="pug">
  q-layout.layout-padding
    div(v-for="(introList,index) in introLists")
      q-card(id="introList")
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
              '这是一门有趣的化学课，它既讲述化学知识也包括人文内涵。在课堂上我们将一起纵观化学史，欣赏元素在化学家手里被赋予鲜活的生命，一起以化学的观点去观察生活，分析我们所遇到的各种问题。别以为化学是一门枯燥乏味的学科，除了方程式和基础理论之外，它既生动又精彩，让我们一起来学化学，用化学！'
            ]
          },
          {
            no: 2,
            iconName: 'markunread mailbox',
            title: '参考资料',
            contents: [
              '《化学与社会》，唐有祺 王夔主编，高等教育出版社',
              '其余各章节内容参考书，参见学习园地'
            ]
          },
          {
            no: 3,
            iconName: 'extension',
            title: '课程概述',
            contents: ['2018年春季开课说明:',
              '1. 课程所需PPT在资料下载页面自行下载',
              '2. 补充资料由老师随课程上传',
              '化学与社会课程是面向高等学校在读本科生和社会公众开放的通识课程。本课程内容围绕9个专题展开，包括“化学发展简史”，“元素的起源、发现与应用”，“传统能源与新能源”等。课程的教学目的是为了增加学习者对化学与社会关系的了解，让学习者认识到化学作为一门中心学科，与能源、材料、医药、环境以及日常生活等都有密切的联系，化学学科的发展与进步对社会发展进程起到了重要的推动作用。这门课程将科学教育与人文教育有机结合起来，将学习者的视野引导到自然科学和社会科学的结合点上，为学习者展现了化学学科生动、有趣、引人入胜的一面。'
            ]
          },
          {
            no: 4,
            iconName: 'school',
            title: '上课要求',
            contents: [
              '地点：Dj104',
              '时间： 二五 1-2'
            ]
          }
        ]
      }
    }
  }
</script>

<style lang="stylus">
  .layout-padding
    padding 50
  .itemTitle
    font-weight bold
</style>
