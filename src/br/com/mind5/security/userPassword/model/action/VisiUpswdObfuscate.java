package br.com.mind5.security.userPassword.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.info.UpswdSetterObfuscate;

final class VisiUpswdObfuscate extends ActionVisitorTemplateEnforceV2<UpswdInfo> {
	
	public VisiUpswdObfuscate(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected UpswdInfo enforceHook(UpswdInfo recordInfo) {
		InfoSetter<UpswdInfo> attrSetter = new UpswdSetterObfuscate();
		return attrSetter.setAttr(recordInfo);
	}
}
