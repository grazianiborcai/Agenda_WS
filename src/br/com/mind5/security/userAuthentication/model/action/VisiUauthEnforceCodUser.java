package br.com.mind5.security.userAuthentication.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userAuthentication.info.UauthSetterCodUser;

final class VisiUauthEnforceCodUser extends ActionVisitorTemplateEnforce<UauthInfo> {
	
	@Override protected UauthInfo enforceHook(UauthInfo recordInfo) {
		InfoSetter<UauthInfo> attrSetter = new UauthSetterCodUser();
		return attrSetter.setAttr(recordInfo);
	}
}
