package com.yc.sandfactory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.config.SysCons;
import com.yc.sandfactory.entity.Video;
import com.yc.sandfactory.service.ISystemLogService;
import com.yc.sandfactory.service.IVideoService;
import com.yc.sandfactory.util.Constants;
import com.yc.sandfactory.util.JsonMapperProvide;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
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
@RequestMapping("admin/video")
public class VideoController extends BaseController {

  public Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private IVideoService videoService;

  @Autowired
  private ISystemLogService systemLogService;

  @Autowired
  private SysCons sysCons;

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
      systemLogService.addLog(Constants.ENUM_LOG_TYPE.videoManagerLog, "删除监控【 " + id + "】成功");
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
      systemLogService.addLog(Constants.ENUM_LOG_TYPE.videoManagerLog,"添加监控【 " + video.getName() + "】成功");
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
      systemLogService.addLog(Constants.ENUM_LOG_TYPE.videoManagerLog,"修改监控【 " + video.getName() + "】成功");
    } catch (Exception e) {
      logger.error("更新监控出错", e);
    }
    return result;
  }

  @RequestMapping(value = "/getHkToken")
  public Object getHkToken() throws Exception {
    logger.info("获取hk单点登录token");

    DefaultHttpClient httpclient =  new DefaultHttpClient();
    httpclient.setRedirectStrategy(new RedirectStrategy() {	//设置重定向处理方式

      @Override
      public boolean isRedirected(HttpRequest arg0,
          HttpResponse arg1, HttpContext arg2)
          throws ProtocolException {
        return false;
      }

      @Override
      public HttpUriRequest getRedirect(HttpRequest arg0,
          HttpResponse arg1, HttpContext arg2)
          throws ProtocolException {
        return null;
      }
    });

    HttpPost httpPost = new HttpPost("http://" +sysCons.getIvmIp() +":"+ sysCons.getIvmport()+"/home/login?service=http%3A%2F%2F120.194.171.198%3A8900%2Fhome%2Findex.action");
    List<NameValuePair> nvps = new ArrayList<>();
    nvps.add(new BasicNameValuePair("username", sysCons.getIvmName()));
    nvps.add(new BasicNameValuePair("password", sysCons.getIvmPwd()));
    nvps.add(new BasicNameValuePair("pwdLevel", "2"));
    nvps.add(new BasicNameValuePair("loginWay", "1"));
    nvps.add(new BasicNameValuePair("clientIP", "1.193.118.176"));
    nvps.add(new BasicNameValuePair("serviceIP", "1.193.118.176"));
    nvps.add(new BasicNameValuePair("codeId", "f3395e1c-5216-4740-a2dd-835f9f2e67d5"));
    nvps.add(new BasicNameValuePair("vCode", "3e3a29a2-437f-48c3-83cd-fe2e6ed9cb80"));
    nvps.add(new BasicNameValuePair("loginType", "3"));
    nvps.add(new BasicNameValuePair("eventId", "submit"));
    nvps.add(new BasicNameValuePair("clientMAC", "00-50-56-C0-00-01"));

    // form请求
    httpPost.setEntity(new UrlEncodedFormEntity(nvps));

    CloseableHttpResponse response = httpclient.execute(httpPost);

    int statusCode = response.getStatusLine().getStatusCode();

    Header[] headers = response.getAllHeaders();
    for (Header he: headers) {
      logger.info("单点登录响应header:---name: {},  value: {} ", he.getName(), he.getValue());
    }
    EntityUtils.consume(response.getEntity());
    String castgc = null;
    for (Header heder: headers) {
      if(StringUtils.isNotBlank(heder.getValue()) && heder.getValue().contains("ISMS_8700_CASTGC")) {
        castgc = heder.getValue().split("=")[1].split(";")[0];
      }
    }
    EntityUtils.consume(response.getEntity());
    Map<String, Object> result = new HashMap<>();
    result.put("ISMS_8700_CASTGC", castgc);
    result.put("ivmName", sysCons.getIvmName());
    result.put("ivmIp", sysCons.getIvmIp());
    result.put("ivmIpOut", sysCons.getIvmIpOut());
    result.put("ivmPort", sysCons.getIvmport());

    return ResponseBean.createSuccess(result);

  }
}
