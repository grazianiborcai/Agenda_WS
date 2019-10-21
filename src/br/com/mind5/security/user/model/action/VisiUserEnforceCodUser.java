package br.com.mind5.security.user.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserSetterCodUser;

final class VisiUserEnforceCodUser extends ActionVisitorTemplateEnforce<UserInfo> {
	
	@Override protected UserInfo enforceHook(UserInfo recordInfo) {
		InfoSetter<UserInfo> attrSetter = new UserSetterCodUser();
		return attrSetter.setAttr(recordInfo);
	}
}
