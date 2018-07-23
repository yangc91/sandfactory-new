package com.yc.sandfactory.service.impl;

import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.entity.SysUser;
import com.yc.sandfactory.entity.SystemLog;
import com.yc.sandfactory.service.ISystemLogService;
import com.yc.sandfactory.util.Constants;
import com.yc.sandfactory.util.DateTimeUtil;
import com.yc.sandfactory.util.UserUtil;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @project: sandfactory
 * @author: yc
 */
@Service
public class SystemLogServiceImpl implements ISystemLogService {

  @Autowired
  private NutDao nutDao;

  @Override
  public Pagination<SystemLog> queryForPage(String startTime, String endTime,
                                            String action, String search, Integer pageNo, Integer pageSize) {
    Pager pager = nutDao.createPager(pageNo, pageSize);

    Criteria cri = Cnd.cri();

    if (StringUtils.isNotBlank(startTime)) {
      cri.where().and("time", ">=", DateTimeUtil.dateTimeStrToLong(startTime + " 00:00:00"));
    }

    if (StringUtils.isNotBlank(endTime)) {
      cri.where().and("time", "<", DateTimeUtil.dateTimeStrToLong(endTime + " 23:59:59"));
    }

    if (StringUtils.isNotBlank(action)) {
      cri.where().andEquals("action", action);
    }

    if (StringUtils.isNotBlank(search)) {
      cri.where().andLike("content", '%' + search + '%');
    }

    cri.getOrderBy().desc("time");

    List<SystemLog> list = nutDao.query(SystemLog.class, cri, pager);
    int count = nutDao.count(SystemLog.class, cri);

    Pagination pagination = new Pagination();
    pagination.setList(list);
    pagination.setTotal(count);
    return pagination;
  }

  @Override
  public void addLog(Constants.ENUM_LOG_TYPE logType, String content) {
    SysUser user = UserUtil.currentUser();
    SystemLog systemLog = new SystemLog();
    systemLog.setManagerId(user.getId());
    systemLog.setManagerName(user.getName());
    systemLog.setManagerIp(user.getCurIp());
    systemLog.setContent(content);
    systemLog.setTime(System.currentTimeMillis());
    systemLog.setAction(String.valueOf(logType.value));
    nutDao.insert(systemLog);
  }
}
