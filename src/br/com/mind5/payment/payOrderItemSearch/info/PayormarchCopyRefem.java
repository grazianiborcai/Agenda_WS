package br.com.mind5.payment.payOrderItemSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

final class PayormarchCopyRefem extends InfoCopierTemplate<PayormarchInfo, RefemInfo> {
	
	public PayormarchCopyRefem() {
		super();
	}
	
	
	
	@Override protected PayormarchInfo makeCopyHook(RefemInfo source) {
		PayormarchInfo oneResult = new PayormarchInfo();
		
		oneResult.codOwner = source.codOwner;
		oneResult.codOrder = source.codOrder;
		oneResult.username = source.username;	
		oneResult.codLanguage = source.codLanguage;	
		
		return oneResult;
	}
}
