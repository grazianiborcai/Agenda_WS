package br.com.mind5.security.userPassword.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.info.UpswdSetterPasswordRandom;

final class VisiUpswdEnforcePasswordRandom extends ActionVisitorTemplateEnforce<UpswdInfo> {
	
	@Override protected UpswdInfo enforceHook(UpswdInfo recordInfo) {
		InfoSetter<UpswdInfo> attrSetter = new UpswdSetterPasswordRandom();
		return attrSetter.setAttr(recordInfo);
	}
}
