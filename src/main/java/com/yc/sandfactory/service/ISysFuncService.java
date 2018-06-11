package com.yc.sandfactory.service;

import com.yc.sandfactory.entity.SysFunc;

import java.util.List;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/9 上午10:30
 */
public interface ISysFuncService {

    List<SysFunc> queryAll();

    List<SysFunc> queryFuncs(Long userId);
}
