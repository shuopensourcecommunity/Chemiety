<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.layout-padding
    p
      big 课程大纲
    q-stepper(vertical='', done="", v-model="currentStep", ref="stepper", color='secondary')
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
          name: '第一讲  化学发展简史',
          summary: '第一章主要讲了',
          directories: [
            '前言',
            '先秦时期化学的萌芽',
            '秦汉到魏晋南北朝金丹术的兴起',
            '隋唐至明清金丹术的衰落'
          ]
        },
        {
          name: '第二讲  元素',
          summary: '第二章主要讲了',
          directories: [
            '前言',
            '古代西方元素起源学说',
            '古代东方元素起源学说',
            '大爆炸理论'
          ]
        },
        {
          name: '第三讲  传统能源与新能源',
          summary: '第二章主要讲了',
          directories: [
            '前言',
            '古代西方元素起源学说',
            '古代东方元素起源学说',
            '大爆炸理论'
          ]
        },
        {
          name: '第四讲  大气环境',
          summary: '第二章主要讲了',
          directories: [
            '前言',
            '古代西方元素起源学说',
            '古代东方元素起源学说',
            '大爆炸理论'
          ]
        },
        {
          name: '第五讲  水与水溶液',
          summary: '第二章主要讲了',
          directories: [
            '前言',
            '古代西方元素起源学说',
            '古代东方元素起源学说',
            '大爆炸理论'
          ]
        },
        {
          name: '第六讲  化学电池',
          summary: '第二章主要讲了',
          directories: [
            '前言',
            '古代西方元素起源学说',
            '古代东方元素起源学说',
            '大爆炸理论'
          ]
        },
        {
          name: '第七讲  材料',
          summary: '第二章主要讲了',
          directories: [
            '前言',
            '古代西方元素起源学说',
            '古代东方元素起源学说',
            '大爆炸理论'
          ]
        },
        {
          name: '第八讲  药物与化学',
          summary: '第二章主要讲了',
          directories: [
            '前言',
            '古代西方元素起源学说',
            '古代东方元素起源学说',
            '大爆炸理论'
          ]
        },
        {
          name: '第九讲  营养与健康',
          summary: '第二章主要讲了',
          directories: [
            '前言',
            '古代西方元素起源学说',
            '古代东方元素起源学说',
            '大爆炸理论'
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
