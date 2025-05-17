package edu.GDPU.Demo.Announcement.mapper;

import edu.GDPU.Demo.Announcement.entity.Announcement;

import java.util.List;

public interface AnnouncementMapper {
    /**
     * 查询最新公告
     *
     * @return 最新公告列表3条
     */
    List<Announcement> selectLatestAnnouncements();

    /**
     * 查询所有公告
     *
     * @return 所有公告列表
     */
    List<Announcement> selectAllAnnouncements();

    /**
     * 根据ID删除公告
     *
     * @param id 公告ID
     * @return 受影响的行数
     */
    int deleteById(Integer id);

    /**
     * 根据ID更新公告
     *
     * @param announcement 公告对象
     * @return 受影响的行数
     */
    int updateById(Announcement announcement);

    /**
     * 插入新公告
     *
     * @param announcement 公告对象
     * @return 受影响的行数
     */
    int insert(Announcement announcement);
}