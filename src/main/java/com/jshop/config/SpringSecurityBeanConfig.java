package com.jshop.config;

import com.jshop.api.security.JshopUserDetailsService;
import com.jshop.api.security.api.ApiAuthenticationFailureHandler;
import com.jshop.api.security.api.ApiAuthenticationFilter;
import com.jshop.api.security.api.ApiAuthenticationProvider;
import com.jshop.api.security.api.ApiAuthenticationSuccessHandler;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Configuration
public class SpringSecurityBeanConfig {
  @Bean
  public UserDetailsService userDetailsService() {
    return new JshopUserDetailsService();
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    return new ApiAuthenticationProvider();
  }

  @Bean
  public AuthenticationManager authenticationManager() {
    return new ProviderManager(Arrays.asList(authenticationProvider()));
  }

  @Bean
  public AuthenticationSuccessHandler authenticationSuccessHandler() {
    return new ApiAuthenticationSuccessHandler();
  }

  @Bean
  public AuthenticationFailureHandler authenticationFailureHandler() {
    return new ApiAuthenticationFailureHandler();
  }

  @Bean(value = "scopedTarget.apiAuthenticationFilter")
  public ApiAuthenticationFilter apiAuthenticationFilter() {
    return new ApiAuthenticationFilter();
  }
}
