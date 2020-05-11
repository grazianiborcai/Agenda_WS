package br.com.mind5.security.jwtToken.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class JwtokenSetterSecret extends InfoSetterTemplate<JwtokenInfo> {
	private final String SECRET_KEY = "t8%A$?Cx>u?px^'<XfSGn3&w~6OEYu/M5}${Un>Xgto7#}Lt6ZgaQGQ#_V(y{j$";
	
	
	@Override protected JwtokenInfo setAttrHook(JwtokenInfo recordInfo) {
		recordInfo.secret = SECRET_KEY;
		return recordInfo;
	}
}
