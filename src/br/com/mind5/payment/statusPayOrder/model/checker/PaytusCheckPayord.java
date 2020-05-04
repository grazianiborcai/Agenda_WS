package br.com.mind5.payment.statusPayOrder.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckExist;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class PaytusCheckPayord extends ModelCheckerTemplateForwardV2<PaytusInfo, PayordInfo> {
	
	public PaytusCheckPayord(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PayordInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordCheckExist(option);
	}
	
	
	
	@Override protected PayordInfo toForwardClass(PaytusInfo baseRecord) {
		return PayordInfo.copyFrom(baseRecord);
	}
}
