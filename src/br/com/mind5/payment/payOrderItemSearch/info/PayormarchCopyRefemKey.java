package br.com.mind5.payment.payOrderItemSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

final class PayormarchCopyRefemKey extends InfoCopierTemplate<PayormarchInfo, RefemInfo> {
	
	public PayormarchCopyRefemKey() {
		super();
	}
	
	
	
	@Override protected PayormarchInfo makeCopyHook(RefemInfo source) {
		PayormarchInfo oneResult = new PayormarchInfo();
		
		oneResult.codOwner = source.codOwner;
		oneResult.codPayOrder = source.codPayOrder;
		oneResult.codPayOrderItem = source.codPayOrderItem;
		oneResult.username = source.username;	
		oneResult.codLanguage = source.codLanguage;	
		
		return oneResult;
	}
}
