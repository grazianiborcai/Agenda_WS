package br.com.mind5.payment.payOrderItemSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

final class PayormarchCopyRefu extends InfoCopierTemplate<PayormarchInfo, RefuInfo>{
	
	public PayormarchCopyRefu() {
		super();
	}
	
	
	
	@Override protected PayormarchInfo makeCopyHook(RefuInfo source) {
		PayormarchInfo oneResult = new PayormarchInfo();
		
		oneResult.codOwner = source.codOwner;
		oneResult.codPayOrder = source.codPayOrder;
		oneResult.username = source.username;	
		oneResult.codLanguage = source.codLanguage;	
		
		return oneResult;
	}
}
