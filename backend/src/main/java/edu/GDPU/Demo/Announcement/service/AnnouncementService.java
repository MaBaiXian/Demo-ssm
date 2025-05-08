package edu.GDPU.Demo.Announcement.service;


import edu.GDPU.Demo.Announcement.entity.Announcement;

import java.util.List;

public interface AnnouncementService {

    /**
     * 根据Token获取最新公告
     *
     * @param token 用户Token
     * @return 最新公告列表3条
     */
    List<Announcement> getAnnouncementByToken(String token);

    /**
     * 根据Token获取所有公告
     *
     * @param token 用户Token
     * @return 所有公告列表
     */
    List<Announcement> getAllAnnouncement(String token);

    /**
     * 根据Token和ID删除公告
     *
     * @param token 用户Token
     * @param id    公告ID
     * @return 受影响的行数
     */
    int deleteAnnouncement(String token, int id);

    /**
     * 根据Token和ID更新公告
     *
     * @param token   用户Token
     * @param id      公告ID
     * @param message 公告内容
     * @return 受影响的行数
     */
    int updateAnnouncement(String token, int id, String message);

    /**
     * 根据Token创建公告
     *
     * @param token   用户Token
     * @param message 公告内容
     * @return 受影响的行数
     */
    int createAnnouncement(String token, String message);
}
