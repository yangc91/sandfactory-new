package com.yc.sandfactory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.entity.ChengZhongRecord;
import com.yc.sandfactory.service.IChengZhongService;
import com.yc.sandfactory.util.DateTimeUtil;
import com.yc.sandfactory.util.JsonMapperProvide;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yc
 * @date: 2018-8-25.
 */
@RestController
@RequestMapping("admin/public")
public class DownloadController extends BaseController {

  @Autowired
  private IChengZhongService chengZhongService;

  @RequestMapping(value = "/export")
  public void export(String startTime, String endTime, ChengZhongRecord condition,
      HttpServletResponse response)
      throws JsonProcessingException {
    logger.info("调用称重export请求的输入参数：recodRequestBean：{}",
        JsonMapperProvide.alwaysMapper().writeValueAsString(condition)
    );

    try {
      Pagination<ChengZhongRecord>
          pagination =
          chengZhongService.queryRecordForPage(startTime, endTime, condition, 1, Integer.MAX_VALUE);
      createExcel(pagination.getList(), response);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
  }

  private void createExcel(List<ChengZhongRecord> list, HttpServletResponse response)
      throws IOException {
    Date date = new Date();

    String fileName = DateTimeUtil.dateToStr(date, "yyyyMMdd") + "-称重数据";
    BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
    response.setContentType("application/x-msdownload");
    response.setHeader("Content-Disposition",
        "attachment; filename=" + new String(fileName.getBytes("UTF-8"), "utf-8"));
    // 创建一个Excel文件
    HSSFWorkbook workbook = new HSSFWorkbook();
    // 创建一个工作表
    HSSFSheet sheet = workbook.createSheet("称重数据");

    // 默认列宽
    sheet.setDefaultColumnWidth(20);

    // 添加表头行
    HSSFRow hssfRow = sheet.createRow(0);
    // 设置单元格格式居中
    HSSFCellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

    // 添加表头内容
    HSSFCell headCell = hssfRow.createCell(0);
    headCell.setCellValue("沙场");
    headCell.setCellStyle(cellStyle);

    headCell = hssfRow.createCell(1);
    headCell.setCellValue("票据编号");
    headCell.setCellStyle(cellStyle);

    headCell = hssfRow.createCell(2);
    headCell.setCellValue("车辆号码");
    headCell.setCellStyle(cellStyle);

    headCell = hssfRow.createCell(3);
    headCell.setCellValue("货物名称");
    headCell.setCellStyle(cellStyle);

    headCell = hssfRow.createCell(4);
    headCell.setCellValue("毛重");
    headCell.setCellStyle(cellStyle);

    headCell = hssfRow.createCell(5);
    headCell.setCellValue("净重");
    headCell.setCellStyle(cellStyle);

    headCell = hssfRow.createCell(6);
    headCell.setCellValue("金额");
    headCell.setCellStyle(cellStyle);

    headCell = hssfRow.createCell(7);
    headCell.setCellValue("司机");
    headCell.setCellStyle(cellStyle);

    headCell = hssfRow.createCell(8);
    headCell.setCellValue("日期");
    headCell.setCellStyle(cellStyle);

    // 统计数据
    int totalNo = list.size();
    float totalWeight = 0;
    // 河沙
    int hshaNo = 0;
    float hshaWeight = 0;
    // 砂石
    int sshiNo = 0;
    float sshiWeight = 0;

    // 添加数据内容
    for (int i = 0; i < list.size(); i++) {
      hssfRow = sheet.createRow(i + 1);
      ChengZhongRecord record = list.get(i);

      if("河沙".equals(record.getHm())) {
        hshaNo++;
        hshaWeight += record.getJz();
      } else {
        sshiNo++;
        sshiWeight += record.getJz();
      }
      totalWeight += record.getJz();

      // 创建单元格，并设置值
      HSSFCell cell = hssfRow.createCell(0);
      cell.setCellValue(record.getSandName());
      cell.setCellStyle(cellStyle);

      cell = hssfRow.createCell(1);
      cell.setCellValue(record.getXh());
      cell.setCellStyle(cellStyle);

      cell = hssfRow.createCell(2);
      cell.setCellValue(record.getCh());
      cell.setCellStyle(cellStyle);

      cell = hssfRow.createCell(3);
      cell.setCellValue(record.getHm());
      cell.setCellStyle(cellStyle);

      cell = hssfRow.createCell(4);
      cell.setCellValue(folatTo2Str(record.getMz()));
      cell.setCellStyle(cellStyle);

      cell = hssfRow.createCell(5);
      cell.setCellValue(folatTo2Str(record.getJz()));
      cell.setCellStyle(cellStyle);

      cell = hssfRow.createCell(6);
      cell.setCellValue(folatTo2Str(record.getJe()));
      cell.setCellStyle(cellStyle);

      cell = hssfRow.createCell(7);
      cell.setCellValue(record.getSiji());
      cell.setCellStyle(cellStyle);

      cell = hssfRow.createCell(8);
      cell.setCellValue(record.getMzsj());
      cell.setCellStyle(cellStyle);
    }

    /**
     *    --- | 车数 | 重量
     *    总数|
     *    河沙|
     *    砂石|
     */
    // 车辆数据
    hssfRow = sheet.createRow(list.size() + 3);
    // 创建单元格，并设置值
    HSSFCell headCell2 = hssfRow.createCell(1);
    headCell2.setCellValue("车数");
    headCell2.setCellStyle(cellStyle);

    HSSFCell headCell3 = hssfRow.createCell(2);
    headCell3.setCellValue("重量");
    headCell3.setCellStyle(cellStyle);

    hssfRow = sheet.createRow(list.size() + 4);
    // 创建单元格，并设置值
    HSSFCell totalCell = hssfRow.createCell(0);
    totalCell.setCellValue("总数");
    totalCell.setCellStyle(cellStyle);

    HSSFCell totalCell2 = hssfRow.createCell(1);
    totalCell2.setCellValue(totalNo + "量");
    totalCell2.setCellStyle(cellStyle);

    HSSFCell totalCell3 = hssfRow.createCell(2);
    totalCell3.setCellValue(folatTo2Str(totalWeight) + "t");
    totalCell3.setCellStyle(cellStyle);

    // 河沙
    hssfRow = sheet.createRow(list.size() + 5);
    // 创建单元格，并设置值
    HSSFCell hshaCell = hssfRow.createCell(0);
    hshaCell.setCellValue("河沙");
    hshaCell.setCellStyle(cellStyle);

    HSSFCell weightHeadCell2 = hssfRow.createCell(1);
    weightHeadCell2.setCellValue(hshaNo + "量");
    weightHeadCell2.setCellStyle(cellStyle);

    HSSFCell weightHeadCell3 = hssfRow.createCell(2);
    weightHeadCell3.setCellValue(folatTo2Str(hshaWeight) + "t");
    weightHeadCell3.setCellStyle(cellStyle);

    // 砂石
    hssfRow = sheet.createRow(list.size() + 6);
    // 创建单元格，并设置值
    HSSFCell sshiCell = hssfRow.createCell(0);
    sshiCell.setCellValue("砂石");
    sshiCell.setCellStyle(cellStyle);

    HSSFCell sshiCell2 = hssfRow.createCell(1);
    sshiCell2.setCellValue(sshiNo + "量");
    sshiCell2.setCellStyle(cellStyle);

    HSSFCell sshiCell3 = hssfRow.createCell(2);
    sshiCell3.setCellValue(folatTo2Str(sshiWeight) + "t");
    sshiCell3.setCellStyle(cellStyle);

    // 保存Excel文件
    try {
      workbook.write(fout);
      fout.flush();
      fout.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String folatTo2Str(Float number) {
    DecimalFormat df = new DecimalFormat("0.00");
    return df.format(number);
  }
}