package br.com.mind5.payment.statusPayOrderItem.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class PaytusemCheckLangu extends ModelCheckerTemplateForward<PaytusemInfo, LanguInfo> {
	
	public PaytusemCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PaytusemInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
