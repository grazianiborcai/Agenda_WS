package br.com.mind5.security.jwtToken.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.info.JwtokenSetterCreatedOn;

final class VisiJwtokenEnforceCreatedOn extends ActionVisitorTemplateEnforceV2<JwtokenInfo> {
	
	public VisiJwtokenEnforceCreatedOn(DeciTreeOption<JwtokenInfo> option) {
		super(option);
	}

	
	
	@Override protected JwtokenInfo enforceHook(JwtokenInfo recordInfo) {
		InfoSetter<JwtokenInfo> attrSetter = new JwtokenSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
