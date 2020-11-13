package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckExist;

public final class OrderemCheckPayordem extends ModelCheckerTemplateForward<OrderemInfo, PayordemInfo> {
	
	public OrderemCheckPayordem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordemInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordemCheckExist(option);
	}
	
	
	
	@Override protected PayordemInfo toForwardClass(OrderemInfo baseRecord) {
		return PayordemInfo.copyFrom(baseRecord);
	}
}
