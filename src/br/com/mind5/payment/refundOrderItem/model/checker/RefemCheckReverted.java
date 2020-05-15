package br.com.mind5.payment.refundOrderItem.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchCopier;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.checker.PayormarchCheckExistReverted;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckReverted extends ModelCheckerTemplateForwardV2<RefemInfo, PayormarchInfo> {
	
	public RefemCheckReverted(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PayormarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayormarchCheckExistReverted(option);
	}
	
	
	
	@Override protected PayormarchInfo toForwardClass(RefemInfo baseRecord) {
		return PayormarchCopier.copyFromRefemKey(baseRecord);
	}
}
