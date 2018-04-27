<template lang="pug">
div.row.justify-center.layout
    q-card
        q-card-title 登录
        q-card-main
            q-input(v-model='username' float-label='请输入学号/工号')
            q-input(v-model='password' float-label='请输入密码')
            q-btn(color='primary' @click='login') 登录
</template>

<script>
import axios from 'axios'
export default {
  name: 'login',
  data () {
    return {
      username: '',
      password: ''
    }
  },
  computed: {},
  methods: {
    login () {
      axios({
        url: 'localhost:8080/login',
        method: 'POST',
        param: {
          username: this.username,
          password: this.password
        }
      })
        .then(res => {
          console.log(res.data)
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>

<style lang="stylus">
</style>
