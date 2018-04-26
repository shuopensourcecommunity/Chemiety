<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.row.justify-center.layout-padding
    div.row.col-md-8.col-lg-8
      q-card(id="introList").bg-white.col-12
        q-card-title
          q-icon(name="face" color="info") &nbsp期末小组演讲大作业要求
        q-card-separator
        q-card-main(style="padding-bottom:30px" )
          p 每个小组对照课堂上老师布置的题目，挑选自己小组感兴趣的题目，进行专题资料搜索与阅读，最后在第十周进行演讲展示该主题的学习内容与课外拓展主题。</br>
          p 展示时可以搭配PPT,视频等方式。

</template>

<script>
export default {
  name: 'assignment',
  data () {
    return {}
  }
}
</script>

<style lang="stylus">
.layout-padding
  padding-top 50
</style>
