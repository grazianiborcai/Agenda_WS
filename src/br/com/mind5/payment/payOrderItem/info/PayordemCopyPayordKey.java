package br.com.mind5.payment.payOrderItem.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class PayordemCopyPayordKey extends InfoCopierTemplate<PayordemInfo, PayordInfo>{
	
	public PayordemCopyPayordKey() {
		super();
	}
	
	
	
	@Override protected PayordemInfo makeCopyHook(PayordInfo source) {	
		PayordemInfo result = new PayordemInfo();
		
		result.codOwner = source.codOwner;
		result.codPayOrder = source.codPayOrder;
		result.codLanguage = source.codLanguage;
		result.username = source.username;		
		
		return result;
	}
}
