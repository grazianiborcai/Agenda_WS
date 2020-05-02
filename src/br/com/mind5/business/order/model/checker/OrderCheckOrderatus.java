package br.com.mind5.business.order.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.masterData.orderStatus.model.checker.OrderatusCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OrderCheckOrderatus extends ModelCheckerTemplateForwardV2<OrderInfo, OrderatusInfo> {
	
	public OrderCheckOrderatus(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrderatusInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderatusCheckExist(option);
	}
	
	
	
	@Override protected OrderatusInfo toForwardClass(OrderInfo baseRecord) {
		return OrderatusInfo.copyFrom(baseRecord);
	}
}
