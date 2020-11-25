package br.com.mind5.business.customer.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.checker.OrderCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class CusCheckOrder extends ModelCheckerTemplateForward<CusInfo, OrderInfo> {
	
	public CusCheckOrder(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OrderInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderCheckExist(option);
	}
	
	
	
	@Override protected OrderInfo toForwardClass(CusInfo baseRecord) {
		return OrderInfo.copyFrom(baseRecord);
	}
}
