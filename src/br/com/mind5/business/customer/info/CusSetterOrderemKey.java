package br.com.mind5.business.customer.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CusSetterOrderemKey extends InfoSetterTemplate<CusInfo> {
	
	@Override protected CusInfo setAttrHook(CusInfo recordInfo) {
		CusInfo result = new CusInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codOrder = recordInfo.codOrder;
		result.codOrderItem = recordInfo.codOrderItem;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
