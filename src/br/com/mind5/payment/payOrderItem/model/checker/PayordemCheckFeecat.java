package br.com.mind5.payment.payOrderItem.model.checker;

import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.checker.FeecatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckFeecat extends ModelCheckerTemplateForward<PayordemInfo, FeecatInfo> {
	
	public PayordemCheckFeecat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<FeecatInfo> getCheckerHook(ModelCheckerOption option) {
		return new FeecatCheckExist(option);
	}
	
	
	
	@Override protected FeecatInfo toForwardClass(PayordemInfo baseRecord) {
		return FeecatInfo.copyFrom(baseRecord);
	}
}
