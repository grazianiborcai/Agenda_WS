package br.com.mind5.security.jwtToken.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.info.JwtokenSetterToken;

public final class JwtokenVisiEnforceToken extends ActionVisitorTemplateEnforce<JwtokenInfo> {
	
	public JwtokenVisiEnforceToken(DeciTreeOption<JwtokenInfo> option) {
		super(option);
	}
	
	
	
	@Override protected JwtokenInfo enforceHook(JwtokenInfo recordInfo) {
		InfoSetter<JwtokenInfo> attrSetter = new JwtokenSetterToken();
		return attrSetter.setAttr(recordInfo);
	}
}
