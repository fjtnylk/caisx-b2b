package com.jshop.typehandler;

import com.alibaba.fastjson.JSON;
import com.jshop.model.domain.GoodsUnit;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by yanglikai on 2017/9/8.
 */
public class GoodsUnitTypeHandler extends BaseTypeHandler<GoodsUnit> {
  @Override
  public void setNonNullParameter(
      PreparedStatement ps,
      int i,
      GoodsUnit parameter,
      JdbcType jdbcType) throws SQLException {
    ps.setString(i, JSON.toJSONString(parameter));
  }

  @Override
  public GoodsUnit getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return GoodsUnit.builder(rs.getString(columnName)).build();
  }

  @Override
  public GoodsUnit getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return GoodsUnit.builder(rs.getString(columnIndex)).build();
  }

  @Override
  public GoodsUnit getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return GoodsUnit.builder(cs.getString(columnIndex)).build();
  }
}
