package com.jshop.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jshop.constant.Globals;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

/**
 * Created by yanglikai on 2017/9/6.
 */
public final class JwtUtils {
  /**
   * token令牌.
   *
   * @param userName 用户名
   * @return 10年有效期token令牌
   */
  public static String createToken(String userName) {
    try {
      Algorithm algorithm = Algorithm.HMAC512(Globals.API_KEY);
      String token = JWT.create()
          .withIssuer(Globals.ISSUER)
          .withExpiresAt(DateUtils.addYears(new Date(), 10))
          .withIssuedAt(new Date())
          .withClaim("userName", userName)
          .sign(algorithm);
      return token;
    } catch (UnsupportedEncodingException exception) {
      //UTF-8 encoding not supported
    } catch (JWTVerificationException exception) {
      //Invalid signature/claims
    }

    return null;
  }

  /**
   * token验证.
   *
   * @param token 令牌
   * @return 成功:用户名,失败:null
   */
  public static String authToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC512(Globals.API_KEY);
      JWTVerifier verifier = JWT.require(algorithm)
          .withIssuer(Globals.ISSUER)
          .build();
      DecodedJWT jwt = verifier.verify(token);
      return jwt.getClaim("userName").asString();
    } catch (UnsupportedEncodingException exception) {
      //UTF-8 encoding not supported
    } catch (JWTVerificationException exception) {
      //Invalid signature/claims
    }

    return null;
  }
}
