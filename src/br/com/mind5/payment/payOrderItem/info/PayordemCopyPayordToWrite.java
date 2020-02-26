package br.com.mind5.payment.payOrderItem.info;

import java.util.List;

import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class PayordemCopyPayordToWrite extends InfoCopierOneToManyTemplate<PayordemInfo, PayordInfo>{
	
	public PayordemCopyPayordToWrite() {
		super();
	}
	
	
	
	@Override protected List<PayordemInfo> makeCopyHook(PayordInfo source) {
		return source.payordems;
	}
}
