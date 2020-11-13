package br.com.mind5.payment.payOrderList.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class PayordistCheckLangu extends ModelCheckerTemplateForwardV2<PayordistInfo, LanguInfo> {
	
	public PayordistCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PayordistInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
