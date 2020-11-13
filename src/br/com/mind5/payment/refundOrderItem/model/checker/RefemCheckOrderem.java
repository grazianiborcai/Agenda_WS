package br.com.mind5.payment.refundOrderItem.model.checker;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckOrderem extends ModelCheckerTemplateForward<RefemInfo, OrderemInfo> {
	
	public RefemCheckOrderem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OrderemInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderemCheckExist(option);
	}
	
	
	
	@Override protected OrderemInfo toForwardClass(RefemInfo baseRecord) {
		return OrderemInfo.copyFrom(baseRecord);
	}
}
