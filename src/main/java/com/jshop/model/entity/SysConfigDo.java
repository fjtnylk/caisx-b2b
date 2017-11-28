package com.jshop.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jshop.model.Do;
import java.util.Date;

/**
 * Created by yanglikai on 2017/9/14.
 */
@TableName(value = "jshop_sys_config")
public class SysConfigDo extends Do {
  @TableId
  private Long id;
  @TableField
  private String sysKey;
  @TableField
  private String sysDesc;
  @TableField
  private String sysValue;
  @TableField
  private Integer edit;
  @TableField
  private Date createTime;
  @TableField
  private Date updateTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSysKey() {
    return sysKey;
  }

  public void setSysKey(String sysKey) {
    this.sysKey = sysKey;
  }

  public String getSysDesc() {
    return sysDesc;
  }

  public void setSysDesc(String sysDesc) {
    this.sysDesc = sysDesc;
  }

  public String getSysValue() {
    return sysValue;
  }

  public void setSysValue(String sysValue) {
    this.sysValue = sysValue;
  }

  public Integer getEdit() {
    return edit;
  }

  public void setEdit(Integer edit) {
    this.edit = edit;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
