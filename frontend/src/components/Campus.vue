<template lang="pug">
  //参考文献，专题导读，前沿视点
  div.row.justify-center.layout-padding
    div.row.col-md-10.col-lg-10.xs-gutter
      div.col-lg-6.col-md-12.col-sm-12
        q-card.col-12.bg-white
          q-card-title 参考文献
            span(slot="subtitle") 领域里优秀的论文
          q-card-separator
          q-list
            div(v-for="(paperList,index) in paperLists")
              q-item(:id="paperList",link='', @click="toLink(paperList.url)")
                q-item-side {{index+1}}
                q-item-main(label-lines="1" :label='paperList.title') 
                q-item-side(color="blue-4") {{paperList.time}}
        q-card.col-12.bg-white
          q-card-title 前沿视点
            span(slot="subtitle") 化学界发生的一些新鲜新闻与热点
          q-card-separator
          q-list
            div(v-for="(nameList,index) in nameLists")
              q-item(:id="nameList",link='', @click="toLink(nameList.url)")
                q-item-side {{index+1}}
                q-item-main(label-lines="1" :label='nameList.title') 
                q-item-side(color="blue-4") {{nameList.time}}
      div.col-lg-6.col-md-12.col-sm-12
        q-card.col-12.bg-white
          q-card-title 专题导读
            span(slot="subtitle") 专题阅读材料扩展
          q-card-separator
          q-list
            div(v-for="(mainList,index) in mainLists")
              q-collapsible(:label='mainList.bigTitle')
                q-item(:id="mainList",link='', @click="toLink(mainList.url)" v-for="content in mainList.contents"  :key="content.smallTitle")
                  q-item-main(label-lines="1" :label='content.smallTitle') 
                  q-item-side(color="blue-4") {{content.smallTime}}
</template>

<script>
export default {
  name: 'discussion',
  data () {
    return {
      paperLists: [
        {
          time: '2017/1/1',
          title: '食品安全与社会研究',
          url: 'https://www.baidu.com'
        },
        {
          time: '2018/1/5',
          title: '机器学习在化学中的应用',
          url: 'https://www.baidu.com'
        },
        {
          time: '2018/1/5',
          title: '机器学习在化学中的应用',
          url: 'https://www.baidu.com'
        },
        {
          time: '2018/1/5',
          title: '机器学习在化学中的应用',
          url: 'https://www.baidu.com'
        }
      ],
      nameLists: [
        {
          time: '2017/1/1',
          title: '地沟油新闻报道',
          url: 'https://www.baidu.com'
        },
        {
          time: '2018/1/5',
          title: '苏丹红最新研究',
          url: 'https://www.baidu.com'
        },
        {
          time: '2017/1/1',
          title: '地沟油新闻报道',
          url: 'https://www.baidu.com'
        },
        {
          time: '2017/1/1',
          title: '地沟油新闻报道',
          url: 'https://www.baidu.com'
        },
        {
          time: '2018/1/5',
          title: '苏丹红最新研究',
          url: 'https://www.baidu.com'
        }
      ],
      mainLists: [
        {
          time: '2017/1/1',
          bigTitle: '香精香料专题',
          contents: [
            {
              smallTitle: '麝香的生产',
              smallUrl: 'www.baidu.com',
              smallTime: '2018/3/3'
            },
            {
              smallTitle: '香水的生产',
              smallUrl: 'www.baidu.com',
              smallTime: '2018/3/3'
            }
          ]
        },
        {
          time: '2017/1/1',
          bigTitle: '农药专题',
          contents: [
            {
              smallTitle: '百草枯的危害',
              smallUrl: 'www.baidu.com',
              smallTime: '2018/3/3'
            },
            {
              smallTitle: '敌敌畏为什么被禁用',
              smallUrl: 'www.baidu.com',
              smallTime: '2018/3/3'
            }
          ]
        },
        {
          time: '2017/1/1',
          bigTitle: '新型材料专题',
          contents: [
            {
              smallTitle: '麝香的生产',
              smallUrl: 'www.baidu.com',
              smallTime: '2018/3/3'
            },
            {
              smallTitle: '香水的生产',
              smallUrl: 'www.baidu.com',
              smallTime: '2018/3/3'
            }
          ]
        },
        {
          time: '2017/1/1',
          bigTitle: '有机材料专题',
          contents: [
            {
              smallTitle: '麝香的生产',
              smallUrl: 'www.baidu.com',
              smallTime: '2018/3/3'
            },
            {
              smallTitle: '香水的生产',
              smallUrl: 'www.baidu.com',
              smallTime: '2018/3/3'
            }
          ]
        },
        {
          time: '2017/1/1',
          bigTitle: '无机材料专题',
          contents: [
            {
              smallTitle: '百草枯的危害',
              smallUrl: 'www.baidu.com',
              smallTime: '2018/3/3'
            },
            {
              smallTitle: '敌敌畏为什么被禁用',
              smallUrl: 'www.baidu.com',
              smallTime: '2018/3/3'
            }
          ]
        }
      ]
    }
  },
  methods: {
    toLink (url) {
      window.location.href = url
    }
    
  }
}
</script>

<style lang="stylus">
  .layout-padding
    padding-top 50
  .titleBold
    font-weight bold
</style>
