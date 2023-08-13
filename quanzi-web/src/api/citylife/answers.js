import request from '@/utils/request'

// 查询回答列表
export function listAnswers(query) {
  return request({
    url: '/citylife/answers/list',
    method: 'get',
    params: query
  })
}

// 查询回答详细
export function getAnswers(id) {
  return request({
    url: '/citylife/answers/' + id,
    method: 'get'
  })
}

// 新增回答
export function addAnswers(data) {
  return request({
    url: '/citylife/answers',
    method: 'post',
    data: data
  })
}

// 修改回答
export function updateAnswers(data) {
  return request({
    url: '/citylife/answers',
    method: 'put',
    data: data
  })
}

// 删除回答
export function delAnswers(id) {
  return request({
    url: '/citylife/answers/' + id,
    method: 'delete'
  })
}

// 导出回答
export function exportAnswers(query) {
  return request({
    url: '/citylife/answers/export',
    method: 'get',
    params: query
  })
}