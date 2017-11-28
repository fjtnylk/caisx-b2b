package com.jshop.typehandler;

import com.alibaba.fastjson.JSON;
import com.jshop.model.domain.GoodsInfo;
import com.jshop.model.domain.GoodsInfoList;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by yanglikai on 2017/9/8.
 */
public class GoodsInfoListTypeHandler extends BaseTypeHandler<GoodsInfoList> {
  @Override
  public void setNonNullParameter(
      PreparedStatement ps,
      int i,
      GoodsInfoList parameter,
      JdbcType jdbcType) throws SQLException {
    ps.setString(i, JSON.toJSONString(parameter.getGoodsInfos()));
  }

  @Override
  public GoodsInfoList getNullableResult(ResultSet rs, String columnName) throws SQLException {
    List<GoodsInfo> target = JSON.parseArray(rs.getString(columnName), GoodsInfo.class);
    return GoodsInfoList.builder()
        .withGoodsInfos(target)
        .build();
  }

  @Override
  public GoodsInfoList getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    List<GoodsInfo> target = JSON.parseArray(rs.getString(columnIndex), GoodsInfo.class);
    return GoodsInfoList.builder()
        .withGoodsInfos(target)
        .build();
  }

  @Override
  public GoodsInfoList getNullableResult(CallableStatement cs, int columnIndex)
      throws SQLException {
    List<GoodsInfo> target = JSON.parseArray(cs.getString(columnIndex), GoodsInfo.class);
    return GoodsInfoList.builder()
        .withGoodsInfos(target)
        .build();
  }
}
