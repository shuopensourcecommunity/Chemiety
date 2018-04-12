<template lang="pug">
  // Configure "view" prop for QLayout
  div.layout-padding
    p
      big 评分标准
    div.row
      div.col-12
        q-card
          q-item(label='' style="padding-top:20px")
            q-item-main
              q-tree(
                :model="treeModel",
                contract-html="<i class='material-icons'></i>"
                expand-html="<i class='material-icons'></i>"
             )
</template>

<script>
  import {
    QCard,
    QItem,
    QKnob,
    QIcon,
    QField,
    QTree
  } from 'quasar'
  export default {
    name: 'rating',
    component: {
      QCard,
      QItem,
      QKnob,
      QIcon,
      QField,
      QTree
    },
    data () {
      return {
        treeModel: [
          {
            title: '平时成绩  30%',
            icon: 'record voice over',
            expanded: true,
            children: [
              {
                title: '考勤  20%',
                expanded: true,
                children: [
                  {
                    title: '一学期出勤如果缺席3次及以上则平时分为0',
                    expanded: true,
                    children: []
                  }
                ]
              },
              {
                title: '平时作业  40%',
                expanded: true,
                children: [
                  {
                    title: '每周如果老师有布置作业，认真完成并上交。完成优秀，即有加分',
                    expanded: true,
                    children: []
                  }
                ]
              },
              {
                title: '课堂演讲  40%',
                expanded: true,
                children: [
                  {
                    title: '在学期末参加课堂演讲的同学，有加分',
                    expanded: true,
                    children: []
                  }
                ]
              }
            ]
          },
          {
            title: '考试成绩 70%',
            icon: 'edit',
            expanded: false,
            children: []
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
  .knob-padding
    padding 40
</style>
