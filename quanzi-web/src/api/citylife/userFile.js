import request from '@/utils/request'

// 查询文件上传列表
export function listUserFile(query) {
  return request({
    url: '/citylife/userFile/list',
    method: 'get',
    params: query
  })
}

// 查询文件上传详细
export function getUserFile(id) {
  return request({
    url: '/citylife/userFile/' + id,
    method: 'get'
  })
}

// 新增文件上传
export function addUserFile(data) {
  return request({
    url: '/citylife/userFile',
    method: 'post',
    data: data
  })
}

// 修改文件上传
export function updateUserFile(data) {
  return request({
    url: '/citylife/userFile',
    method: 'put',
    data: data
  })
}

// 删除文件上传
export function delUserFile(id) {
  return request({
    url: '/citylife/userFile/' + id,
    method: 'delete'
  })
}

// 导出文件上传
export function exportUserFile(query) {
  return request({
    url: '/citylife/userFile/export',
    method: 'get',
    params: query
  })
}