package br.com.gda.security.userAuthentication.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.security.userAuthentication.info.UauthInfo;
import br.com.gda.security.userAuthentication.info.UauthSetterCodUser;

final class VisiUauthEnforceCodUser extends ActionVisitorTemplateEnforce<UauthInfo> {
	
	@Override protected UauthInfo enforceHook(UauthInfo recordInfo) {
		InfoSetter<UauthInfo> attrSetter = new UauthSetterCodUser();
		return attrSetter.setAttr(recordInfo);
	}
}
