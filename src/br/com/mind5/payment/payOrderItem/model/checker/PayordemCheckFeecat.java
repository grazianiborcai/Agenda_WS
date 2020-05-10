package br.com.mind5.payment.payOrderItem.model.checker;

import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.checker.FeecatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckFeecat extends ModelCheckerTemplateForwardV2<PayordemInfo, FeecatInfo> {
	
	public PayordemCheckFeecat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<FeecatInfo> getCheckerHook(ModelCheckerOption option) {
		return new FeecatCheckExist(option);
	}
	
	
	
	@Override protected FeecatInfo toForwardClass(PayordemInfo baseRecord) {
		return FeecatInfo.copyFrom(baseRecord);
	}
}
