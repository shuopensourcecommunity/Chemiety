import axios from 'axios'

axios.defaults.baseURL = 'http://chemiety.kastner.cn'
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8'
axios.defaults.withCredentials = true

export default {
  getFirstInfo: () => axios.post('/getFirstInfo'),
  getAllInfo: () => axios.post('/getAllInfo'),
  getAllFiles: (fileType) => axios.post('/getAllFiles', { params: fileType }),
  getAllPost: () => axios.post('/getAllPost'),
  postComment: ({content, postId}) => axios.post('/postComment', { params: {content, postId} }),
  postPost: ({title, content}) => axios.post('/postPost', {param: {title, content}})
}
