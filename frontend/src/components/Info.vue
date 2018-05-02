<template lang="pug">
div.row.justify-center.layout
  div.row.col-md-10.col-lg-10
    div.col-sm-12.col-md-4.col-lg-4
      //info card
      q-card.bg-white
        q-item
          q-item-side
            big
              q-item-tile(icon="warning", color='warning')
          q-item-main
              q-item-tile.card-title(label='') 公告
          q-item-side
            q-item-tile(right='', icon='more vert')
        q-card-main
          br
          p {{ content }}
        q-card-separator.card-separator
        q-item
          q-item-side
            q-item-tile(icon="arrow forward")
          q-item-main
            q-item-tile(label='') 查看所有公告
      
</template>

<script>
import axios from 'axios'
export default {
  name: 'info',
  data () {
    return {
      Info: [
        {
          title: '',
          content: '',
          time: ''
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
          console.log(1)
          console.log(res.data.result)
          this.Info = res.data.result
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
</style>
