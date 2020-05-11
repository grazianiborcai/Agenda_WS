package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckExist;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedineCheckOrderem extends ModelCheckerTemplateForwardV2<SchedineInfo, OrderemInfo> {
	
	public SchedineCheckOrderem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrderemInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderemCheckExist(option);
	}
	
	
	
	@Override protected OrderemInfo toForwardClass(SchedineInfo baseRecord) {
		return OrderemInfo.copyFrom(baseRecord);
	}
}
