import request from '@/utils/request'

// 查询问题列表
export function listQuestions(query) {
  return request({
    url: '/citylife/questions/list',
    method: 'get',
    params: query
  })
}

// 查询问题详细
export function getQuestions(id) {
  return request({
    url: '/citylife/questions/' + id,
    method: 'get'
  })
}

// 新增问题
export function addQuestions(data) {
  return request({
    url: '/citylife/questions',
    method: 'post',
    data: data
  })
}

// 修改问题
export function updateQuestions(data) {
  return request({
    url: '/citylife/questions',
    method: 'put',
    data: data
  })
}

// 删除问题
export function delQuestions(id) {
  return request({
    url: '/citylife/questions/' + id,
    method: 'delete'
  })
}

// 导出问题
export function exportQuestions(query) {
  return request({
    url: '/citylife/questions/export',
    method: 'get',
    params: query
  })
}