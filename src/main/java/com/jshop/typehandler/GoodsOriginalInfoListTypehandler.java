package com.jshop.typehandler;

import com.alibaba.fastjson.JSON;
import com.jshop.model.domain.GoodsOriginalInfo;
import com.jshop.model.domain.GoodsOriginalInfoList;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by yanglikai on 2017/9/14.
 */
public class GoodsOriginalInfoListTypehandler extends BaseTypeHandler<GoodsOriginalInfoList> {
  @Override
  public void setNonNullParameter(
      PreparedStatement ps,
      int i,
      GoodsOriginalInfoList parameter,
      JdbcType jdbcType) throws SQLException {
    ps.setString(i, JSON.toJSONString(parameter.getGoodsOriginalInfos()));
  }

  @Override
  public GoodsOriginalInfoList getNullableResult(ResultSet rs, String columnName)
      throws SQLException {
    List<GoodsOriginalInfo> target = JSON.parseArray(
        rs.getString(columnName),
        GoodsOriginalInfo.class);

    return GoodsOriginalInfoList.builder()
        .withGoodsInfo(target)
        .build();
  }

  @Override
  public GoodsOriginalInfoList getNullableResult(ResultSet rs, int columnIndex)
      throws SQLException {
    List<GoodsOriginalInfo> target = JSON.parseArray(
        rs.getString(columnIndex),
        GoodsOriginalInfo.class);

    return GoodsOriginalInfoList.builder()
        .withGoodsInfo(target)
        .build();
  }

  @Override
  public GoodsOriginalInfoList getNullableResult(CallableStatement cs, int columnIndex)
      throws SQLException {
    List<GoodsOriginalInfo> target = JSON.parseArray(
        cs.getString(columnIndex),
        GoodsOriginalInfo.class);

    return GoodsOriginalInfoList.builder()
        .withGoodsInfo(target)
        .build();
  }
}
