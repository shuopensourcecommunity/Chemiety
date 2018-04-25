<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.row.justify-center.layout
    div.row.col-md-10.col-lg-10
      div.col-12.wrap.flex.row
        div.col-lg-6.col-md-6.col-xs-12
          q-card.bg-white
            q-card-media(overlay-position="top").text-center
              img(src="statics/head.jpg").responsive
              q-card-title 陆文聪
                span(slot="subtitle") 上海大学理学院副院长
            q-card-separator
            q-list.separator
              q-collapsible(icon="account circle" label="简介")
                p   陆文聪，教授，博士，理学院副院长，材料学博导</br>
                  |   专业：物理化学</br>
                  |   主要研究领域：化学数据挖掘，材料设计、工业优化</br>
                  |   科研获奖：用于建模优化和故障诊断的数据挖掘技术，中国高校科学技术二等奖（2002年）</br>
                  |   荣誉称号：2001年、2004年获上海市育才奖</br>
                  |   现兼职：中国化学会计算机化学委员会委员、上海市分子科学研究会理事长、《计算机与应用化学》执行编委</br>
                  |   多年来一直从事化学数据挖掘，材料设计、工业优化的研究工作，曾先后应邀访问匈牙利Eotvos Loránd University和俄罗斯科学院巴依科夫冶金和材料科学研究所等，并进行科研合作。
        div.col-lg-6.col-md-6.col-xs-12
          q-card.bg-white
            q-card-media(overlay-position="top").text-center
              img(src="statics/head.jpg").responsive
              q-card-title 李敏杰
                span(slot="subtitle") 上海大学理学院化学系副教授
            q-card-separator
            q-list.separator
              q-collapsible(icon="account circle" label="简介")
                p   李敏杰(女)，副教授，研究生导师 </br>
                  |   主要研究领域：计算化学 物理有机化学</br>
                  |   讲授课程：物理化学, 实验设计与化工数据处理, Matlab在化学化工中的应用，化学与社会，药物与健康，物理化学实验
</template>

<script>
  export default {
    name: 'teachers',
    data () {
      return {}
    }
  }
</script>

<style lang="stylus">
  .layout-padding
    padding 50

</style>
