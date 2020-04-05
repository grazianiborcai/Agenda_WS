package br.com.mind5.security.user.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserSetterLChangedBy;

final class VisiUserEnforceLChangedBy extends ActionVisitorTemplateEnforceV1<UserInfo> {
	
	@Override protected UserInfo enforceHook(UserInfo recordInfo) {
		InfoSetter<UserInfo> attrSetter = new UserSetterLChangedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
