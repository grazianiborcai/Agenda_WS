package br.com.mind5.business.orderItem.model.checker;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.checker.EmposarchCheckExist;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OrderemCheckEmposarch extends ModelCheckerTemplateForward<OrderemInfo, EmposarchInfo> {
	
	public OrderemCheckEmposarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmposarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmposarchCheckExist(option);
	}
	
	
	
	@Override protected EmposarchInfo toForwardClass(OrderemInfo baseRecord) {
		return EmposarchInfo.copyFrom(baseRecord);
	}
}
