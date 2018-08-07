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

  Pagination<ChengZhongRecord> queryRecordForPage(String startTime, String endTime, ChengZhongRecord chengZhongRecord, Integer pageNo, Integer pageSize, String searchKey);

  ChengZhongRecord getRecord(int id);

  boolean add(ChengZhongRecord record);

  /**
   * 统计一段时间内的称重数量
   * @param startTime
   * @param endTime
   * @return
   */
  Integer countRecordNo(String startTime, String endTime);

  /**
   * 统计一段时间内的总重量（实重）
   * @param startTime
   * @param endTime
   * @return
   */
  Float countRecordWeight(String startTime, String endTime);

}
