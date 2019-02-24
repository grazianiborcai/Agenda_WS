package br.com.gda.security.jwtToken.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.jwtToken.info.JwtokenSetterSecret;

final class VisiJwtokenEnforceSecret extends ActionVisitorTemplateEnforce<JwtokenInfo> {
	
	@Override protected JwtokenInfo enforceHook(JwtokenInfo recordInfo) {
		InfoSetter<JwtokenInfo> attrSetter = new JwtokenSetterSecret();
		return attrSetter.setAttr(recordInfo);
	}
}
