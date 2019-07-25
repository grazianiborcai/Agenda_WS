package br.com.gda.payment.payOrderItem.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class PayordemCopyPayordToRead extends InfoCopierTemplate<PayordemInfo, PayordInfo>{
	
	public PayordemCopyPayordToRead() {
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
