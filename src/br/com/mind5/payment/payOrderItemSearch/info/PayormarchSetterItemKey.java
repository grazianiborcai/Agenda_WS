package br.com.mind5.payment.payOrderItemSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PayormarchSetterItemKey extends InfoSetterTemplate<PayormarchInfo> {
	
	@Override protected PayormarchInfo setAttrHook(PayormarchInfo recordInfo) {
		PayormarchInfo result = new PayormarchInfo();		
		
		result.codOwner        = recordInfo.codOwner;				
		result.username        = recordInfo.username;	
		result.codLanguage     = recordInfo.codLanguage;
		result.codPayOrder     = recordInfo.codPayOrder;
		result.codPayOrderItem = recordInfo.codPayOrderItem;
		
		return result;
	}
}
