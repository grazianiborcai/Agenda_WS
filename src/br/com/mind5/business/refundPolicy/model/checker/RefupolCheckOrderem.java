package br.com.mind5.business.refundPolicy.model.checker;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckExist;
import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class RefupolCheckOrderem extends ModelCheckerTemplateForwardV2<RefupolInfo, OrderemInfo> {
	
	public RefupolCheckOrderem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrderemInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderemCheckExist(option);
	}
	
	
	
	@Override protected OrderemInfo toForwardClass(RefupolInfo baseRecord) {
		return OrderemInfo.copyFrom(baseRecord);
	}
}
