package br.com.mind5.business.order.model.checker;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckExist;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class OrderCheckCusarch extends ModelCheckerTemplateForward<OrderInfo, CusarchInfo> {
	
	public OrderCheckCusarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusarchCheckExist(option);
	}
	
	
	
	@Override protected CusarchInfo toForwardClass(OrderInfo baseRecord) {
		return CusarchInfo.copyFrom(baseRecord);
	}
}
