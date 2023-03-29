package br.com.mind5.payment.refundOrderItem.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.checker.PayormarchCheckExistReverted;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckReverted extends ModelCheckerTemplateForward<RefemInfo, PayormarchInfo> {
	
	public RefemCheckReverted(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayormarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayormarchCheckExistReverted(option);
	}
	
	
	
	@Override protected PayormarchInfo toForwardClass(RefemInfo baseRecord) {
		return PayormarchInfo.copyFrom(baseRecord);
	}
}
