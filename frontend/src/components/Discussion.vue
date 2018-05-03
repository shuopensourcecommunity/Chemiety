<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.row.justify-center.layout-padding
    div.col-sm-12.col-md-8.col-lg-8(v-for="(post) in posts")
      q-card.bg-white
        q-card-title {{ post.title }}
        q-card-main.text-faded 发布者：{{ post.user.name }}&nbsp&nbsp&nbsp发布时间：{{post.createDate}}
        q-card-separator
        q-card-main {{ post.content }}
        q-card-action
          q-btn(flat='', icon="favorite" color="pink-6")
          q-btn(flat='', icon="message" ) 发表评论 {{post.commentNumber}}
        q-card-separator
        //- q-list
        //-   div(v-for="(comment) in topic.comments")
        //-     q-item
        //-       q-item-side
        //-         q-item-tile(color="info" icon="face")
        //-       q-item-main
        //-         q-item-tile.font-small(label="") {{ comment.commentText}}
        //-         q-item-tile(sublabel="") {{ comment.commenter }}&nbsp&nbsp&nbsp发布时间：{{ comment.commentDate }}
    q-page-sticky(:offset="[18, 18]" style="z-index:999;position:fixed;right:50px;bottom:50px;")
      q-btn(fab-mini round color="primary" icon="add" class="animate-pop")
    q-modal
      q-modal-layout(
        header-style="min-height: 100px"
        content-class="{'bg-primary': isPrimary, 'some-class': someBoolean}"
        footer-class="bg-primary some-class"
        footer-style="{fontSize: '24px', fontWeight: 'bold'}"
      )
        
</template>

<script>
import axios from 'axios'
import {
  QCard
} from 'quasar'
export default {
  name: 'discussion',
  components: {
    QCard
  },
  created () {
    this.getAllPost()
  },
  data () {
    return {
      posts: []
    }
  },
  methods: {
    getAllPost () {
      axios({
        url: 'http://localhost:8080/getPosts',
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
        withCredentials: true
      })
        .then(res => {
          console.log(res.data.result)
          this.posts = res.data.result
        })
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
