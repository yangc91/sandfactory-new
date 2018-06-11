package com.yc.sandfactory.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.io.Serializable;

/**
 * @project: sandfactory
 * @author: yc
 */
@Table("t_cz_record")
public class ChengZhongRecord implements Serializable {

  private static final long serialVersionUID = 5228269850702848343L;

  @Id
  @Column("n_id")
  private Integer id;

  // 沙场
  @Column("c_sand_name")
  private String sandName;


  // 工作站
  @Column("c_work_name")
  private String workName;

  // 地磅
  @Column("c_truck_name")
  private String truckName;

  // 序号(票据编号)
  @Column("c_xh")
  private String xh;

  //车号(车辆号码)
  @Column("c_ch")
  private String ch;

  //货名（货物名称）
  @Column("c_hm")
  private String hm;

  //发货
  @Column("c_fh")
  private String fh;

  //收货
  @Column("c_sh")
  private String sh;

  //规格
  @Column("c_gg")
  private String gg;

  //备用2
  @Column("c_by2")
  private String by2;

  //出入类型
  @Column("c_crlx")
  private String crlx;

  //毛重
  @Column("n_mz")
  private float mz;

  //皮重
  @Column("n_pz")
  private float pz;

  //净重
  @Column("n_jz")
  private float jz;

  //扣杂
  @Column("n_kz")
  private float kz;

  //扣率
  @Column("n_kl")
  private float kl;

  //单价
  @Column("n_dj")
  private float dj;

  //金额
  @Column("n_je")
  private float je;

  //备用3
  @Column("c_by3")
  private String by3;

  //备用4
  @Column("c_by4")
  private String by4;

  //司机
  @Column("c_siji")
  private String siji;

  //监磅
  @Column("c_jb")
  private String jb;

  //日期
  @Column("c_rq")
  private String rq;

  //时间
  @Column("c_shijian")
  private String shijian;

  //台号
  @Column("c_th")
  private String th;

  //操作员
  @Column("c_czy")
  private String czy;

  //备注
  @Column("c_bz")
  private String bz;

  //毛重时间
  @Column("c_mzsj")
  private String mzsj;

  //皮重时间
  @Column("c_pzsj")
  private String pzsj;

  //上传
  @Column("c_sc")
  private String sc;

  //打印
  @Column("c_dy")
  private String dy;

  //净重1
  @Column("n_jz1")
  private float jz1;

  //扣杂系数
  @Column("n_kzxs")
  private float kzxs;

  //扣率系数
  @Column("n_klxs")
  private float klxs;

  //结算
  @Column("c_js")
  private String js;

  //结算编号
  @Column("c_jsbh")
  private String jsbh;

  //操作员1
  @Column("c_czy1")
  private String czy1;

  //开票
  @Column("c_kp")
  private String kp;

  //一次日期
  @Column("c_ycrq")
  private String ycrq;

  //台号1
  @Column("c_th1")
  private String th1;

  //余款
  @Column("n_yk")
  private float yk;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSandName() {
    return sandName;
  }

  public void setSandName(String sandName) {
    this.sandName = sandName;
  }

  public String getWorkName() {
    return workName;
  }

  public void setWorkName(String workName) {
    this.workName = workName;
  }

  public String getTruckName() {
    return truckName;
  }

  public void setTruckName(String truckName) {
    this.truckName = truckName;
  }

  public String getXh() {
    return xh;
  }

  public void setXh(String xh) {
    this.xh = xh;
  }

  public String getCh() {
    return ch;
  }

  public void setCh(String ch) {
    this.ch = ch;
  }

  public String getHm() {
    return hm;
  }

  public void setHm(String hm) {
    this.hm = hm;
  }

  public String getFh() {
    return fh;
  }

  public void setFh(String fh) {
    this.fh = fh;
  }

  public String getSh() {
    return sh;
  }

  public void setSh(String sh) {
    this.sh = sh;
  }

  public String getGg() {
    return gg;
  }

  public void setGg(String gg) {
    this.gg = gg;
  }

  public String getBy2() {
    return by2;
  }

  public void setBy2(String by2) {
    this.by2 = by2;
  }

  public String getCrlx() {
    return crlx;
  }

  public void setCrlx(String crlx) {
    this.crlx = crlx;
  }

  public float getMz() {
    return mz;
  }

  public void setMz(float mz) {
    this.mz = mz;
  }

  public float getPz() {
    return pz;
  }

  public void setPz(float pz) {
    this.pz = pz;
  }

  public float getJz() {
    return jz;
  }

  public void setJz(float jz) {
    this.jz = jz;
  }

  public float getKz() {
    return kz;
  }

  public void setKz(float kz) {
    this.kz = kz;
  }

  public float getKl() {
    return kl;
  }

  public void setKl(float kl) {
    this.kl = kl;
  }

  public float getDj() {
    return dj;
  }

  public void setDj(float dj) {
    this.dj = dj;
  }

  public float getJe() {
    return je;
  }

  public void setJe(float je) {
    this.je = je;
  }

  public String getBy3() {
    return by3;
  }

  public void setBy3(String by3) {
    this.by3 = by3;
  }

  public String getBy4() {
    return by4;
  }

  public void setBy4(String by4) {
    this.by4 = by4;
  }

  public String getSiji() {
    return siji;
  }

  public void setSiji(String siji) {
    this.siji = siji;
  }

  public String getJb() {
    return jb;
  }

  public void setJb(String jb) {
    this.jb = jb;
  }

  public String getRq() {
    return rq;
  }

  public void setRq(String rq) {
    this.rq = rq;
  }

  public String getShijian() {
    return shijian;
  }

  public void setShijian(String shijian) {
    this.shijian = shijian;
  }

  public String getTh() {
    return th;
  }

  public void setTh(String th) {
    this.th = th;
  }

  public String getCzy() {
    return czy;
  }

  public void setCzy(String czy) {
    this.czy = czy;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public String getMzsj() {
    return mzsj;
  }

  public void setMzsj(String mzsj) {
    this.mzsj = mzsj;
  }

  public String getPzsj() {
    return pzsj;
  }

  public void setPzsj(String pzsj) {
    this.pzsj = pzsj;
  }

  public String getSc() {
    return sc;
  }

  public void setSc(String sc) {
    this.sc = sc;
  }

  public String getDy() {
    return dy;
  }

  public void setDy(String dy) {
    this.dy = dy;
  }

  public float getJz1() {
    return jz1;
  }

  public void setJz1(float jz1) {
    this.jz1 = jz1;
  }

  public float getKzxs() {
    return kzxs;
  }

  public void setKzxs(float kzxs) {
    this.kzxs = kzxs;
  }

  public float getKlxs() {
    return klxs;
  }

  public void setKlxs(float klxs) {
    this.klxs = klxs;
  }

  public String getJs() {
    return js;
  }

  public void setJs(String js) {
    this.js = js;
  }

  public String getJsbh() {
    return jsbh;
  }

  public void setJsbh(String jsbh) {
    this.jsbh = jsbh;
  }

  public String getCzy1() {
    return czy1;
  }

  public void setCzy1(String czy1) {
    this.czy1 = czy1;
  }

  public String getKp() {
    return kp;
  }

  public void setKp(String kp) {
    this.kp = kp;
  }

  public String getYcrq() {
    return ycrq;
  }

  public void setYcrq(String ycrq) {
    this.ycrq = ycrq;
  }

  public String getTh1() {
    return th1;
  }

  public void setTh1(String th1) {
    this.th1 = th1;
  }

  public float getYk() {
    return yk;
  }

  public void setYk(float yk) {
    this.yk = yk;
  }
}
