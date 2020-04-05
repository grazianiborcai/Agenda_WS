package br.com.mind5.security.storeAuthorization.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.info.StorauthSetterOwnerKey;

final class VisiStorauthEnforceOwnerKey extends ActionVisitorTemplateEnforceV1<StorauthInfo> {
	
	@Override protected StorauthInfo enforceHook(StorauthInfo recordInfo) {
		InfoSetter<StorauthInfo> attrSetter = new StorauthSetterOwnerKey();
		return attrSetter.setAttr(recordInfo);
	}
}
