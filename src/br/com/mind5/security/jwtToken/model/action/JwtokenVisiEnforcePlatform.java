package br.com.mind5.security.jwtToken.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.info.JwtokenSetterPlatform;

public final class JwtokenVisiEnforcePlatform extends ActionVisitorTemplateEnforce<JwtokenInfo> {
	
	public JwtokenVisiEnforcePlatform(DeciTreeOption<JwtokenInfo> option) {
		super(option);
	}
	
	
	
	@Override protected JwtokenInfo enforceHook(JwtokenInfo recordInfo) {
		InfoSetter<JwtokenInfo> attrSetter = new JwtokenSetterPlatform();
		return attrSetter.setAttr(recordInfo);
	}
}
