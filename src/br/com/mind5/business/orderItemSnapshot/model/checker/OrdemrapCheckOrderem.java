package br.com.mind5.business.orderItemSnapshot.model.checker;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckExist;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OrdemrapCheckOrderem extends ModelCheckerTemplateForwardV2<OrdemrapInfo, OrderemInfo> {
	
	public OrdemrapCheckOrderem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrderemInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderemCheckExist(option);
	}
	
	
	
	@Override protected OrderemInfo toForwardClass(OrdemrapInfo baseRecord) {
		return OrderemInfo.copyFrom(baseRecord);
	}
}
