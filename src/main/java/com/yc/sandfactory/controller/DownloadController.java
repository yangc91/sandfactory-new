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

    // 添加数据内容
    for (int i = 0; i < list.size(); i++) {
      hssfRow = sheet.createRow((int) i + 1);
      ChengZhongRecord record = list.get(i);

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