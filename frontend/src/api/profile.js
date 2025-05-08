import request from '@/utils/request'

export function getAnnouncements(params) {
  return request({
    // url: '/vue-admin-template/table/list',
    url: '/Announcement/getAnnouncements',
    method: 'get',
    params
  })
}
