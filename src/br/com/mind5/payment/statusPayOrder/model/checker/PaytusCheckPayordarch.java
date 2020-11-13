package br.com.mind5.payment.statusPayOrder.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.model.checker.PayordarchCheckExistAuth;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class PaytusCheckPayordarch extends ModelCheckerTemplateForward<PaytusInfo, PayordarchInfo> {
	
	public PaytusCheckPayordarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordarchCheckExistAuth(option);
	}
	
	
	
	@Override protected PayordarchInfo toForwardClass(PaytusInfo baseRecord) {
		return PayordarchInfo.copyFrom(baseRecord);
	}
}
