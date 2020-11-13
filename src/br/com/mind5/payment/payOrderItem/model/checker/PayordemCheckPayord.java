package br.com.mind5.payment.payOrderItem.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckExist;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckPayord extends ModelCheckerTemplateForward<PayordemInfo, PayordInfo> {
	
	public PayordemCheckPayord(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordCheckExist(option);
	}
	
	
	
	@Override protected PayordInfo toForwardClass(PayordemInfo baseRecord) {
		return PayordInfo.copyFrom(baseRecord);
	}
}
