package edu.GDPU.Demo.Announcement.controller;


import edu.GDPU.Demo.Announcement.entity.Announcement;
import edu.GDPU.Demo.Announcement.service.AnnouncementService;
import edu.GDPU.Demo.Common.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    /**
     * 获取最新公告
     *
     * @param token 用户Token
     * @return 包含最新公告的Result对象
     */
    @RequestMapping(value = "/getAnnouncements", method = RequestMethod.GET)
    @ResponseBody
    public Result getRecentAnnouncements(@RequestHeader("X-Token") String token) {
        try {
            List<Announcement> announcements = announcementService.getAnnouncementByToken(token);
            return announcements != null ? new Result(announcements) : new Result();
        } catch (RuntimeException e) {
            return new Result(50008, "token验证失败");
        }
    }

    /**
     * 获取所有公告
     *
     * @param token 用户Token
     * @return 包含所有公告的Result对象
     */
    @RequestMapping(value = "/getAllAnnouncements", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllAnnouncements(@RequestHeader("X-Token") String token) {
        try {
            List<Announcement> announcements = announcementService.getAllAnnouncement(token);
            return announcements != null ? new Result(announcements) : new Result();
        } catch (RuntimeException e) {
            return new Result(50008, "token验证失败");
        }
    }

    /**
     * 删除公告
     *
     * @param token 用户Token
     * @param id    公告ID
     * @return 包含操作结果的Result对象
     */
    @RequestMapping(value = "/deleteAnnouncement/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteAnnouncement(@RequestHeader("X-Token") String token, @PathVariable int id) {
        try {
            int result = announcementService.deleteAnnouncement(token, id);
            return result > 0 ? new Result(result) : new Result(-1, "未找到对应的公告");
        } catch (RuntimeException e) {
            return new Result(-1, e.getMessage());
        }
    }

    /**
     * 更新公告
     *
     * @param token        用户Token
     * @param id           公告ID
     * @param announcement 公告对象
     * @return 包含操作结果的Result对象
     */
    @RequestMapping(value = "/updateAnnouncement/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateAnnouncement(@RequestHeader("X-Token") String token,
                                     @PathVariable int id,
                                     @RequestBody Announcement announcement) {
        try {
            int result = announcementService.updateAnnouncement(token, id, announcement.getMessage());
            return result > 0 ? new Result(result) : new Result(-1, "未找到对应的公告");
        } catch (RuntimeException e) {
            return new Result(-1, e.getMessage());
        }
    }

    /**
     * 创建公告
     *
     * @param token        用户Token
     * @param announcement 公告对象
     * @return 包含操作结果的Result对象
     */
    @RequestMapping(value = "/createAnnouncement", method = RequestMethod.POST)
    @ResponseBody
    public Result createAnnouncement(@RequestHeader("X-Token") String token,
                                     @RequestBody Announcement announcement) {
        try {
            int result = announcementService.createAnnouncement(token, announcement.getMessage());
            return result > 0 ? new Result(result) : new Result(-1, "创建公告失败");
        } catch (RuntimeException e) {
            return new Result(-1, e.getMessage());
        }
    }
}