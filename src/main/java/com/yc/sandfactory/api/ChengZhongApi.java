package com.yc.sandfactory.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yc.sandfactory.bean.MonthCountBean;
import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.entity.ChengZhongRecord;
import com.yc.sandfactory.service.IChengZhongService;
import com.yc.sandfactory.util.DateTimeUtil;
import com.yc.sandfactory.util.JsonMapperProvide;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/api/record")
public class ChengZhongApi {

  public Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IChengZhongService chengZhongService;

  @RequestMapping(value = "/list")
  public Object list(String startTime, String endTime, ChengZhongRecord condition, int pageNum, int pageSize, String searchKey)
      throws JsonProcessingException {
    logger.info("调用称重list请求的输入参数：recodRequestBean：{}",
        JsonMapperProvide.alwaysMapper().writeValueAsString(condition)
    );

    try {
      Pagination pagination = chengZhongService.queryRecordForPage(startTime, endTime, condition, pageNum, pageSize, searchKey);
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

  @RequestMapping(value = "/todayCount")
  public Object count() {
    logger.info("调用称重统计接口");
    try {
      Map<String, Object> result = new HashMap<>();

      //获取当前年月份的应用情况
      Calendar now = Calendar.getInstance();
      now.setTime(new Date());

      //日统计
      String dateStr = DateTimeUtil.dateToStr(now.getTime(), "yyyy-MM-dd");
      String todayStartTime = dateStr + " 00:00:00";
      String todayEndTime = dateStr + " 23:59:59";

      Integer todayNo = chengZhongService.countRecordNo(todayStartTime, todayEndTime, null);
      Float todayWeight = chengZhongService.countRecordWeight(todayStartTime, todayEndTime, null);

      result.put("todayNo", todayNo);
      result.put("todayWeight", todayWeight);

      //河沙
      Integer hshaNo = chengZhongService.countRecordNo(todayStartTime, todayEndTime, "河沙");
      Float hshaWeight = chengZhongService.countRecordWeight(todayStartTime, todayEndTime, "河沙");

      result.put("hshaNo", hshaNo);
      result.put("hshaWeight", hshaWeight);

      // 河石
      Integer hshiNo = chengZhongService.countRecordNo(todayStartTime, todayEndTime, "河石");
      Float hshiWeight = chengZhongService.countRecordWeight(todayStartTime, todayEndTime, "河石");

      result.put("hshiNo", hshiNo);
      result.put("hshiWeight", hshiWeight);

      return ResponseBean.createSuccess(result);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
    return ResponseBean.FAIL;
  }
}
