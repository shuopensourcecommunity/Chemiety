<template lang="pug">
div.row.justify-center.layout
    q-card
        q-card-title 登录
        q-card-main
            q-input(v-model='username' float-label='请输入学号/工号')
            q-input(v-model='password' type='password' float-label='请输入密码')
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
        url: 'http://localhost:8080/login',
        method: 'POST',
        param: {
          username: this.username,
          password: this.password
        },
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        withCredentials: true
      })
        .then(res => {
          console.log(res.data)
          console.log(this.getCookie('session').getAttribute('currentUser'))
          if (this.getCookie('session').getAttribute('currentUser') === 1) {
            window.location.href = 'http://localhost:8080/admin/index'
          }
          else {
            this.$router.push('/')
          }
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
