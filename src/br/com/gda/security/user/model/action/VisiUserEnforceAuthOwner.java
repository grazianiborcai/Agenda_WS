package br.com.gda.security.user.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.user.info.UserSetterAuthOwner;

final class VisiUserEnforceAuthOwner extends ActionVisitorTemplateEnforce<UserInfo> {
	
	@Override protected UserInfo enforceHook(UserInfo recordInfo) {
		InfoSetter<UserInfo> attrSetter = new UserSetterAuthOwner();
		return attrSetter.setAttr(recordInfo);
	}
}
