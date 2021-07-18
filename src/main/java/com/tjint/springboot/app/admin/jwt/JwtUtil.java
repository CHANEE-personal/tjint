package com.tjint.springboot.app.admin.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
	@Value("${spring.jwt.secret}")
	private String SECRET_KEY;

	public String extractUserName(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}

	/**
	 * <pre>
	 * 1. MethodName : createToken
	 * 2. ClassName  : JwtUtil.java
	 * 3. Comment    : JWT 토큰 생성
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 07.
	 * </pre>
	 *
	 * @param claims
	 * @param subject
	 * @return
	 * @throws Exception
	 */
	private String createToken(Map<String, Object> claims, String subject) {
		byte[] keyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Key keys = new SecretKeySpec(keyBytes, signatureAlgorithm.getJcaName());

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)).signWith(signatureAlgorithm, keys).compact();
	}

	/**
	 * <pre>
	 * 1. MethodName : resolveToken
	 * 2. ClassName  : JwtUtil.java
	 * 3. Comment    : Header 토큰 정보 가져오기
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 07.
	 * </pre>
	 *
	 * @param  request
	 * @return
	 * @throws Exception
	 */
	public String resolveToken(HttpServletRequest request) {
		return request.getHeader("authentication");
	}

	/**
	 * <pre>
	 * 1. MethodName : validateToken
	 * 2. ClassName  : JwtUtil.java
	 * 3. Comment    : JWT 토큰 검증
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 07.
	 * </pre>
	 *
	 * @param  token
	 * @param  userDetails
	 * @return
	 * @throws Exception
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUserName(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
