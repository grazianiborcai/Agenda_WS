package br.com.gda.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class PayordemCopyPayord extends InfoCopierOneToManyTemplate<PayordemInfo, PayordInfo>{
	
	public PayordemCopyPayord() {
		super();
	}
	
	
	
	@Override protected List<PayordemInfo> makeCopyHook(PayordInfo source) {	
		List<PayordemInfo> results = new ArrayList<>();
		
		for(OrderemInfo eachItem : source.orderData.orderms) {
			PayordemInfo oneResult = PayordemInfo.copyFrom(eachItem);
			oneResult.codPayOrder = source.codPayOrder;
			oneResult.codPayPartner = source.codPayPartner;
			
			results.add(oneResult);
		}
		
		return results;
	}
}
