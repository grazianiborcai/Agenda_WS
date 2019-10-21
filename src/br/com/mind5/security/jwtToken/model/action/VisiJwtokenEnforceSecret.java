package br.com.mind5.security.jwtToken.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.info.JwtokenSetterSecret;

final class VisiJwtokenEnforceSecret extends ActionVisitorTemplateEnforce<JwtokenInfo> {
	
	@Override protected JwtokenInfo enforceHook(JwtokenInfo recordInfo) {
		InfoSetter<JwtokenInfo> attrSetter = new JwtokenSetterSecret();
		return attrSetter.setAttr(recordInfo);
	}
}
