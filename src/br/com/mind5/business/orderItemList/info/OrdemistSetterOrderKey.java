package br.com.mind5.business.orderItemList.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdemistSetterOrderKey extends InfoSetterTemplate<OrdemistInfo> {
	
	@Override protected OrdemistInfo setAttrHook(OrdemistInfo recordInfo) {
		OrdemistInfo result = new OrdemistInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codOrder = recordInfo.codOrder;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
