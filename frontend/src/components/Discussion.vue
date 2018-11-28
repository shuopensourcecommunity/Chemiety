<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.row.justify-center.layout-padding
    div.col-sm-12.col-md-8.col-lg-8(v-for="(post, index) in posts")
      q-card.bg-white
        q-card-title {{ post.title }}
        q-card-main.text-faded 发布者：{{ post.user.name }}&nbsp&nbsp&nbsp发布时间：{{post.createDate}}
        q-card-separator
        q-card-main(style="padding-top:30px;padding-bottom:40px") {{ post.content }}
        q-card-separator
        q-list
          q-collapsible(icon="message" :label="post.commentNumber + ' 人评论'")
            q-item(multiline="")(style="padding:0")
              q-item-main.row
                q-input(v-model='remark' float-label="写下你的评论吧！").col-8
                q-btn(flat='' color="primary" icon="send" @click="updateComment(index)" style="padding-right:0").col-4 评论
            div(v-for="(comment) in post.comments")
              q-item
                q-item-main {{comment.content}}
                q-item-side(right="")
                  q-item-tile {{comment.user.name}}
              q-card-separator
    q-modal(v-model="maximizedModal" maximized='' :content-css="{padding: '20px'}" ref="modalRef")
      div(class="q-display-1 q-mb-md") 发布帖子
        q-input(v-model='title' float-label="标题")
        q-input(v-model='content'
                float-label="帖子内容"
                type="textarea"
                :max-height="400"
                rows="10")
        q-btn(color="info" @click="createPost") 创建
        q-btn(color="grey" label="Close" @click.native="modal.close()") 取消
    q-page-sticky(:offset="[18, 18]" style="z-index:999;position:fixed;right:50px;bottom:50px;")
      q-btn(fab-mini round color="pink-6" icon="add" class="animate-pop" @click.native="modal.show()" :key="modal.label")
</template>
<script>
import api from '../api/api'
import {
  Toast
} from 'quasar'
export default {
  name: 'discussion',
  components: {
    Toast
  },
  created () {
    this.getAllPost()
  },
  data () {
    return {
      posts: [],
      comment: '',
      remark: '',
      toastShowing: false,
      search: '',
      maximizedModal: false,
      modal: {
        label: 'Always Maximized',
        show: () => { this.maximizedModal = true },
        close: () => { this.maximizedModal = false }
      },
      title: '',
      content: ''
    }
  },
  methods: {
    notify (eventName) {
      this.$q.notify(`Event "${eventName}" was triggered.`)
    },
    async showByReference () {
      await this.$refs.modalRef.show()
      await this.$refs.modalRef.hide()
      this.$q.notify({
        color: 'secondary',
        message: 'Done opening and closing'
      })
    },
    capitalize (msg) {
      return msg.charAt(0).toUpperCase() + msg.slice(1)
    },
    getAllPost () {
      api.getAllPost().then(res => {
        this.posts = res.data.result.reverse()
      }).catch(error => {
        console.log(error)
      })
    },
    updateComment (index) {
      // 判空
      if (this.remark === '') {
        Toast.create['info']({
          html: '评论内容不能为空'
        })
      }
      else { // 非空
        api.postComment({
          content: this.remark,
          postId: this.posts[index].postId
        })
          .then(res => {
            if (res.data.status === 0) {
              // toast success: res.data.result
              this.$set(this.posts[index], 'comments', [])
              this.posts[index].commentNumber += 1// 评论数 + 1
              this.remark = '' // 清空输入框
              this.posts[index].comments.push(
                res.data.result
              )
              Toast.create['positive']({
                html: '评论成功'
              })
            }
            else {
              Toast.create['info']({
                html: '评论失败'
              })
            }
          })
      }
    },
    createPost () {
      if (this.title === '' || this.content === '') {
        Toast.create['info']({
          html: '不能为空'
        })
      }
      else {
        // 请求前前端操作：清空输入框，关闭模态框
        this.maximizedModal = false
        api.postPost({
          title: this.title,
          content: this.content
        })
          .then(res => {
            if (res.data.status === 0) {
              // 将新 post 加入数组
              this.posts.unshift(
                res.data.result
              )
              this.title = ''
              this.content = ''
              Toast.create['positive']({
                html: '发布成功'
              })
            }
            else {
              Toast.create['info']({
                html: res.data.result
              })
            }
          })
          .catch(err => {
            Toast.create['info']({
              html: err
            })
          })
      }
    }
  }
}
</script>

<style lang="stylus">
.layout-padding
  padding-top 50px
.font-small
  font-size 14px
</style>
