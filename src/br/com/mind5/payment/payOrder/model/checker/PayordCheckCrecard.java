package br.com.mind5.payment.payOrder.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckExist;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckCrecard extends ModelCheckerTemplateForwardV2<PayordInfo, CrecardInfo> {
	
	public PayordCheckCrecard(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CrecardInfo> getCheckerHook(ModelCheckerOption option) {
		return new CrecardCheckExist(option);
	}
	
	
	
	@Override protected CrecardInfo toForwardClass(PayordInfo baseRecord) {
		return CrecardInfo.copyFrom(baseRecord);
	}
}
