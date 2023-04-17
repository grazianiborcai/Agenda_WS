package br.com.mind5.webhook.pagarmeHook.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckExist;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;

public final class PagookCheckPayord extends ModelCheckerTemplateForward<PagookInfo, PayordInfo> {
	
	public PagookCheckPayord(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordCheckExist(option);
	}
	
	
	
	@Override protected PayordInfo toForwardClass(PagookInfo baseRecord) {
		return PayordInfo.copyFrom(baseRecord);
	}
}
