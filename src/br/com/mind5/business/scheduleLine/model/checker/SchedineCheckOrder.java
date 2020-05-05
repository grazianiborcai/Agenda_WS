package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.checker.OrderCheckExist;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedineCheckOrder extends ModelCheckerTemplateForwardV2<SchedineInfo, OrderInfo> {
	
	public SchedineCheckOrder(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrderInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderCheckExist(option);
	}
	
	
	
	@Override protected OrderInfo toForwardClass(SchedineInfo baseRecord) {
		return OrderInfo.copyFrom(baseRecord);
	}
}
