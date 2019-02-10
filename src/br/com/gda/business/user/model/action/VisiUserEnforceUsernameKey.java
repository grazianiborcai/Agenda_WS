package br.com.gda.business.user.model.action;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserSetterUsernameKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiUserEnforceUsernameKey extends ActionVisitorTemplateEnforce<UserInfo> {
	
	@Override protected UserInfo enforceHook(UserInfo recordInfo) {
		InfoSetter<UserInfo> attrSetter = new UserSetterUsernameKey();
		return attrSetter.setAttr(recordInfo);
	}
}
