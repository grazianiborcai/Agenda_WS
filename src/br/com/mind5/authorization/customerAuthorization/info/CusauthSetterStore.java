package br.com.mind5.authorization.customerAuthorization.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CusauthSetterStore extends InfoSetterTemplate<CusauthInfo> {
	
	@Override protected CusauthInfo setAttrHook(CusauthInfo recordInfo) {
		recordInfo.codStore = DefaultValue.number();		
		return recordInfo;
	}
}
