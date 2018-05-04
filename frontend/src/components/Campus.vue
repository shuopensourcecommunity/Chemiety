<template lang="pug">
  //if you want automatic padding use "layout-padding" class
  div.row.justify-center.layout-padding
    div.col-sm-12.col-md-8.col-lg-8
      h4.caption 学习园地
      q-card.bg-white
        q-card-title 参考阅读资料
          span(slot="subtitle") 值得同学们课外阅读的材料
        q-card-separator
        q-list
          div(v-for="(website,index) in websites")
            q-item(:id="website",link='', @click="toLink(website.url)")
              q-item-side {{index+1}}
              q-item-main(label-lines="1" :label='website.title') {{website.name}}
              q-item-side {{website.date}}
      

</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      websites: [
        {
          url: '',
          name: '',
          date: ''
        }
      ]
    }
  },
  created () {
    this.getAllFile()
  },
  methods: {
    getAllFile () {
      axios({
        url: 'http://139.196.75.17:8080/getAllFiles',
        params: {
          fileType: 'website'
        },
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
        withCredentials: true
      })
        .then(res => {
          // console.log(1)
          // console.log(res.data.result)
          this.websites = res.data.result
        })
    },
    toLink (url) {
      window.location.href = url
    }
  }
}
</script>

<style lang="stylus">
.layout-padding
  padding-top 50
</style>
