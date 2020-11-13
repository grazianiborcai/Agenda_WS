package br.com.mind5.security.jwtToken.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class JwtokenSetterObfuscate extends InfoSetterTemplate<JwtokenInfo> {	
	
	@Override protected JwtokenInfo setAttrHook(JwtokenInfo recordInfo) {
		JwtokenInfo result = new JwtokenInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
