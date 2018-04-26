<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.row.justify-center.layout
    div.row.col-md-10.col-lg-10
      div.col-12
        p
          big 课程大纲
        q-stepper(vertical='', done="", v-model="currentStep", ref="stepper", color='secondary').bg-white
          q-step(:title='chapter.name',
                  :default="(index == 0) ? 'true' : 'false'",
                  v-for="(chapter, index) in chapters",
                  :key="chapter",
                  :name='index')
            q-list(no-border="")
              q-item(v-for="(directory, index) in chapter.directories", :key="directory")
                q-item-main
                  q-item-title {{index + 1}} {{directory}}
            q-stepper-navigation
              q-btn(color="secondary", @click="$refs.stepper.next()") Next
              q-btn(color="secondary", @click="$refs.stepper.previous()", flat="") Back

</template>

<script>
import {
  QStepper,
  QStep,
  QStepperNavigation
} from 'quasar'
export default {
  name: 'outline',
  components: {
    QStepper,
    QStep,
    QStepperNavigation
  },
  data () {
    return {
      currentStep: 1,
      chapters: [
        {
          name: '第一讲  绪论',
          summary: '第一章主要讲了',
          directories: [
            '化学的发展历史',
            '化学与社会的进步'
          ]
        },
        {
          name: '第二讲  原子结构简介',
          summary: '第二章主要讲了',
          directories: [
            '原子结构简介',
            '四个量子数'
          ]
        },
        {
          name: '第三讲  分子结构简介',
          summary: '第二章主要讲了',
          directories: [
            '化学键',
            '分子结构'
          ]
        },
        {
          name: '第四讲  化学与能源',
          summary: '第二章主要讲了',
          directories: [
            '洁净与可再生能源',
            '新能源'
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
          name: '第六讲  兴奋剂与体育运动',
          summary: '第二章主要讲了',
          directories: [
            '兴奋剂与体育运动'
          ]
        },
        {
          name: '第七讲  化学与人类健康',
          summary: '第二章主要讲了',
          directories: [
            '人体的生命活动与化学',
            '食品安全',
            '合理的营养'
          ]
        },
        {
          name: '第八讲  化学与环境',
          summary: '第二章主要讲了',
          directories: [
            '化学与环境',
            '环境监测与保护'
          ]
        },
        {
          name: '第九讲  化学与药物',
          summary: '第二章主要讲了',
          directories: [
            '常见药物简介',
            '药物与人类健康'
          ]
        },
        {
          name: '第十讲  化学与材料',
          summary: '第二章主要讲了',
          directories: [
            '纳米材料'
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
