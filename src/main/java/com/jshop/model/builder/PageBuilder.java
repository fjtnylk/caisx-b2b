package com.jshop.model.builder;

import com.baomidou.mybatisplus.plugins.Page;
import com.jshop.constant.Globals;
import com.jshop.model.Do;
import java.util.List;

/**
 * Created by yanglikai on 2017/8/21.
 */
public class PageBuilder<T extends Do> {
  private Page<T> page;

  private PageBuilder() {
    this.page = new Page<>();
    this.page.setSize(Globals.DEFAULT_PAGE_ROWS);
  }

  public static <T extends Do> PageBuilder<T> builder(Class<T> target) {
    return new PageBuilder<>();
  }

  public PageBuilder<T> page(int page) {
    this.page.setCurrent(page);
    return this;
  }

  public PageBuilder<T> size(int size) {
    this.page.setSize(size);
    return this;
  }

  public PageBuilder<T> records(List<T> records) {
    this.page.setRecords(records);
    return this;
  }

  public PageBuilder<T> total(int total) {
    this.page.setTotal(total);
    return this;
  }

  public Page<T> getTarget() {
    return this.page;
  }
}
