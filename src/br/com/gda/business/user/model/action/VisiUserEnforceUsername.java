package br.com.gda.business.user.model.action;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserSetterUsername;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiUserEnforceUsername extends ActionVisitorTemplateEnforce<UserInfo> {
	
	@Override protected UserInfo enforceHook(UserInfo recordInfo) {
		InfoSetter<UserInfo> attrSetter = new UserSetterUsername();
		return attrSetter.setAttr(recordInfo);
	}
}
