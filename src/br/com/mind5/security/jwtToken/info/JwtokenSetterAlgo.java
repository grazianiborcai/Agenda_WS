package br.com.mind5.security.jwtToken.info;

import br.com.mind5.info.InfoSetterTemplate;
import io.jsonwebtoken.SignatureAlgorithm;

public final class JwtokenSetterAlgo extends InfoSetterTemplate<JwtokenInfo> {	
	
	@Override protected JwtokenInfo setAttrHook(JwtokenInfo recordInfo) {
		recordInfo.algo = SignatureAlgorithm.HS512;
		return recordInfo;
	}
}
