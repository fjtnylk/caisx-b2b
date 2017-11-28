package com.jshop.api.controller.user;

import com.jshop.api.ApiResult;
import com.jshop.api.context.UserContext;
import com.jshop.constant.Globals;
import com.jshop.exception.user.UserServiceException;
import com.jshop.model.query.user.UserLoginQuery;
import com.jshop.model.vo.user.UserDtlVo;
import com.jshop.model.vo.user.UserLoginVo;
import com.jshop.service.user.IUserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2017/9/5.
 */
@RequestMapping(value = "/api")
@RestController
public class UserController {
  @Resource
  private IUserService userService;

  /**
   * 用户登录.
   *
   * @param query 用户登录参数
   * @return 登录成功信息实例
   * @throws UserServiceException 用户登录异常
   */
  @RequestMapping(
      value = "/caisx.b2b/" + Globals.API_VERSION + "/login",
      method = RequestMethod.POST)
  @ResponseBody
  public ApiResult login(@RequestBody UserLoginQuery query) throws UserServiceException {
    UserLoginVo vo = userService.login(query);
    return ApiResult.success(vo);
  }

  /**
   * 用户退出.
   *
   * @return 无
   */
  @RequestMapping(
      value = "/caisx.b2b/" + Globals.API_VERSION + "/logout",
      method = RequestMethod.POST)
  @ResponseBody
  public ApiResult logout(HttpServletRequest request) {
    String token = request.getHeader("X-API-Token");
    userService.logout(token);
    return ApiResult.success();
  }

  /**
   * 用户详情.
   *
   * @return 用户详情信息
   */
  @RequestMapping(
      value = "/caisx.user.dtl/" + Globals.API_VERSION + "/get",
      method = RequestMethod.GET)
  @ResponseBody
  public ApiResult userDtl() {
    long userId = UserContext.getUserId();
    UserDtlVo userDtlVo = userService.loadUserDtl(userId);
    return ApiResult.success(userDtlVo);
  }
}
