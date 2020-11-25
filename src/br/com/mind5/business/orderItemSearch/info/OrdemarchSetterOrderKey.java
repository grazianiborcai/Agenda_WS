package br.com.mind5.business.orderItemSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdemarchSetterOrderKey extends InfoSetterTemplate<OrdemarchInfo> {
	
	@Override protected OrdemarchInfo setAttrHook(OrdemarchInfo recordInfo) {
		OrdemarchInfo result = new OrdemarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codOrder = recordInfo.codOrder;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}	
}
