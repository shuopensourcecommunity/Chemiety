<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.row.justify-center.layout
    div.row.col-md-8.col-lg-8.col-sm-12
      h4.caption 课程大纲
      div.col-12
        q-card
          q-stepper(vertical='', done="", v-model="currentStep", ref="stepper", color='secondary').bg-white
            q-step(:title='chapter.name',
                    :default="(index == 0) ? true : false",
                    v-for="(chapter, index) in chapters",
                    :key="chapter.name",
                    :name='index')
              q-list(no-border="")
                q-item(v-for="(directory, index) in chapter.directories" :key="directory.index")
                  q-item-main
                    q-item-tile {{index + 1}} {{directory}}
              q-stepper-navigation
                q-btn(color="secondary", @click="$refs.stepper.next()") Next
                q-btn(color="secondary", @click="$refs.stepper.previous()", flat="") Back

</template>

<script>
import {
  QStepper,
  QStep,
  QCard,
  QStepperNavigation
} from 'quasar'
export default {
  name: 'outline',
  components: {
    QStepper,
    QStep,
    QStepperNavigation,
    QCard
  },
  data () {
    return {
      currentStep: 1,
      chapters: [
        {
          name: '第一讲  化学概述',
          summary: '第一章主要讲了',
          directories: [
            '化学的发展历史',
            '化学对人类文明和社会进步的作用',
            '化学是物质文明的基础等'
          ]
        },
        {
          name: '第二讲  奇妙的微观世界——原子、分子、晶体',
          summary: '第二章主要讲了',
          directories: [
            '介绍微小的原子、分子如何构建丰富的物质世界'
          ]
        },
        {
          name: '第三讲  建设美好的家园——化学与环境',
          summary: '第二章主要讲了',
          directories: [
            '介绍环境污染与环境监测和治理等'
          ]
        },
        {
          name: '第四讲  人类社会发展的动力--能源',
          summary: '第二章主要讲了',
          directories: [
            '介绍能源与能量转化等'
          ]
        },
        {
          name: '第五讲  化妆品里的化学',
          summary: '第二章主要讲了',
          directories: [
            '表面活性剂简介',
            '了解化妆品',
            '正确看待化妆品'
          ]
        },
        {
          name: '第六讲  舌尖上的化学---食品中化学',
          summary: '第二章主要讲了',
          directories: [
            '介绍合理的营养',
            '食品安全',
            '食品添加剂等'

          ]
        },
        {
          name: '第七讲  工业味精--表面活性剂',
          summary: '第二章主要讲了',
          directories: [
            '表面活性剂简介及其在化学日用品中的应用'
          ]
        },
        {
          name: '第八讲  健康卫士--药物与人类健康',
          summary: '第二章主要讲了',
          directories: [
            '主要介绍合理用药与健康保健常识等'
          ]
        },
        {
          name: '第九讲  文明社会的标志-- 材料',
          summary: '第二章主要讲了',
          directories: [
            '几种影响人类文明发展的重要材料介绍'
          ]
        },
        {
          name: '第十讲  学生宣讲与讨论',
          summary: '第二章主要讲了',
          directories: [
            '学生小组汇报、宣讲，教师点评'
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
</style>
