package br.com.mind5.security.storeAuthorization.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class StorauthSetterOwnerKey extends InfoSetterTemplate<StorauthInfo> {
	
	@Override protected StorauthInfo setAttrHook(StorauthInfo recordInfo) {
		recordInfo.codUser = DefaultValue.number();		
		return recordInfo;
	}
}
