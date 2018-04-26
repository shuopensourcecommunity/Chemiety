<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.layout-padding
    div.row
      div.col-lg-12.col-md-12(v-for="(topic) in topics")
        q-card
          q-card-title {{ topic.bigTitle }}
          q-card-main.text-faded 发布者：{{ topic.publisher }}&nbsp&nbsp&nbsp发布时间：{{ topic.publishDate }}
          q-card-separator
          q-card-main {{ topic.text }}
          q-card-action
            q-btn(flat='', icon="favorite" color="pink-6") {{ topic.love }}
            q-btn(flat='', icon="message" )
          q-card-separator
          q-list
            div(v-for="(comment) in topic.comments")
              q-item
                q-item-side
                  q-item-tile(color="info" icon="face")
                q-item-main
                  q-item-tile.font-small(label="") {{ comment.commentText}}
                  q-item-tile(sublabel="") {{ comment.commenter }}&nbsp&nbsp&nbsp发布时间：{{ comment.commentDate }}
     
</template>

<script>
import {
  QCard
} from 'quasar'
export default {
  name: 'discussion',
  components: {
    QCard
  },
  data () {
    return {
      topics: [
        {
          bigTitle: '元素周期表应该怎么背啊？',
          publisher: '张思远',
          love: 52,
          publishDate: '2018/4/26',
          text: '就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦',
          comments: [
            {
              commentText: 'hhhhhhhhhhh那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨',
              commenter: 'kastner',
              commentDate: '2018/4/26'
            },
            {
              commentText: 'hhhhhhhhhhh那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨',
              commenter: 'kastner',
              commentDate: '2018/4/26'
            }
          ]
        },
        {
          bigTitle: '元素周期表应该怎么背啊？',
          publisher: '张思远',
          love: 32,
          publishDate: '2018/4/26',
          text: '就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦就是背不下来啊好烦哦',
          comments: [
            {
              commentText: 'hhhhhhhhhhh那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨',
              commenter: 'kastner',
              commentDate: '2018/4/26'
            },
            {
              commentText: 'hhhhhhhhhhh那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨那是因为你笨',
              commenter: 'kastner',
              commentDate: '2018/4/26'
            }
          ]
        }
      ]
    }
  }
}
</script>

<style lang="stylus">
.layout-padding
  padding 50px
.font-small
  font-size 14px
</style>
