/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : sf

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-06-13 00:40:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_cz_record
-- ----------------------------
DROP TABLE IF EXISTS `t_cz_record`;
CREATE TABLE `t_cz_record` (
  `n_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `c_sand_name` varchar(50) DEFAULT NULL COMMENT '沙场名称',
  `c_work_name` varchar(50) DEFAULT NULL COMMENT '工作站名称',
  `c_truck_name` varchar(50) DEFAULT NULL COMMENT '地磅名称',
  `c_xh` varchar(20) DEFAULT NULL COMMENT '序号(票据编号)',
  `c_ch` varchar(20) DEFAULT NULL COMMENT '车号(车辆号码)',
  `c_hm` varchar(50) DEFAULT NULL COMMENT '货名（货物名称）',
  `c_fh` varchar(50) DEFAULT NULL COMMENT '发货',
  `c_sh` varchar(50) DEFAULT NULL COMMENT '收货',
  `c_gg` varchar(50) DEFAULT NULL COMMENT '规格',
  `c_by2` varchar(100) DEFAULT NULL COMMENT '备用2',
  `c_crlx` varchar(50) DEFAULT NULL COMMENT '出入类型',
  `n_mz` float DEFAULT '0' COMMENT '毛重',
  `n_pz` float DEFAULT '0' COMMENT '皮重',
  `n_jz` float DEFAULT '0' COMMENT '净重',
  `n_kz` float DEFAULT NULL COMMENT '扣杂 扣重',
  `n_kl` float DEFAULT NULL COMMENT '扣率',
  `n_dj` float DEFAULT NULL COMMENT '单价',
  `n_je` float DEFAULT NULL COMMENT '金额',
  `c_by3` varchar(50) DEFAULT NULL COMMENT '备用3',
  `c_by4` varchar(50) DEFAULT NULL COMMENT '备用4',
  `c_siji` varchar(50) DEFAULT NULL COMMENT '司机',
  `c_jb` varchar(50) DEFAULT NULL COMMENT '监磅',
  `c_rq` varchar(50) DEFAULT NULL COMMENT '日期',
  `c_shijian` varchar(50) DEFAULT NULL COMMENT '时间',
  `c_th` varchar(50) DEFAULT NULL COMMENT '台号',
  `c_czy` varchar(50) DEFAULT NULL COMMENT '操作员',
  `c_bz` varchar(50) DEFAULT NULL COMMENT '备注',
  `c_mzsj` varchar(50) DEFAULT NULL COMMENT '毛重时间',
  `c_pzsj` varchar(50) DEFAULT NULL COMMENT '皮重时间',
  `c_sc` varchar(50) DEFAULT NULL COMMENT '上传',
  `c_dy` varchar(50) DEFAULT NULL COMMENT '打印',
  `n_jz1` float DEFAULT NULL COMMENT '净重1',
  `n_kzxs` float DEFAULT NULL COMMENT '扣杂系数',
  `n_klxs` float DEFAULT NULL COMMENT '扣率系数',
  `c_js` varchar(50) DEFAULT NULL COMMENT '结算',
  `c_jsbh` varchar(50) DEFAULT NULL COMMENT '结算编号',
  `c_czy1` varchar(50) DEFAULT NULL COMMENT '操作员1',
  `c_kp` varchar(50) DEFAULT NULL COMMENT '开票',
  `c_ycrq` varchar(50) DEFAULT NULL COMMENT '一次日期',
  `c_th1` varchar(50) DEFAULT NULL COMMENT '台号1',
  `n_yk` float DEFAULT NULL COMMENT '余款',
  `c_trace_img1` mediumtext COMMENT '皮重照片',
  `c_trace_img2` mediumtext,
  `c_trace_img3` mediumtext,
  `c_trace_img4` mediumtext,
  `c_gross_img1` mediumtext COMMENT '毛重照片1',
  `c_gross_img2` mediumtext,
  `c_gross_img3` mediumtext,
  `c_gross_img4` mediumtext,
  `n_sz` float DEFAULT NULL COMMENT '实重 kg',
  `n_zfxs` float DEFAULT NULL COMMENT '折方系数',
  `n_fl` float DEFAULT NULL COMMENT '方量',
  `n_gbf` float DEFAULT NULL COMMENT '过磅费',
  `c_mzsby` varchar(255) DEFAULT NULL COMMENT '毛重司磅员',
  `c_pzsby` varchar(255) DEFAULT NULL COMMENT '皮重司磅员',
  `c_mzbh` varchar(255) DEFAULT NULL COMMENT '毛重磅号',
  `c_pzbh` varchar(255) DEFAULT NULL COMMENT '皮重磅号',
  `ecrq` varchar(255) DEFAULT NULL COMMENT '二次过磅时间 yyyy-MM-dd HH:mm:ss',
  `c_gxsj` varchar(255) DEFAULT NULL COMMENT '更新时间 yyyy-MM-dd HH:mm:ss',
  `c_by1` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_cz_record
-- ----------------------------
INSERT INTO `t_cz_record` VALUES ('1', '沙场1', '站点1', '地磅1', 'C011511190001', '豫A12354', '铝凡土', '', '郑州爱科电子科技有限公司', '', '', '出厂', '589163', '499257', '89906', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '20:43:01', '1', '原野', '', '2015-11-19 20:43:00', '2015-11-19 17:45:07', '否        ', '否', '89906', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('2', '沙场1', '站点1', '地磅1', 'C011511190002', '沪34455', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '462980', '408761', '54219', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '20:43:24', '1', '原野', '', '2015-11-19 20:43:23', '2015-11-19 17:46:11', '否        ', '是', '54219', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('3', '沙场1', '站点1', '地磅1', 'C011511190003', '3434', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '258442', '226866', '31576', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '20:48:18', '1', '原野', '', '2015-11-19 20:46:26', '2015-11-19 20:48:17', '否        ', '否', '31576', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('4', '沙场1', '站点1', '地磅1', 'C011511190004', '豫2356', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '916164', '226866', '689298', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '20:58:45', '1', '原野', '', '2015-11-19 20:56:01', '2015-11-19 20:58:44', '否        ', '否', '689298', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('5', '沙场1', '站点1', '地磅1', 'C011511190005', '津13556', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '627642', '226866', '400776', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '21:02:17', '1', '原野', '', '2015-11-19 20:59:47', '2015-11-19 21:02:16', '否        ', '否', '400776', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('6', '沙场1', '站点1', '地磅1', 'C011511190006', '豫235', '铝凡土', '郑州爱科电子科技有限公司', '', '65656', '', '出厂', '583359', '226866', '356493', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '21:05:16', '1', '原野', '', '2015-11-19 21:03:36', '2015-11-19 21:05:14', '否        ', '否', '356493', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('7', '沙场1', '站点1', '地磅1', 'C011511190007', '豫1244', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '790480', '627642', '162838', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '21:08:09', '1', '原野', '', '2015-11-19 21:08:07', '2015-11-19 21:06:21', '否        ', '否', '162838', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('8', '沙场1', '站点1', '地磅1', 'C011511190008', '甘2456', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '509720', '278280', '231440', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '21:12:57', '1', '原野', '', '2015-11-19 21:12:56', '2015-11-19 21:11:26', '否        ', '否', '231440', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('9', '沙场1', '站点1', '地磅1', 'C011511190009', '豫1345', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '928786', '226866', '701920', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '21:21:25', '1', '原野', '', '2015-11-19 21:21:23', '2015-11-19 21:17:59', '否        ', '否', '701920', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('10', '沙场1', '站点1', '地磅1', 'C011511190010', '豫23456', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '916164', '849100', '67064', '0', '0', '0', '0', '', '', '', '', '2015-11-20', '21:23:36', '1', '原野', '', '2015-11-19 21:22:56', '2015-11-20 21:23:35', '否        ', '否', '67064', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('11', '沙场1', '站点1', '地磅1', 'C011511190011', '豫2357', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '984046', '589163', '394883', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '21:32:24', '1', '原野', '', '2015-11-19 21:31:12', '2015-11-19 21:32:23', '否        ', '是', '394883', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('12', '沙场1', '站点1', '地磅1', 'C011511190012', '津1245', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '543177', '462980', '80197', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '21:34:59', '1', '原野', '', '2015-11-19 21:34:58', '2015-11-19 21:33:52', '否        ', '否', '80197', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('13', '沙场1', '站点1', '地磅1', 'C011511190013', 'RET', 'ewt', 'e', 'wt', 'tr', '', '出厂', '278280', '259061', '19219', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '21:37:34', '1', '原野', '', '2015-11-19 21:37:33', '2015-11-19 21:35:33', '否        ', '否', '19219', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('14', '沙场1', '站点1', '地磅1', 'C011511190014', '54545', '铝凡土', '545', '5', '54', '', '出厂', '657055', '462980', '194075', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '21:46:32', '1', '原野', '', '2015-11-19 21:42:30', '2015-11-19 21:46:31', '否        ', '否', '194075', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('15', '沙场1', '站点1', '地磅1', 'C011511190015', '豫1234', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '928786', '226866', '701920', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '21:58:26', '1', '原野', '', '2015-11-19 21:58:25', '2015-11-19 21:45:46', '否        ', '否', '701920', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('16', '沙场1', '站点1', '地磅1', 'C011511190016', '豫255', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '544014', '499257', '44757', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '22:01:40', '1', '原野', '', '2015-11-19 22:01:39', '2015-11-19 21:59:25', '否        ', '否', '44757', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('17', '沙场1', '站点1', '地磅1', 'C011511190017', '黑123', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '462980', '412355', '50625', '0', '0', '0', '0', '', '', '', '', '2015-11-19', '22:05:49', '1', '原野', '', '2015-11-19 22:05:48', '2015-11-19 21:59:44', '否        ', '否', '50625', '0', '0', '否', '                    ', null, '否', '2015-11-19', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('18', '沙场1', '站点1', '地磅1', 'C011511220001', '豫236', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '497071', '462980', '34091', '0', '0', '0', '0', '', '', '', '', '2015-11-22', '12:58:00', '1', '原野', '', '2015-11-22 12:57:59', '2015-11-22 12:56:26', '否        ', '否', '34091', '0', '0', '否', '                    ', null, '否', '2015-11-22', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('19', '沙场1', '站点1', '地磅1', 'C011511220002', '豫A1245', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '827899', '297258', '530641', '0', '0', '0', '0', '', '', '', '', '2015-11-22', '12:58:35', '1', '原野', '', '2015-11-22 12:58:34', '2015-11-22 12:56:55', '否        ', '否', '530641', '0', '0', '否', '                    ', null, '否', '2015-11-22', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('20', '沙场1', '站点1', '地磅1', 'C011511220003', '黑A1234', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '499257', '119544', '379713', '0', '0', '0', '0', '', '', '', '', '2015-11-22', '12:58:57', '1', '原野', '', '2015-11-22 12:58:56', '2015-11-22 12:57:24', '否        ', '是', '379713', '0', '0', '否', '                    ', null, '否', '2015-11-22', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('21', '沙场1', '站点1', '地磅1', 'C011511220004', '黑1234', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '790480', '226866', '563614', '0', '0', '0', '0', '', '', '', '', '2015-11-22', '13:07:06', '1', '原野', '', '2015-11-22 13:07:04', '2015-11-22 13:05:00', '否        ', '否', '563614', '0', '0', '否', '                    ', null, '否', '2015-11-22', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('22', '沙场1', '站点1', '地磅1', 'C011511220005', '豫12345', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '543177', '278280', '264897', '0', '0', '0', '0', '', '', '', '', '2015-11-22', '13:19:01', '1', '原野', '', '2015-11-22 13:09:21', '2015-11-22 13:18:45', '否        ', '否', '264897', '0', '0', '否', '                    ', null, '否', '2015-11-22', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('23', '沙场1', '站点1', '地磅1', 'C011511220006', '豫A561A', '铝凡土', '郑州爱科电子科技有限公司', '', '规格', '', '出厂', '462980', '226866', '236114', '0', '0', '0', '0', '', '', '', '', '2015-11-22', '13:26:15', '1', '原野', '', '2015-11-22 13:26:13', '2015-11-22 13:20:52', '否        ', '否', '236114', '0', '0', '否', '                    ', null, '否', '2015-11-22', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('24', '沙场1', '站点1', '地磅1', 'C011511230002', '豫A2345', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '634191', '604323', '29868', '0', '0', '0', '0', '', '', '', '', '2015-11-23', '18:35:25', '1', '原野', '', '2015-11-23 18:33:59', '2015-11-23 18:35:24', '否        ', '是', '29868', '0', '0', '否', '                    ', null, '否', '2015-11-23', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('25', '沙场1', '站点1', '地磅1', 'C011511230001', '豫A1234', '铝凡土', '郑州爱科电子科技有限公司', '', '43434', '', '出厂', '850023', '589163', '260860', '0', '0', '0', '0', '', '', '', '', '2015-11-23', '18:34:37', '1', '原野', '', '2015-11-23 18:34:36', '2015-11-23 18:30:24', '否        ', '是', '260860', '0', '0', '否', '                    ', null, '否', '2015-11-23', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('26', '沙场1', '站点1', '地磅1', 'C011511240001', '川A2344', '铝凡土', '铝土矿1', '加工点', '', '', '出厂', '814490', '627642', '186848', '0', '0', '0', '0', '', '', '', '', '2015-11-24', '21:55:21', '1', '原野', '', '2015-11-24 21:52:17', '2015-11-24 21:55:20', '否        ', '是', '186848', '0', '0', '否', '                    ', null, '否', '2015-11-24', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('27', '沙场1', '站点1', '地磅1', 'C011511240002', '豫KA2334', '铝凡土', '郑州爱科电子科技有限公司', '', '', '', '出厂', '928786', '226866', '701920', '0', '0', '0', '0', '', '', '', '', '2015-11-24', '22:16:11', '1', '原野', '', '2015-11-24 22:16:10', '2015-11-24 21:52:48', '否        ', '是', '701920', '0', '0', '否', '                    ', null, '否', '2015-11-24', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('28', '沙场1', '站点1', '地磅1', 'C011511240003', '豫A1255', '铝凡土', '铝土矿1', '加工点', '', '', '出厂', '791464', '226866', '564598', '0', '0', '0', '0', '', '', '', '', '2015-11-24', '22:19:15', '1', '001', '', '2015-11-24 22:19:13', '2015-11-24 22:17:47', '否        ', '是', '564598', '0', '0', '否', '                    ', null, '否', '2015-11-24', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('29', '沙场1', '站点1', '地磅1', 'C011511240004', '豫12456', '铝凡土', '铝土矿1', '加工点', '', '', '出厂', '192307', '137688', '54619', '0', '0', '0', '0', '', '', '', '', '2015-11-24', '22:22:07', '1', '001', '', '2015-11-24 22:20:46', '2015-11-24 22:22:06', '否        ', '是', '54619', '0', '0', '否', '                    ', null, '否', '2015-11-24', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('30', '沙场1', '站点1', '地磅1', 'C011511240005', '豫A561A', '铝凡土', '铝土矿1', '加工点加工点加工点加工点', '', '', '出厂', '790480', '462980', '327500', '0', '0', '0', '0', '', '', '', '', '2015-11-24', '22:38:47', '1', '原野', '', '2015-11-24 22:37:38', '2015-11-24 22:38:45', '否        ', '是', '327500', '0', '0', '否', '                    ', null, '否', '2015-11-24', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('31', '沙场1', '站点1', '地磅1', 'C011511250002', '豫B4577', '铝凡土', '铝土矿1', '加工点', '', '', '出厂', '627642', '462980', '164662', '0', '0', '0', '0', '', '', '', '', '2015-11-25', '21:05:34', '1', '001', '', '2015-11-25 21:00:13', '2015-11-25 21:05:33', '否        ', '是', '164662', '0', '0', '否', '                    ', null, '否', '2015-11-25', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('32', '沙场1', '站点1', '地磅1', 'C011511250001', '豫1245', '铝凡土', '铝土矿2', '加工点', '', '', '出厂', '928786', '226866', '701920', '0', '0', '0', '0', '', '', '', '', '2015-11-25', '21:06:31', '1', '001', '', '2015-11-25 21:06:30', '2015-11-25 20:59:55', '否        ', '是', '701920', '0', '0', '否', '                    ', null, '否', '2015-11-25', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('33', '沙场1', '站点1', '地磅1', 'J031804180001', '123', '铝凡土', '铝土矿1', '', '', '', '进厂', '170', '60', '110', '0', '0', '0', '0', '0', '', '', '', '2018-04-18', '17:34:00', '3', '原野', '', '2018-04-18 17:28:55', '2018-04-18 17:33:59', '否        ', '否', '0', '0', '0', '否', '                    ', null, '否', '2018-04-18', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('34', '沙场1', '站点1', '地磅1', 'J031804180002', '123', '铝凡土', '铝土矿1', '', '', '', '进厂', '100', '90', '10', '0', '0', '0', '0', '0', '', '', '', '2018-04-18', '18:02:11', '3', '原野', '', '2018-04-18 18:02:10', '2018-04-18 17:58:43', '否        ', '否', '0', '0', '0', '否', '                    ', null, '否', '2018-04-18', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('35', '沙场1', '站点1', '地磅1', 'J031804180003', '123', '铝凡土', '铝土矿1', '', '', '', '进厂', '16840', '16020', '820', '0', '0', '0', '0', '0', '', '', '', '2018-04-18', '18:11:35', '3', '原野', '', '2018-04-18 18:11:34', '2018-04-18 18:04:52', '否        ', '否', '0', '0', '0', '否', '                    ', null, '否', '2018-04-18', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('36', '沙场1', '站点1', '地磅1', 'J031804180004', '123', '铝凡土', '铝土矿1', '', '', '', '进厂', '18110', '60', '18050', '0', '0', '0', '0', '0', '', '', '', '2018-04-18', '18:37:55', '3', '原野', '', '2018-04-18 18:18:56', '2018-04-18 18:37:54', '否        ', '否', '0', '0', '0', '否', '                    ', null, '否', '2018-04-18', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('37', '沙场1', '站点1', '地磅1', 'J031804230001', '123', '铝凡土', '铝土矿1', '', '', '', '进厂', '17980', '60', '17920', '0', '0', '0', '0', '0', '', '', '', '2018-04-23', '14:23:31', '3', '原野', '', '2018-04-23 14:18:00', '2018-04-23 14:23:30', '否        ', '否', '0', '0', '0', '否', '                    ', null, '否', '2018-04-23', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_cz_record` VALUES ('38', '沙场1', '站点1', '地磅1', 'J031804270001', '123', '铝凡土', '铝土矿1', '', '', '', '进厂', '1180', '40', '1140', '0', '0', '0', '0', '0', '', '', '', '2018-04-27', '17:00:42', '3', '001', '', '2018-04-27 16:18:41', '2018-04-27 17:00:41', '否        ', '否', '0', '0', '0', '否', '                    ', null, '否', '2018-04-27', null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `n_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(64) NOT NULL COMMENT '名称',
  `c_code` varchar(64) DEFAULT NULL COMMENT '编号',
  `n_parent_id` bigint(20) DEFAULT NULL COMMENT '上级部门ID',
  `n_sort` int(3) NOT NULL DEFAULT '999' COMMENT '排序',
  `n_create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `n_status` int(1) NOT NULL DEFAULT '1' COMMENT '状态 0-禁用 1-启用',
  `n_update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', '根部门', '00', null, '1', '1528561420149', '1', '1528561420172');
INSERT INTO `t_dept` VALUES ('2', '测试', '00', '1', '1', '1528562186799', '1', '1528562186808');
INSERT INTO `t_dept` VALUES ('3', '测试2', '01', '1', '2', '1528562259181', '1', '1528562259183');
INSERT INTO `t_dept` VALUES ('4', '测试是', '02', '1', '1', '1528562546988', '2', '1528562546994');
INSERT INTO `t_dept` VALUES ('5', '测试3', '00', '2', '3', '1528592809577', '1', '1528592809580');
INSERT INTO `t_dept` VALUES ('6', '测试4', '01', '2', '4', '1528592829262', '1', '1528592829264');

-- ----------------------------
-- Table structure for t_system_log
-- ----------------------------
DROP TABLE IF EXISTS `t_system_log`;
CREATE TABLE `t_system_log` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_manager_id` int(255) DEFAULT NULL COMMENT '操作人id',
  `c_manager_name` varchar(255) DEFAULT NULL COMMENT '操作人名称',
  `c_manager_ip` varchar(255) DEFAULT NULL COMMENT '操作人IP',
  `c_content` varchar(255) DEFAULT NULL COMMENT '日志内容',
  `n_time` bigint(20) DEFAULT NULL COMMENT '日志发生时间:毫秒值',
  `c_action` int(11) DEFAULT NULL COMMENT '日志行为:登录退出：1-登录 2-退出 操作日志：3-人员管理 4-角色管理',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_system_log
-- ----------------------------
INSERT INTO `t_system_log` VALUES ('1', null, null, '0:0:0:0:0:0:0:1', '【admin】登录成功', '1526785283634', '1');
INSERT INTO `t_system_log` VALUES ('2', null, null, '0:0:0:0:0:0:0:1', '【admin】登录成功', '1526785505569', '1');
INSERT INTO `t_system_log` VALUES ('3', null, null, '0:0:0:0:0:0:0:1', '【admin】登录成功', '1526785824881', '1');
INSERT INTO `t_system_log` VALUES ('4', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1526785981157', '1');
INSERT INTO `t_system_log` VALUES ('5', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1526820264957', '1');
INSERT INTO `t_system_log` VALUES ('6', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】注销成功', '1526820487128', '2');
INSERT INTO `t_system_log` VALUES ('7', '2', 'aaaaaa', '0:0:0:0:0:0:0:1', '【aaaa】登录成功', '1526820505680', '1');
INSERT INTO `t_system_log` VALUES ('8', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1526828863069', '1');
INSERT INTO `t_system_log` VALUES ('9', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1526828863338', '1');
INSERT INTO `t_system_log` VALUES ('10', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527079131626', '1');
INSERT INTO `t_system_log` VALUES ('11', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527079131626', '1');
INSERT INTO `t_system_log` VALUES ('12', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527079195061', '1');
INSERT INTO `t_system_log` VALUES ('13', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527079194904', '1');
INSERT INTO `t_system_log` VALUES ('14', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】注销成功', '1527079625150', '2');
INSERT INTO `t_system_log` VALUES ('15', '2', 'aaaaaa', '0:0:0:0:0:0:0:1', '【aaaa】登录成功', '1527079630685', '1');
INSERT INTO `t_system_log` VALUES ('16', '2', 'aaaaaa', '0:0:0:0:0:0:0:1', '【aaaa】注销成功', '1527079637290', '2');
INSERT INTO `t_system_log` VALUES ('17', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527079642764', '1');
INSERT INTO `t_system_log` VALUES ('18', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527080552791', '1');
INSERT INTO `t_system_log` VALUES ('19', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527080635226', '1');
INSERT INTO `t_system_log` VALUES ('20', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527080636428', '1');
INSERT INTO `t_system_log` VALUES ('21', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527080855273', '1');
INSERT INTO `t_system_log` VALUES ('22', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527080855040', '1');
INSERT INTO `t_system_log` VALUES ('23', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081122132', '1');
INSERT INTO `t_system_log` VALUES ('24', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081273185', '1');
INSERT INTO `t_system_log` VALUES ('25', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081273394', '1');
INSERT INTO `t_system_log` VALUES ('26', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081274030', '1');
INSERT INTO `t_system_log` VALUES ('27', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081274292', '1');
INSERT INTO `t_system_log` VALUES ('28', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081634995', '1');
INSERT INTO `t_system_log` VALUES ('29', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081676696', '1');
INSERT INTO `t_system_log` VALUES ('30', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081676909', '1');
INSERT INTO `t_system_log` VALUES ('31', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081677896', '1');
INSERT INTO `t_system_log` VALUES ('32', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081678061', '1');
INSERT INTO `t_system_log` VALUES ('33', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081697296', '1');
INSERT INTO `t_system_log` VALUES ('34', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081773491', '1');
INSERT INTO `t_system_log` VALUES ('35', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527081773490', '1');
INSERT INTO `t_system_log` VALUES ('36', '1', 'admin', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527081846569', '3');
INSERT INTO `t_system_log` VALUES ('37', '1', 'admin', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527082998267', '3');
INSERT INTO `t_system_log` VALUES ('38', '1', 'admin', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527083012132', '3');
INSERT INTO `t_system_log` VALUES ('39', '1', 'admin', '0:0:0:0:0:0:0:1', '添加用户【 123】成功', '1527083333482', '3');
INSERT INTO `t_system_log` VALUES ('40', '1', 'admin', '0:0:0:0:0:0:0:1', '修改用户【 12334】成功', '1527083398118', '3');
INSERT INTO `t_system_log` VALUES ('41', '1', 'admin', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527083471450', '3');
INSERT INTO `t_system_log` VALUES ('42', '1', 'admin', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527083573131', '3');
INSERT INTO `t_system_log` VALUES ('43', '1', 'admin', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527083593773', '3');
INSERT INTO `t_system_log` VALUES ('44', '1', 'admin', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527083742430', '3');
INSERT INTO `t_system_log` VALUES ('45', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527083895468', '1');
INSERT INTO `t_system_log` VALUES ('46', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527083895796', '1');
INSERT INTO `t_system_log` VALUES ('47', '1', 'admin', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527083929081', '3');
INSERT INTO `t_system_log` VALUES ('48', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】注销成功', '1527084153293', '2');
INSERT INTO `t_system_log` VALUES ('49', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527084170410', '1');
INSERT INTO `t_system_log` VALUES ('50', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527084191265', '3');
INSERT INTO `t_system_log` VALUES ('51', '3', '12334', '0:0:0:0:0:0:0:1', '添加用户【 ccc】成功', '1527084228817', '3');
INSERT INTO `t_system_log` VALUES ('52', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 ccc】成功', '1527084234928', '3');
INSERT INTO `t_system_log` VALUES ('53', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527084367791', '1');
INSERT INTO `t_system_log` VALUES ('54', '3', '12334', '0:0:0:0:0:0:0:1', '添加用户【 333】成功', '1527084391365', '3');
INSERT INTO `t_system_log` VALUES ('55', '3', '12334', '0:0:0:0:0:0:0:1', '添加用户【 555】成功', '1527085577567', '3');
INSERT INTO `t_system_log` VALUES ('56', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527085860843', '1');
INSERT INTO `t_system_log` VALUES ('57', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527085872925', '1');
INSERT INTO `t_system_log` VALUES ('58', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527085895286', '1');
INSERT INTO `t_system_log` VALUES ('59', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527085895509', '1');
INSERT INTO `t_system_log` VALUES ('60', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527085925708', '1');
INSERT INTO `t_system_log` VALUES ('61', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527085925708', '1');
INSERT INTO `t_system_log` VALUES ('62', '1', 'admin', '0:0:0:0:0:0:0:1', '添加用户【 666】成功', '1527086011396', '3');
INSERT INTO `t_system_log` VALUES ('63', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527086526752', '1');
INSERT INTO `t_system_log` VALUES ('64', '3', '12334', '0:0:0:0:0:0:0:1', '添加用户【 777】成功', '1527086567550', '3');
INSERT INTO `t_system_log` VALUES ('65', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527086630445', '3');
INSERT INTO `t_system_log` VALUES ('66', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527086763370', '1');
INSERT INTO `t_system_log` VALUES ('67', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527086796801', '3');
INSERT INTO `t_system_log` VALUES ('68', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527086862302', '3');
INSERT INTO `t_system_log` VALUES ('69', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527087609230', '3');
INSERT INTO `t_system_log` VALUES ('70', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527087636363', '3');
INSERT INTO `t_system_log` VALUES ('71', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527087706965', '3');
INSERT INTO `t_system_log` VALUES ('72', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527087788648', '3');
INSERT INTO `t_system_log` VALUES ('73', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】注销成功', '1527087931410', '2');
INSERT INTO `t_system_log` VALUES ('74', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527087938158', '1');
INSERT INTO `t_system_log` VALUES ('75', '1', 'admin', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527087961199', '3');
INSERT INTO `t_system_log` VALUES ('76', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527088852385', '1');
INSERT INTO `t_system_log` VALUES ('77', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaa】成功', '1527088941679', '3');
INSERT INTO `t_system_log` VALUES ('78', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527090159647', '1');
INSERT INTO `t_system_log` VALUES ('79', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaaa】成功', '1527090291294', '3');
INSERT INTO `t_system_log` VALUES ('80', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaaa】成功', '1527090310143', '3');
INSERT INTO `t_system_log` VALUES ('81', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527091087961', '1');
INSERT INTO `t_system_log` VALUES ('82', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 777】成功', '1527091135991', '3');
INSERT INTO `t_system_log` VALUES ('83', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】注销成功', '1527091173824', '2');
INSERT INTO `t_system_log` VALUES ('84', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527091177131', '1');
INSERT INTO `t_system_log` VALUES ('85', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 555】成功', '1527091197408', '3');
INSERT INTO `t_system_log` VALUES ('86', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527091225250', '1');
INSERT INTO `t_system_log` VALUES ('87', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527091266714', '1');
INSERT INTO `t_system_log` VALUES ('88', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaaa】成功', '1527091323148', '3');
INSERT INTO `t_system_log` VALUES ('89', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】注销成功', '1527091331415', '2');
INSERT INTO `t_system_log` VALUES ('90', '8', '777', '0:0:0:0:0:0:0:1', '【777】登录成功', '1527091339833', '1');
INSERT INTO `t_system_log` VALUES ('91', '8', '777', '0:0:0:0:0:0:0:1', '修改用户【 777】成功', '1527091348336', '3');
INSERT INTO `t_system_log` VALUES ('92', '8', '777', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaaa】成功', '1527091366503', '3');
INSERT INTO `t_system_log` VALUES ('93', '8', '777', '0:0:0:0:0:0:0:1', '【777】登录成功', '1527091410893', '1');
INSERT INTO `t_system_log` VALUES ('94', '8', '777', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaaa】成功', '1527091420354', '3');
INSERT INTO `t_system_log` VALUES ('95', '8', '777', '0:0:0:0:0:0:0:1', '【777】注销成功', '1527091578505', '2');
INSERT INTO `t_system_log` VALUES ('96', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527091583277', '1');
INSERT INTO `t_system_log` VALUES ('97', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaaa】成功', '1527091625664', '3');
INSERT INTO `t_system_log` VALUES ('98', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527091906573', '1');
INSERT INTO `t_system_log` VALUES ('99', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】注销成功', '1527092010574', '2');
INSERT INTO `t_system_log` VALUES ('100', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527092136006', '1');
INSERT INTO `t_system_log` VALUES ('101', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaaa】成功', '1527092156112', '3');
INSERT INTO `t_system_log` VALUES ('102', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】注销成功', '1527092256498', '2');
INSERT INTO `t_system_log` VALUES ('103', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527092259925', '1');
INSERT INTO `t_system_log` VALUES ('104', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaaa】成功', '1527092400229', '3');
INSERT INTO `t_system_log` VALUES ('105', '3', '12334', '0:0:0:0:0:0:0:1', '【1234】登录成功', '1527092579891', '1');
INSERT INTO `t_system_log` VALUES ('106', '3', '12334', '0:0:0:0:0:0:0:1', '修改用户【 aaaaaaa】成功', '1527092616303', '3');
INSERT INTO `t_system_log` VALUES ('107', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527382540863', '1');
INSERT INTO `t_system_log` VALUES ('108', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527382541010', '1');
INSERT INTO `t_system_log` VALUES ('109', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527386376985', '1');
INSERT INTO `t_system_log` VALUES ('110', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527386377142', '1');
INSERT INTO `t_system_log` VALUES ('111', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527387343497', '1');
INSERT INTO `t_system_log` VALUES ('112', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527387343327', '1');
INSERT INTO `t_system_log` VALUES ('113', '1', 'admin', '0:0:0:0:0:0:0:1', '添加监控【 监控2】成功', '1527387738888', '5');
INSERT INTO `t_system_log` VALUES ('114', '1', 'admin', '0:0:0:0:0:0:0:1', '添加监控【 监控3】成功', '1527388073815', '5');
INSERT INTO `t_system_log` VALUES ('115', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】注销成功', '1527390366736', '2');
INSERT INTO `t_system_log` VALUES ('116', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527390383797', '1');
INSERT INTO `t_system_log` VALUES ('117', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527390383797', '1');
INSERT INTO `t_system_log` VALUES ('118', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】注销成功', '1527390393929', '2');
INSERT INTO `t_system_log` VALUES ('119', '8', '777', '0:0:0:0:0:0:0:1', '【777】登录成功', '1527390397224', '1');
INSERT INTO `t_system_log` VALUES ('120', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527393779021', '1');
INSERT INTO `t_system_log` VALUES ('121', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527393779231', '1');
INSERT INTO `t_system_log` VALUES ('122', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527393800897', '1');
INSERT INTO `t_system_log` VALUES ('123', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527393800690', '1');
INSERT INTO `t_system_log` VALUES ('124', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527866483667', '1');
INSERT INTO `t_system_log` VALUES ('125', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1527866483667', '1');
INSERT INTO `t_system_log` VALUES ('126', '1', 'admin', '0:0:0:0:0:0:0:1', '【admin】登录成功', '1528821432930', '1');

-- ----------------------------
-- Table structure for t_sys_func
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_func`;
CREATE TABLE `t_sys_func` (
  `n_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(64) NOT NULL COMMENT '菜单名称',
  `c_icon` varchar(64) DEFAULT NULL COMMENT '菜单图标',
  `n_parent_id` bigint(20) DEFAULT NULL COMMENT '上级菜单ID',
  `c_link` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `n_sort` int(3) NOT NULL DEFAULT '999' COMMENT '排序',
  `n_status` int(1) NOT NULL DEFAULT '1' COMMENT '0-禁用 1-启用',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_sys_func
-- ----------------------------
INSERT INTO `t_sys_func` VALUES ('1', '称重管理', null, '0', '', '2', '1');
INSERT INTO `t_sys_func` VALUES ('2', '系统管理', null, '0', null, '4', '1');
INSERT INTO `t_sys_func` VALUES ('3', '日志管理', null, '2', 'logManage', '4', '1');
INSERT INTO `t_sys_func` VALUES ('4', '部门管理', null, '2', 'deptManage', '1', '1');
INSERT INTO `t_sys_func` VALUES ('5', '用户管理', 'glyphicon glyphicon-user', '2', 'userManage', '2', '1');
INSERT INTO `t_sys_func` VALUES ('6', '角色管理', null, '2', 'roleManage', '3', '1');
INSERT INTO `t_sys_func` VALUES ('7', '最新称重', null, '1', 'recordNew', '1', '1');
INSERT INTO `t_sys_func` VALUES ('8', '称重列表', null, '1', 'recordList', '2', '1');
INSERT INTO `t_sys_func` VALUES ('9', '视频', null, '0', 'videoManage', '3', '1');
INSERT INTO `t_sys_func` VALUES ('10', '统计', null, '0', 'syscount', '1', '1');

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `n_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(64) NOT NULL COMMENT '名称',
  `c_note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', '管理员', '这是管理员');
INSERT INTO `t_sys_role` VALUES ('18', '部分权限', null);

-- ----------------------------
-- Table structure for t_sys_role_func
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_func`;
CREATE TABLE `t_sys_role_func` (
  `n_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `n_role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `n_func_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_sys_role_func
-- ----------------------------
INSERT INTO `t_sys_role_func` VALUES ('87', '18', '1');
INSERT INTO `t_sys_role_func` VALUES ('88', '18', '7');
INSERT INTO `t_sys_role_func` VALUES ('89', '18', '2');
INSERT INTO `t_sys_role_func` VALUES ('90', '18', '3');
INSERT INTO `t_sys_role_func` VALUES ('91', '1', '10');
INSERT INTO `t_sys_role_func` VALUES ('92', '1', '1');
INSERT INTO `t_sys_role_func` VALUES ('93', '1', '7');
INSERT INTO `t_sys_role_func` VALUES ('94', '1', '8');
INSERT INTO `t_sys_role_func` VALUES ('95', '1', '9');
INSERT INTO `t_sys_role_func` VALUES ('96', '1', '2');
INSERT INTO `t_sys_role_func` VALUES ('97', '1', '4');
INSERT INTO `t_sys_role_func` VALUES ('98', '1', '5');
INSERT INTO `t_sys_role_func` VALUES ('99', '1', '6');
INSERT INTO `t_sys_role_func` VALUES ('100', '1', '3');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `n_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(64) NOT NULL COMMENT '名称',
  `c_username` varchar(64) NOT NULL,
  `c_password` varchar(64) NOT NULL,
  `c_position` varchar(64) DEFAULT NULL COMMENT '职务',
  `n_sort` int(3) NOT NULL DEFAULT '999' COMMENT '排序',
  `c_tel` varchar(32) DEFAULT NULL COMMENT '电话',
  `c_mobile_tel` varchar(32) DEFAULT NULL COMMENT '手机',
  `c_email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `n_create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `n_status` int(1) NOT NULL DEFAULT '1' COMMENT '状态 0-禁用 1-启用',
  `n_update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'admin', 'admin', 'CCABBBBD66625C8933674ECD2786507E', null, '1', null, null, null, '1526802279651', '1', null);
INSERT INTO `t_sys_user` VALUES ('3', '12334', '1234', '0F59502013E207A9A10F05421DBE0243', '1234', '999', '1234', '1234', '1234@1234.com', '1527083333109', '1', null);
INSERT INTO `t_sys_user` VALUES ('4', 'ccc', 'ccc', 'ccc', 'ccc', '999', 'ccc', '123', 'ccc@ccc.com', '1527084228174', '1', null);
INSERT INTO `t_sys_user` VALUES ('5', '333', '333', '333', '333', '999', '333', '333', '333@333.com', '1527084390988', '1', null);
INSERT INTO `t_sys_user` VALUES ('6', '555', '555', '555', '555', '999', '555', '55555', '555@555.com', '1527085576895', '1', null);
INSERT INTO `t_sys_user` VALUES ('7', '666', '666', '666', '666', '999', '666', '666', '666@666.com', '1527085947726', '1', null);
INSERT INTO `t_sys_user` VALUES ('8', '777', '777', '777', '777', '999', '777', '777777', '777@777.com', '1527086566563', '1', null);
INSERT INTO `t_sys_user` VALUES ('13', 'asdd', 'asds', '0F59502013E207A9A10F05421DBE0243', null, '999', null, null, null, '1528566356124', '1', null);
INSERT INTO `t_sys_user` VALUES ('14', 'abcaa', 'abc', '0F59502013E207A9A10F05421DBE0243', null, '999', null, null, null, '1528567884163', '1', null);

-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_user_id` int(11) DEFAULT NULL,
  `n_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `t_sys_user_role` VALUES ('7', '14', '18');

-- ----------------------------
-- Table structure for t_video
-- ----------------------------
DROP TABLE IF EXISTS `t_video`;
CREATE TABLE `t_video` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `n_channel` int(11) DEFAULT NULL COMMENT '通道号',
  `c_sand_name` varchar(255) DEFAULT NULL COMMENT '沙场',
  `c_work_name` varchar(255) DEFAULT NULL COMMENT '工作站',
  `c_truck_name` varchar(255) DEFAULT NULL COMMENT '地磅号',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_video
-- ----------------------------
INSERT INTO `t_video` VALUES ('1', '监控1', '1', '沙场1', '工作站1', '地磅 1');
INSERT INTO `t_video` VALUES ('2', '监控2', '1', '沙场1', '工作站1', '地磅1');
INSERT INTO `t_video` VALUES ('3', '监控3', '3', '33', '33', '33');
