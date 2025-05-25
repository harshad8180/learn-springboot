//package com.example.product.security;
//
//import java.security.Key;
//import java.security.SecureRandom;
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//import java.util.function.Function;
//
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//
//@Component
//public class JwtUtil {
//	
//	private static String secretKey;
//	
//	public JwtUtil() {
//		SecureRandom random = new SecureRandom();
//		byte[] key = new byte[32]; // 256 bits
//		random.nextBytes(key);
//		secretKey = Base64.getEncoder().encodeToString(key);
//	}
//	
//	public String generateToken(String username, List<String> roles) {
//		return Jwts.builder()
//				.setSubject(username)
//				.claim("roles", roles)
//				.setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis()+1000*60*2))
//				.signWith(getSignedKey(),SignatureAlgorithm.ES256)
//				.compact();
//	}
//	
//	private Key getSignedKey() {
//		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//		return Keys.hmacShaKeyFor(keyBytes);
//	}
//	
//	public Boolean valisToken(String token, String username) {
//		return (extractUsername(token).equals(username) && !isTokenExpired(token));
//	}
//	
//	public String extractUsername(String token) {
//		return extractClaims(token, Claims::getSubject);
//	}
//	
//	public Date extractExpiration(String token) {
//		return extractClaims(token, Claims::getExpiration);
//	}
//	
//	public Boolean isTokenExpired(String token) {
//		return extractExpiration(token).before(new Date());
//	}
//	
//	public List<String> extractRole(String token){
//		return extractClaims(token, claims->claims.get("roles", List.class));
//	}
//	
//	public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
//		 final Claims claims = Jwts.parser()
//				 .setSigningKey(getSignedKey())
//				 .build()
//				 .parseClaimsJws(token)
//				 .getBody();
//		 return claimsResolver.apply(claims);
//	}
//}
