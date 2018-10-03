import axios from 'axios'

// axios.interceptors.request.use(function (config) {
//   config.headers.common = {
//     'Content-Type': 'application/x-www-form-urlencoded'
//   }
//   return config
// }, function (error) {
//   return Promise.reject(error)
// })
axios.defaults.baseURL = 'http://chemiety-admin.kastner.cn'
// axios.defaults.withCredentials = false
axios.defaults.headers.common = {
  'Content-Type': 'application/json'
}

export default {
  getFirstInfo: () => axios.get('/api/v1/getFirstInfo'),
  getAllInfo: () => axios.get('/api/v1/getAllInfo'),
  getAllFiles: (fileType) => axios.get('/api/v1/getAllFiles', {params: {fileType: fileType}}),
  getAllPost: () => axios.get('/api/v1/getPosts'),
  postComment: ({content, postId}) => axios.get('/api/v1/postComment', {params: {content: content, postId: postId}}),
  postPost: ({title, content}) => axios.get('/api/v1/postPost', {params: {title: title, content: content}})
}
