package com.jshop.api.security;

import com.jshop.api.exception.UsernameAuthenticationFailureException;
import com.jshop.api.exception.UsernameInvalidException;
import com.jshop.model.vo.user.UserProfileVo;
import com.jshop.service.user.IUserService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class JshopUserDetailsService implements UserDetailsService {
  private static final Logger log = LoggerFactory.getLogger(JshopUserDetailsService.class);

  @Resource
  private IUserService userService;

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException, UsernameAuthenticationFailureException {
    try {
      UserProfileVo user = userService.loadUserProfile(username);
      if (user == null) {
        throw new UsernameInvalidException();
      }

      long userId = user.getUserId();
      if (log.isDebugEnabled()) {
        log.debug("userId: {}", userId);
      }

      String mobile = user.getMobile();
      return JshopUserDetailsBuilder
          .builder()
          .withUserId(userId)
          .withUserName(username)
          .withMobile(mobile)
          .withAuth(AuthorityUtils.createAuthorityList(JshopUserRole.ROLE_USER))
          .withCustCode(user.getUserContractNo())
          .build();
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new UsernameAuthenticationFailureException();
    }
  }
}
