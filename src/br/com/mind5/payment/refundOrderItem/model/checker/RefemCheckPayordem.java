package br.com.mind5.payment.refundOrderItem.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.checker.PayordemCheckExist;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckPayordem extends ModelCheckerTemplateForwardV2<RefemInfo, PayordemInfo> {
	
	public RefemCheckPayordem(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PayordemInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayordemCheckExist(option);
	}
	
	
	
	@Override protected PayordemInfo toForwardClass(RefemInfo baseRecord) {
		return PayordemInfo.copyFrom(baseRecord);
	}
}
