<template lang="pug">
div.row.justify-center.layout
  div.row.col-md-8.col-lg-8
    div.col-12
      h4.caption 课程公告
      //info card
      div.card-padding(v-for= "(info,index) in Infos")
        q-card.bg-white
          q-item.content-padding
            q-item-side
              big
                q-icon(name="face" color="info")
            q-item-main
                q-item-tile.text(label='') {{ info.content }}
          q-card-separator
          q-card-main.text-faded 发布者：{{info.user.username}}&nbsp&nbsp&nbsp发布时间：{{info.createDate}}
          q-card-separator
        
        
</template>

<script>
import axios from 'axios'
export default {
  name: 'info',
  data () {
    return {
      Infos: [
        {
          user: {
            gender: '',
            name: '',
            roles: '',
            userId: '',
            username: ''
          },
          content: '',
          createDate: '',
          infoId: ''
        }
      ]
    }
  },
  created () {
    this.getAllInfo()
  },
  methods: {
    getAllInfo () {
      axios({
        url: 'http://localhost:8080/getAllInfo',
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
        withCredentials: true
      })
        .then(res => {
          // console.log(1)
          // console.log(res.data.result)
          this.Infos = res.data.result
        })
    },
    downloadFile (url) {
      window.location.href = url
    }
  }
}
</script>

<style lang="stylus">
  .card-separator
    margin-bottom 0
  .card-title
    font-size 18px
  .layout
    padding 10px 0 0 0
    background-color rgb(244,244,244)
  .text
    word-wrap:break-word;
  .card-padding
    padding-bottom 10px
  .content-padding
    padding-bottom 20px
    padding-top 20px
</style>
