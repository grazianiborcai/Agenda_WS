package br.com.mind5.security.jwtToken.info;

import br.com.mind5.info.InfoSetterTemplate;
import io.jsonwebtoken.Jwts;

public final class JwtokenSetterToken extends InfoSetterTemplate<JwtokenInfo> {
	
	@Override protected JwtokenInfo setAttrHook(JwtokenInfo recordInfo) {
		recordInfo.token = Jwts.builder().claim("codPlatform", recordInfo.codPlatform)	
										 .claim("codOwner", Long.toString(recordInfo.codOwner))			   
										 .claim("username",recordInfo.username)	
										 .claim("createdOn",recordInfo.createdOnStr)	
										 .setExpiration(recordInfo.expirationTime)				               
										 .signWith(recordInfo.algo, recordInfo.secret)
										 .compact();
		return recordInfo;
	}
}
