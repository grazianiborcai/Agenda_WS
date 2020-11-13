package br.com.mind5.payment.payOrder.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.checker.OrderCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckOrder extends ModelCheckerTemplateForward<PayordInfo, OrderInfo> {
	
	public PayordCheckOrder(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OrderInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderCheckExist(option);
	}
	
	
	
	@Override protected OrderInfo toForwardClass(PayordInfo baseRecord) {
		return OrderInfo.copyFrom(baseRecord);
	}
}
