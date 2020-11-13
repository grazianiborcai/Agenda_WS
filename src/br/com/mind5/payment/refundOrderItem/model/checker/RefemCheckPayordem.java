package br.com.mind5.payment.refundOrderItem.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckExist;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckPayordem extends ModelCheckerTemplateForward<RefemInfo, PayordemInfo> {
	
	public RefemCheckPayordem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordemInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordemCheckExist(option);
	}
	
	
	
	@Override protected PayordemInfo toForwardClass(RefemInfo baseRecord) {
		return PayordemInfo.copyFrom(baseRecord);
	}
}
