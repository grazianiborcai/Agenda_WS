package br.com.mind5.payment.payOrder.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckExist;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckCrecard extends ModelCheckerTemplateForward<PayordInfo, CrecardInfo> {
	
	public PayordCheckCrecard(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CrecardInfo> getCheckerHook(ModelCheckerOption option) {
		return new CrecardCheckExist(option);
	}
	
	
	
	@Override protected CrecardInfo toForwardClass(PayordInfo baseRecord) {
		return CrecardInfo.copyFrom(baseRecord);
	}
}
