package br.com.mind5.business.order.model.checker;

import br.com.mind5.business.customerSearch.info.CusarchCopier;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckExist;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OrderCheckCusarch extends ModelCheckerTemplateForwardV2<OrderInfo, CusarchInfo> {
	
	public OrderCheckCusarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CusarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusarchCheckExist(option);
	}
	
	
	
	@Override protected CusarchInfo toForwardClass(OrderInfo baseRecord) {
		return CusarchCopier.copyFromOrder(baseRecord);
	}
}
