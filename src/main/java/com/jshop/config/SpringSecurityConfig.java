package com.jshop.config;

import com.jshop.api.security.JshopAccessDeniedHandler;
import com.jshop.api.security.JshopAuthenticationEntryPoint;
import com.jshop.api.security.api.ApiAuthenticationFilter;
import com.jshop.constant.Globals;
import javax.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Configuration
@AutoConfigureAfter(SpringSecurityBeanConfig.class)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
  @Resource
  private ApiAuthenticationFilter apiAuthenticationFilter;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    super.configure(auth);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    super.configure(web);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
        .addFilterBefore(apiAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .authorizeRequests()
        .antMatchers("/api/caisx.b2b/" + Globals.API_VERSION + "/login").permitAll()
        .antMatchers("/api/admin/**").hasRole("ADMIN")
        .antMatchers("/api/**").hasRole("USER")
        .anyRequest().authenticated()
        .and()
        .exceptionHandling()
        .accessDeniedHandler(new JshopAccessDeniedHandler())
        .authenticationEntryPoint(new JshopAuthenticationEntryPoint())
        .and()
        .csrf().disable()
        .cors().configurationSource(buildCorsConfigSource())
        .and()
        .anonymous().disable();
  }

  private CorsConfigurationSource buildCorsConfigSource() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/api/**", buildConfig());
    return source;
  }

  private CorsConfiguration buildConfig() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOrigin("*");
    corsConfiguration.addAllowedHeader("*");
    corsConfiguration.addAllowedMethod("*");

    return corsConfiguration;
  }
}
