package br.com.mind5.payment.statusPayOrder.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.model.checker.PayordarchCheckExist;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class PaytusCheckPayordarch extends ModelCheckerTemplateForwardV2<PaytusInfo, PayordarchInfo> {
	
	public PaytusCheckPayordarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PayordarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordarchCheckExist(option);
	}
	
	
	
	@Override protected PayordarchInfo toForwardClass(PaytusInfo baseRecord) {
		return PayordarchInfo.copyFrom(baseRecord);
	}
}
