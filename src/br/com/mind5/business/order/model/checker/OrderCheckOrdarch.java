package br.com.mind5.business.order.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.checker.OrdarchCheckExistAuth;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OrderCheckOrdarch extends ModelCheckerTemplateForwardV2<OrderInfo, OrdarchInfo> {
	
	public OrderCheckOrdarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrdarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrdarchCheckExistAuth(option);
	}
	
	
	
	@Override protected OrdarchInfo toForwardClass(OrderInfo baseRecord) {
		return OrdarchInfo.copyFrom(baseRecord);
	}
}
