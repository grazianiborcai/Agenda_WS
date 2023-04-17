package br.com.mind5.webhook.pagarmeHook.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckExist;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;

public final class PagookCheckPayordem extends ModelCheckerTemplateForward<PagookInfo, PayordemInfo> {
	
	public PagookCheckPayordem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayordemInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordemCheckExist(option);
	}
	
	
	
	@Override protected PayordemInfo toForwardClass(PagookInfo baseRecord) {
		return PayordemInfo.copyFrom(baseRecord);
	}
}
