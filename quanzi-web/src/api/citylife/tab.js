import request from '@/utils/request'

// 查询Tab列表
export function listTab(query) {
  return request({
    url: '/citylife/tab/list',
    method: 'get',
    params: query
  })
}

// 查询Tab详细
export function getTab(id) {
  return request({
    url: '/citylife/tab/' + id,
    method: 'get'
  })
}

// 新增Tab
export function addTab(data) {
  return request({
    url: '/citylife/tab',
    method: 'post',
    data: data
  })
}

// 修改Tab
export function updateTab(data) {
  return request({
    url: '/citylife/tab',
    method: 'put',
    data: data
  })
}

// 删除Tab
export function delTab(id) {
  return request({
    url: '/citylife/tab/' + id,
    method: 'delete'
  })
}

// 导出Tab
export function exportTab(query) {
  return request({
    url: '/citylife/tab/export',
    method: 'get',
    params: query
  })
}