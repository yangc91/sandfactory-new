package com.yc.sandfactory.controller;

import com.yc.sandfactory.bean.ResponseBean;
import com.yc.sandfactory.entity.Dept;
import com.yc.sandfactory.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/5 下午11:22
 */
@RestController
@RequestMapping("/admin/orgdept")
public class DeptController extends BaseController {

        @Autowired
        private IDeptService service;

        @RequestMapping(value = "tree", method = RequestMethod.GET)
        public ResponseBean tree() {
            try {
                List<Dept> list = service.tree();
                return ResponseBean.createSuccess(list);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            return ResponseBean.FAIL;
        }

        @RequestMapping(value = "edit", method = RequestMethod.POST)
        public ResponseBean edit(@RequestBody Dept dept) {
            try {
                if(service.editSave(dept)){
                    return ResponseBean.SUCCESS;
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            return ResponseBean.FAIL;
        }

        @RequestMapping(value = "del/{deptId}", method = RequestMethod.GET)
        public ResponseBean del(@PathVariable int deptId) {
            if(service.getPersonSizeOfDept(deptId) > 0) {

                return ResponseBean.createError("部门下存在人员，请先移除人员");
            }
            if(service.getChildDeptSize(deptId) > 0) {
                return ResponseBean.createError("部门下存在子部门，请先移除子部门");
            }
            service.delete(deptId);
            return ResponseBean.SUCCESS;
        }

        @RequestMapping(value = "add", method = RequestMethod.POST)
        public ResponseBean add(@RequestBody Dept dept) {
            if(this.service.add(dept)) {
                return ResponseBean.SUCCESS;
            } else {
                return ResponseBean.createError("部门数量超出限制，无法添加");
            }
        }

}
