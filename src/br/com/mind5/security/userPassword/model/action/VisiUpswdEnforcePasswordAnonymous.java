package br.com.mind5.security.userPassword.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.info.UpswdSetterPasswordAnonymous;

final class VisiUpswdEnforcePasswordAnonymous extends ActionVisitorTemplateEnforce<UpswdInfo> {
	
	public VisiUpswdEnforcePasswordAnonymous(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected UpswdInfo enforceHook(UpswdInfo recordInfo) {
		InfoSetter<UpswdInfo> attrSetter = new UpswdSetterPasswordAnonymous();
		return attrSetter.setAttr(recordInfo);
	}
}
