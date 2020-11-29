package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckExistSytotauh;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class OrderemCheckCusarch extends ModelCheckerTemplateForward<OrderemInfo, CusarchInfo> {
	
	public OrderemCheckCusarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusarchCheckExistSytotauh(option);
	}
	
	
	
	@Override protected CusarchInfo toForwardClass(OrderemInfo baseRecord) {
		return CusarchInfo.copyFrom(baseRecord);
	}
}
