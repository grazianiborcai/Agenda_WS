package br.com.mind5.business.orderItemSnapshot.model.checker;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckExist;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrdemrapCheckOrderem extends ModelCheckerTemplateForward<OrdemrapInfo, OrderemInfo> {
	
	public OrdemrapCheckOrderem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OrderemInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderemCheckExist(option);
	}
	
	
	
	@Override protected OrderemInfo toForwardClass(OrdemrapInfo baseRecord) {
		return OrderemInfo.copyFrom(baseRecord);
	}
}
