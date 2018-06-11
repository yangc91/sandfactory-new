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
  private Long id;

  // 沙场
  @Column("c_sand_name")
  private String sandName;

  // 工作站
  @Column("c_work_name")
  private String workName;

  // 地磅
  @Column("c_truck_name")
  private String truckName;

  // 皮重照片， 图片转为base64字符串
  @Column("c_trace_img1")
  private String traceImg1;
  @Column("c_trace_img2")
  private String traceImg2;
  @Column("c_trace_img3")
  private String traceImg3;
  @Column("c_trace_img4")
  private String traceImg4;
  // 毛重照片1， 图片转为base64字符串
  @Column("c_gross_img1")
  private String grossImg1;
  @Column("c_gross_img2")
  private String grossImg2;
  @Column("c_gross_img3")
  private String grossImg3;
  @Column("c_gross_img4")
  private String grossImg4;

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

  //出入类型
  @Column("c_crlx")
  private String crlx;

  //毛重 kg
  @Column("n_mz")
  private float mz;

  //皮重
  @Column("n_pz")
  private float pz;

  //净重
  @Column("n_jz")
  private float jz;

  //扣杂 扣重
  @Column("n_kz")
  private float kz;

  //实重 kg
  private float sz;

  //扣率
  @Column("n_kl")
  private float kl;

  //单价
  @Column("n_dj")
  private float dj;

  //金额
  @Column("n_je")
  private float je;

  //折方系数
  @Column("n_zfxs")
  private float zfxs;
  //方量
  @Column("n_fl")
  private float fl;
  //过磅费
  @Column("n_gbf")
  private float gbf;

  //毛重司磅员
  @Column("c_mzsby")
  private String mzsby;
  //皮重司磅员
  @Column("c_pzsby")
  private String pzsby;
  //毛重磅号
  @Column("c_mzbh")
  private String mzbh;
  //皮重磅号
  @Column("c_pzbh")
  private String pzbh;

  //毛重时间
  @Column("c_mzsj")
  private String mzsj;

  //皮重时间
  @Column("c_pzsj")
  private String pzsj;

  //一次日期 一次过磅时间 yyyy-MM-dd HH:mm:ss
  @Column("c_ycrq")
  private String ycrq;

  //二次过磅时间 yyyy-MM-dd HH:mm:ss
  private String ecrq;

  //司机
  @Column("c_siji")
  private String siji;

  //操作员 //更新人
  @Column("c_czy")
  private String czy;

  //更新时间 yyyy-MM-dd HH:mm:ss
  @Column("c_gxsj")
  private String gxsj;

  //上传
  @Column("c_sc")
  private String sc;

  //备用1  =====
  @Column("c_by1")
  private String by1;

  //备用2
  @Column("c_by2")
  private String by2;

  //备用3
  @Column("c_by3")
  private String by3;

  //备用4
  @Column("c_by4")
  private String by4;

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

  //备注
  @Column("c_bz")
  private String bz;

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

  //台号1
  @Column("c_th1")
  private String th1;

  //余款
  @Column("n_yk")
  private float yk;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public String getTraceImg1() {
    return traceImg1;
  }

  public void setTraceImg1(String traceImg1) {
    this.traceImg1 = traceImg1;
  }

  public String getTraceImg2() {
    return traceImg2;
  }

  public void setTraceImg2(String traceImg2) {
    this.traceImg2 = traceImg2;
  }

  public String getTraceImg3() {
    return traceImg3;
  }

  public void setTraceImg3(String traceImg3) {
    this.traceImg3 = traceImg3;
  }

  public String getTraceImg4() {
    return traceImg4;
  }

  public void setTraceImg4(String traceImg4) {
    this.traceImg4 = traceImg4;
  }

  public String getGrossImg1() {
    return grossImg1;
  }

  public void setGrossImg1(String grossImg1) {
    this.grossImg1 = grossImg1;
  }

  public String getGrossImg2() {
    return grossImg2;
  }

  public void setGrossImg2(String grossImg2) {
    this.grossImg2 = grossImg2;
  }

  public String getGrossImg3() {
    return grossImg3;
  }

  public void setGrossImg3(String grossImg3) {
    this.grossImg3 = grossImg3;
  }

  public String getGrossImg4() {
    return grossImg4;
  }

  public void setGrossImg4(String grossImg4) {
    this.grossImg4 = grossImg4;
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

  public float getSz() {
    return sz;
  }

  public void setSz(float sz) {
    this.sz = sz;
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

  public float getZfxs() {
    return zfxs;
  }

  public void setZfxs(float zfxs) {
    this.zfxs = zfxs;
  }

  public float getFl() {
    return fl;
  }

  public void setFl(float fl) {
    this.fl = fl;
  }

  public float getGbf() {
    return gbf;
  }

  public void setGbf(float gbf) {
    this.gbf = gbf;
  }

  public String getMzsby() {
    return mzsby;
  }

  public void setMzsby(String mzsby) {
    this.mzsby = mzsby;
  }

  public String getPzsby() {
    return pzsby;
  }

  public void setPzsby(String pzsby) {
    this.pzsby = pzsby;
  }

  public String getMzbh() {
    return mzbh;
  }

  public void setMzbh(String mzbh) {
    this.mzbh = mzbh;
  }

  public String getPzbh() {
    return pzbh;
  }

  public void setPzbh(String pzbh) {
    this.pzbh = pzbh;
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

  public String getYcrq() {
    return ycrq;
  }

  public void setYcrq(String ycrq) {
    this.ycrq = ycrq;
  }

  public String getEcrq() {
    return ecrq;
  }

  public void setEcrq(String ecrq) {
    this.ecrq = ecrq;
  }

  public String getSiji() {
    return siji;
  }

  public void setSiji(String siji) {
    this.siji = siji;
  }

  public String getCzy() {
    return czy;
  }

  public void setCzy(String czy) {
    this.czy = czy;
  }

  public String getGxsj() {
    return gxsj;
  }

  public void setGxsj(String gxsj) {
    this.gxsj = gxsj;
  }

  public String getSc() {
    return sc;
  }

  public void setSc(String sc) {
    this.sc = sc;
  }

  public String getBy1() {
    return by1;
  }

  public void setBy1(String by1) {
    this.by1 = by1;
  }

  public String getBy2() {
    return by2;
  }

  public void setBy2(String by2) {
    this.by2 = by2;
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

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
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
