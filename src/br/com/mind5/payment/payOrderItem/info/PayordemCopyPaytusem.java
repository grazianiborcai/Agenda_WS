package br.com.mind5.payment.payOrderItem.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

final class PayordemCopyPaytusem extends InfoCopierTemplate<PayordemInfo, PaytusemInfo>{
	
	public PayordemCopyPaytusem() {
		super();
	}
	
	
	
	@Override protected PayordemInfo makeCopyHook(PaytusemInfo source) {	
		PayordemInfo result = new PayordemInfo();
		
		result.codOwner = source.codOwner;
		result.codPayOrder = source.codPayOrder;
		result.codPayOrderItem = source.codPayOrderItem;
		result.codLanguage = source.codLanguage;
		result.username = source.username;		
		
		return result;
	}
}
