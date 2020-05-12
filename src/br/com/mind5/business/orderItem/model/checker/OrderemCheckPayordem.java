package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckExist;

public final class OrderemCheckPayordem extends ModelCheckerTemplateForwardV2<OrderemInfo, PayordemInfo> {
	
	public OrderemCheckPayordem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PayordemInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordemCheckExist(option);
	}
	
	
	
	@Override protected PayordemInfo toForwardClass(OrderemInfo baseRecord) {
		return PayordemInfo.copyFrom(baseRecord);
	}
}
