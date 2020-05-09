package br.com.mind5.payment.refundOrderItem.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.checker.OrderCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckOrder extends ModelCheckerTemplateForwardV2<RefemInfo, OrderInfo> {
	
	public RefemCheckOrder(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrderInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderCheckExist(option);
	}
	
	
	
	@Override protected OrderInfo toForwardClass(RefemInfo baseRecord) {
		return OrderInfo.copyFrom(baseRecord);
	}
}
