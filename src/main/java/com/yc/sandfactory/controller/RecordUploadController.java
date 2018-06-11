package com.yc.sandfactory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yc.sandfactory.entity.ChengZhongRecord;
import com.yc.sandfactory.service.IChengZhongService;
import com.yc.sandfactory.util.JsonMapperProvide;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project: sandfactory
 * @author: yc
 */
@RestController
@RequestMapping("/admin/public/record")
public class RecordUploadController {

  public Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IChengZhongService chengZhongService;

  @RequestMapping(value = "upload", method = RequestMethod.POST)
  public Object upload(@RequestBody List<ChengZhongRecord> recordList)
      throws JsonProcessingException {
    logger.info("调用称重upload请求的输入参数：recordList：{}",
        JsonMapperProvide.alwaysMapper().writeValueAsString(recordList));
    Map<String, Object> result = new HashMap<>();
    result.put("success", false);

    try {
      for (ChengZhongRecord record : recordList) {
        chengZhongService.add(record);
      }
      result.put("success", true);
    } catch (Exception e) {
      logger.error("称重记录上报入库失败", e.getMessage());
      result.put("msg", "称重记录上报入库失败");
    }
    return result;
  }
}
