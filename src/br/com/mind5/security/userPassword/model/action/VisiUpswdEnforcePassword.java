package br.com.mind5.security.userPassword.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.info.UpswdSetterPassword;

final class VisiUpswdEnforcePassword extends ActionVisitorTemplateEnforce<UpswdInfo> {
	
	@Override protected UpswdInfo enforceHook(UpswdInfo recordInfo) {
		InfoSetter<UpswdInfo> attrSetter = new UpswdSetterPassword();
		return attrSetter.setAttr(recordInfo);
	}
}
