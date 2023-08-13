import request from '@/utils/request'

// 查询专业分类列表
export function listMajor(query) {
  return request({
    url: '/citylife/major/list',
    method: 'get',
    params: query
  })
}

// 查询专业分类详细
export function getMajor(id) {
  return request({
    url: '/citylife/major/' + id,
    method: 'get'
  })
}

// 新增专业分类
export function addMajor(data) {
  return request({
    url: '/citylife/major',
    method: 'post',
    data: data
  })
}

// 修改专业分类
export function updateMajor(data) {
  return request({
    url: '/citylife/major',
    method: 'put',
    data: data
  })
}

// 删除专业分类
export function delMajor(id) {
  return request({
    url: '/citylife/major/' + id,
    method: 'delete'
  })
}

// 导出专业分类
export function exportMajor(query) {
  return request({
    url: '/citylife/major/export',
    method: 'get',
    params: query
  })
}