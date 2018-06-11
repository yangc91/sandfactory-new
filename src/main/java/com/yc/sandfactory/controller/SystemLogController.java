package com.yc.sandfactory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.entity.SystemLog;
import com.yc.sandfactory.service.ISystemLogService;
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
@RequestMapping("/admin/systemlog")
public class SystemLogController {

  public Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ISystemLogService systemLogService;

  @RequestMapping(value = "/list")
  public Object list(String startTime, String endTime, String action,  String search, int pageNum, int pageSize) {
    logger.info("------systemlog list----");
    try {
      Pagination pagination = this.systemLogService.queryForPage(startTime, endTime, action, search, pageNum, pageSize);
      return ResponseBean.createSuccess(pagination);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
    return ResponseBean.FAIL;
  }
}
