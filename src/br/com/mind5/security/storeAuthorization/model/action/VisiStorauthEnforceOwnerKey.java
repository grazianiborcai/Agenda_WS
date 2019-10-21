package br.com.mind5.security.storeAuthorization.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.info.StorauthSetterOwnerKey;

final class VisiStorauthEnforceOwnerKey extends ActionVisitorTemplateEnforce<StorauthInfo> {
	
	@Override protected StorauthInfo enforceHook(StorauthInfo recordInfo) {
		InfoSetter<StorauthInfo> attrSetter = new StorauthSetterOwnerKey();
		return attrSetter.setAttr(recordInfo);
	}
}
