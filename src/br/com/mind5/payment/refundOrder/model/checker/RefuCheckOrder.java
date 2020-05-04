package br.com.mind5.payment.refundOrder.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.checker.OrderCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

public final class RefuCheckOrder extends ModelCheckerTemplateForwardV2<RefuInfo, OrderInfo> {
	
	public RefuCheckOrder(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrderInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderCheckExist(option);
	}
	
	
	
	@Override protected OrderInfo toForwardClass(RefuInfo baseRecord) {
		return OrderInfo.copyFrom(baseRecord);
	}
}
