package com.jshop.typehandler;

import com.alibaba.fastjson.JSON;
import com.jshop.model.domain.GoodsRefundInfo;
import com.jshop.model.domain.GoodsRefundInfoList;
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
public class GoodsRefundInfoListTypeHandler extends BaseTypeHandler<GoodsRefundInfoList> {
  @Override
  public void setNonNullParameter(
      PreparedStatement ps,
      int i,
      GoodsRefundInfoList parameter,
      JdbcType jdbcType) throws SQLException {
    ps.setString(i, JSON.toJSONString(parameter.getRefundInfos()));
  }

  @Override
  public GoodsRefundInfoList getNullableResult(
      ResultSet rs,
      String columnName) throws SQLException {
    List<GoodsRefundInfo> target = JSON.parseArray(rs.getString(columnName), GoodsRefundInfo.class);

    return GoodsRefundInfoList.builder()
        .withRefundInfos(target)
        .build();
  }

  @Override
  public GoodsRefundInfoList getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    List<GoodsRefundInfo> target =
        JSON.parseArray(rs.getString(columnIndex), GoodsRefundInfo.class);

    return GoodsRefundInfoList.builder()
        .withRefundInfos(target)
        .build();
  }

  @Override
  public GoodsRefundInfoList getNullableResult(CallableStatement cs, int columnIndex)
      throws SQLException {
    List<GoodsRefundInfo> target =
        JSON.parseArray(cs.getString(columnIndex), GoodsRefundInfo.class);

    return GoodsRefundInfoList.builder()
        .withRefundInfos(target)
        .build();
  }
}
