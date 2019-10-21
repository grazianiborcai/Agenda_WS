package br.com.mind5.security.jwtToken.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.info.JwtokenSetterToken;

final class VisiJwtokenEnforceToken extends ActionVisitorTemplateEnforce<JwtokenInfo> {
	
	@Override protected JwtokenInfo enforceHook(JwtokenInfo recordInfo) {
		InfoSetter<JwtokenInfo> attrSetter = new JwtokenSetterToken();
		return attrSetter.setAttr(recordInfo);
	}
}
