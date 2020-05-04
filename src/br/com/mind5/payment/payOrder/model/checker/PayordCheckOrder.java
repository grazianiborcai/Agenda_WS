package br.com.mind5.payment.payOrder.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.checker.OrderCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckOrder extends ModelCheckerTemplateForwardV2<PayordInfo, OrderInfo> {
	
	public PayordCheckOrder(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrderInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderCheckExist(option);
	}
	
	
	
	@Override protected OrderInfo toForwardClass(PayordInfo baseRecord) {
		return OrderInfo.copyFrom(baseRecord);
	}
}
