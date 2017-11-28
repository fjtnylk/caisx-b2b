package com.jshop.api.security.api;

import com.jshop.api.exception.TokenInvalidException;
import com.jshop.api.exception.UsernameAuthenticationFailureException;
import com.jshop.api.exception.UsernameInvalidException;
import com.jshop.api.security.JshopUserDetailsBuilder;
import com.jshop.constant.RedisKey;
import com.jshop.utils.JwtUtils;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class ApiAuthenticationProvider implements AuthenticationProvider {
  @Resource
  private UserDetailsService userDetailsService;
  @Resource
  private StringRedisTemplate stringRedisClient;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    ApiAuthenticationToken authenticationToken = (ApiAuthenticationToken) authentication;
    String token = authenticationToken.getToken();
    if (StringUtils.isEmpty(token)) {
      UserDetails userDetails = JshopUserDetailsBuilder
          .builder()
          .anonymous()
          .build();
      return new ApiAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    String userName = authenticateToken(token);
    if (StringUtils.isEmpty(userName)) {
      throw new TokenInvalidException();
    }

    try {
      UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
      return new ApiAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    } catch (UsernameNotFoundException e) {
      throw new UsernameInvalidException();
    } catch (UsernameAuthenticationFailureException e) {
      throw new UsernameAuthenticationFailureException();
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return (ApiAuthenticationToken.class.isAssignableFrom(authentication));
  }

  /**
   * token认证.
   *
   * @param token token
   * @return 用户名
   */
  private String authenticateToken(String token) {
    String userName = JwtUtils.authToken(token);
    String key = String.format(RedisKey.B2B_USER_TOKEN.key, userName);
    String value = stringRedisClient.opsForValue().get(key);
    if (StringUtils.isEmpty(value)) {
      return null;
    }

    if (token.equals(value) == false) {
      return null;
    }

    return userName;
  }
}
