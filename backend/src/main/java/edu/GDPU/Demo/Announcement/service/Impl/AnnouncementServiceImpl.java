package edu.GDPU.Demo.Announcement.service.Impl;

import org.apache.log4j.Logger;
import edu.GDPU.Demo.Announcement.entity.Announcement;
import edu.GDPU.Demo.Announcement.mapper.AnnouncementMapper;
import edu.GDPU.Demo.Announcement.service.AnnouncementService;
import edu.GDPU.Demo.Common.annotation.AuthCheck;
import edu.GDPU.Demo.UserLogin.entity.User;
import edu.GDPU.Demo.UserLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private static final Logger log = Logger.getLogger(AnnouncementServiceImpl.class);

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Autowired
    private UserService userService;

    /**
     * 根据Token获取最新公告
     *
     * @param token 用户Token
     * @return 最新公告列表
     */
    @Override
    @AuthCheck
    public List<Announcement> getAnnouncementByToken(String token) {
        log.info("getAnnouncementByToken22222222222222222222222222222222222222222222222");
        return announcementMapper.selectLatestAnnouncements();
    }

    /**
     * 根据Token获取所有公告
     *
     * @param token 用户Token
     * @return 所有公告列表
     */
    @Override
    @AuthCheck
    public List<Announcement> getAllAnnouncement(String token) {
        return announcementMapper.selectAllAnnouncements();
    }

    /**
     * 根据Token和ID删除公告
     *
     * @param token 用户Token
     * @param id    公告ID
     * @return 受影响的行数
     */
    @Override
    @AuthCheck(roles = {"SysAdmin", "DormAdmin"})
    public int deleteAnnouncement(String token, int id) {
        return announcementMapper.deleteById(id);
    }

    /**
     * 根据Token和ID更新公告
     *
     * @param token   用户Token
     * @param id      公告ID
     * @param message 公告内容
     * @return 受影响的行数
     */
    @Override
    @AuthCheck(roles = {"SysAdmin", "DormAdmin"})
    public int updateAnnouncement(String token, int id, String message) {
        User user = userService.getUserByToken(token);
        Announcement ann = new Announcement();
        ann.setAnncId(id);
        ann.setAvatar(user.getAvatar());
        ann.setMessage(message);
        ann.setPublisher(user.getUsername());
        return announcementMapper.updateById(ann);
    }

    /**
     * 根据Token创建公告
     *
     * @param token   用户Token
     * @param message 公告内容
     * @return 受影响的行数
     */
    @Override
    @AuthCheck(roles = {"SysAdmin", "DormAdmin"})
    public int createAnnouncement(String token, String message) {
        User user = userService.getUserByToken(token);
        Announcement ann = new Announcement();
        ann.setMessage(message);
        ann.setPublisher(user.getUsername());
        ann.setAvatar(user.getAvatar());
        return announcementMapper.insert(ann);
    }
}