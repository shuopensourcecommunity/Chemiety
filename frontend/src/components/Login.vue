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
        params: {
          username: this.username,
          password: this.password
        },
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
        withCredentials: true
      })
        .then(res => {
          console.log(res.data)
          axios({
            url: 'http://localhost:8080/getUserInfo',
            method: 'POST',
            headers: {
              'Content-Type': 'application/json;charset=utf-8'
            },
            withCredentials: true
          })
            .then(res => {
              alert(this.getCookie('session'))
              if (res.data.result.roles === 'TEACHER') {
                window.location.href = 'http://localhost:8080/admin/index'
              }
              else {
                window.location.href = 'http://localhost:8081/'
              }
              console.log(res.data)
            })
            .catch(err => {
              console.log(err)
            })
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

// @Path("/findAll")
// @Produces ({MediaType.APPLICATION_JSON })
// public List<Product> findAll() {
//     List<Product> result  = new ArrayList<Product>();
//     result.add(new Product(...));
//     return Response.ok().entity(new GenericEntity<List<Product>>(result) {})
//         .header(“Access-Control-Allow-Origin”, “*”)
//         .header(“Access-Control-Allow-Methods”, “GET, POST, DELETE, PUT, OPTIONS, HEAD”)
//         .build();
// }