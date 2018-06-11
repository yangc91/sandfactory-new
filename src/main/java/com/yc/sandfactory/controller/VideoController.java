package com.yc.sandfactory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.entity.Video;
import com.yc.sandfactory.service.ISystemLogService;
import com.yc.sandfactory.service.IVideoService;
import com.yc.sandfactory.util.Constants;
import com.yc.sandfactory.util.JsonMapperProvide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/5/17 上午12:18
 */
@RestController
@RequestMapping("/video")
public class VideoController extends BaseController {

  public Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IVideoService videoService;

  @Autowired
  private ISystemLogService systemLogService;

  @RequestMapping(value = "/list")
  public Object list(Video condition, int pageNum, int pageSize, String searchKey) throws JsonProcessingException {
    logger.info("video list : 参数：condition：{}", JsonMapperProvide.alwaysMapper().writeValueAsString(condition));
    try {
      Pagination pagination = this.videoService.queryForPage(condition, searchKey, pageNum, pageSize);
      return ResponseBean.createSuccess(pagination);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
    return ResponseBean.FAIL;

  }

  @RequestMapping(value = "/get")
  public Object get(Integer id) {
    logger.info("video get：id：{}", id);
    Video video = videoService.get(id);
    return video;
  }

  @RequestMapping(value = "/del")
  public Object del(Integer id, HttpServletRequest request) {
    logger.info("video del：id：{}", id);
    Map<String, Object> result = new HashMap<>();
    result.put("success", "false");

    try {
      videoService.del(id);
      result.put("success", "true");
      systemLogService.addLog(getLoginUser(request), request.getRemoteAddr(), Constants.ENUM_LOG_TYPE.videoManagerLog,
          "删除监控【 " + id + "】成功");
    } catch (Exception e) {
      logger.error("删除监控出错", e);
    }

    return result;
  }

  @RequestMapping(value = "/save")
  public Object get(Video video, HttpServletRequest request) throws JsonProcessingException {
    logger.info("video add：输入参数：{}", JsonMapperProvide.alwaysMapper().writeValueAsString(video));
    Map<String, Object> result = new HashMap<>();
    result.put("success", "false");
    try {
      videoService.add(video);
      result.put("success", "true");
      systemLogService.addLog(getLoginUser(request), request.getRemoteAddr(), Constants.ENUM_LOG_TYPE.videoManagerLog,
          "添加监控【 " + video.getName() + "】成功");
    } catch (Exception e) {
      logger.error("添加监控出错", e);
    }

    return result;
  }

  @RequestMapping(value = "/update")
  public Object update(Video video, HttpServletRequest request) throws JsonProcessingException {
    logger.info("video update：输入参数：{}",
        JsonMapperProvide.alwaysMapper().writeValueAsString(video));

    Map<String, Object> result = new HashMap<>();
    result.put("success", "false");

    try {
      videoService.update(video);
      result.put("success", "true");
      systemLogService.addLog(getLoginUser(request), request.getRemoteAddr(), Constants.ENUM_LOG_TYPE.videoManagerLog,
          "修改监控【 " + video.getName() + "】成功");
    } catch (Exception e) {
      logger.error("更新监控出错", e);
    }
    return result;
  }
}
