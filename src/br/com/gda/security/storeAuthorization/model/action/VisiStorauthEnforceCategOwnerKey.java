package br.com.gda.security.storeAuthorization.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;
import br.com.gda.security.storeAuthorization.info.StorauthSetterCategOwnerKey;

final class VisiStorauthEnforceCategOwnerKey extends ActionVisitorTemplateEnforce<StorauthInfo> {
	
	@Override protected StorauthInfo enforceHook(StorauthInfo recordInfo) {
		InfoSetter<StorauthInfo> attrSetter = new StorauthSetterCategOwnerKey();
		return attrSetter.setAttr(recordInfo);
	}
}
