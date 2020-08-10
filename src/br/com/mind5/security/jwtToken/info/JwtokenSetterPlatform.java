package br.com.mind5.security.jwtToken.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.servlet.filter.common.Platform;

public final class JwtokenSetterPlatform extends InfoSetterTemplate<JwtokenInfo> {	
	
	@Override protected JwtokenInfo setAttrHook(JwtokenInfo recordInfo) {
		recordInfo.codPlatform = Platform.WEB.getCodPlatform();
		return recordInfo;
	}
}
