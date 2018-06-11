package com.yc.sandfactory.service;

import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.entity.ChengZhongRecord;

/**
 * @project: sandfactory
 * @author: yc
 */
public interface IChengZhongService {

  /**
   * 分页查找
   * @param chengZhongRecord
   * @param pageNo
   * @param pageSize
   * @return
   */
  Pagination<ChengZhongRecord> queryRecordForPage(String startTime, String endTime, ChengZhongRecord chengZhongRecord, Integer pageNo, Integer pageSize);

  ChengZhongRecord getRecord(int id);

  boolean add(ChengZhongRecord record);

}
