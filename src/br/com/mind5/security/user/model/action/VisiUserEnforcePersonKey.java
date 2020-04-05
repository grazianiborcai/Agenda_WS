package br.com.mind5.security.user.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserSetterPersonKey;

final class VisiUserEnforcePersonKey extends ActionVisitorTemplateEnforceV1<UserInfo> {
	
	@Override protected UserInfo enforceHook(UserInfo recordInfo) {
		InfoSetter<UserInfo> attrSetter = new UserSetterPersonKey();
		return attrSetter.setAttr(recordInfo);
	}
}
