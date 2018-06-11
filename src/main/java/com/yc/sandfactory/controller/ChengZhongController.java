package com.yc.sandfactory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.entity.ChengZhongRecord;
import com.yc.sandfactory.service.IChengZhongService;
import com.yc.sandfactory.util.JsonMapperProvide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project: sandfactory
 * @author: yc
 */
@RestController
@RequestMapping("/admin/record")
public class ChengZhongController {

  public Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IChengZhongService chengZhongService;

  @RequestMapping(value = "/list")
  public Object list(String startTime, String endTime, ChengZhongRecord condition, int pageNum, int pageSize)
      throws JsonProcessingException {
    logger.info("调用称重list请求的输入参数：recodRequestBean：{}",
        JsonMapperProvide.alwaysMapper().writeValueAsString(condition)
    );

    try {
      Pagination pagination = chengZhongService.queryRecordForPage(startTime, endTime, condition, pageNum, pageSize);
      return ResponseBean.createSuccess(pagination);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
    return ResponseBean.FAIL;
  }

  @RequestMapping(value = "/newList")
  public Object newList(String startTime, String endTime, ChengZhongRecord condition) {
    logger.info("调用称重newList请求的输入参数");


    try {
      Pagination pagination = chengZhongService.queryRecordForPage(startTime, endTime, condition, 1, 10);
      return ResponseBean.createSuccess(pagination);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
    return ResponseBean.FAIL;
  }

  @RequestMapping(value = "/get")
  public Object get(Integer id) {
    logger.info("调用称重详情接口请求的输入参数：id：{}", id);
    ChengZhongRecord record = chengZhongService.getRecord(id);
    return record;
  }
}
