package com.yc.sandfactory.service.impl;

import com.yc.sandfactory.bean.Pagination;
import com.yc.sandfactory.entity.Video;
import com.yc.sandfactory.service.IVideoService;
import org.apache.commons.lang3.StringUtils;
import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project: sandfactory
 * @author: yc
 */
@Service
public class VideoServiceImpl implements IVideoService {

  @Autowired
  private NutDao nutDao;

  @Override
  public Pagination<Video> queryForPage(Video video, String searchKey, Integer pageNo, Integer pageSize) {
    Pager pager = nutDao.createPager(pageNo, pageSize);

    Criteria cri = Cnd.cri();

    // 名称
    if (StringUtils.isNotBlank(searchKey)) {
      cri.where().and("name", "like", "%"+ searchKey +"%");
    }

    cri.getOrderBy().desc("id");

    List<Video> list = nutDao.query(Video.class, cri, pager);
    int count = nutDao.count(Video.class, cri);

    Pagination pagination = new Pagination();
    pagination.setList(list);
    pagination.setTotal(count);

    return pagination;
  }

  @Override
  public Video get(long id) {
    return nutDao.fetch(Video.class, id);
  }

  @Override
  public void del(long id) {
    nutDao.delete(Video.class, id);
  }

  @Override
  public Video add(Video video) {
    return nutDao.insert(video);
  }

  @Override
  public void update(Video video) {
     nutDao.update(video);
  }
}
