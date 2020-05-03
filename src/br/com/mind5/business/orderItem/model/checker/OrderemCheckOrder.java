package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.checker.OrderCheckExist;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OrderemCheckOrder extends ModelCheckerTemplateForwardV2<OrderemInfo, OrderInfo> {
	
	public OrderemCheckOrder(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrderInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderCheckExist(option);
	}
	
	
	
	@Override protected OrderInfo toForwardClass(OrderemInfo baseRecord) {
		return OrderInfo.copyFrom(baseRecord);
	}
}
