package br.com.mind5.business.order.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckExist;

public final class OrderCheckPayord extends ModelCheckerTemplateForward<OrderInfo, PayordInfo> {
	
	public OrderCheckPayord(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordCheckExist(option);
	}
	
	
	
	@Override protected PayordInfo toForwardClass(OrderInfo baseRecord) {
		return PayordInfo.copyFrom(baseRecord);
	}
}
