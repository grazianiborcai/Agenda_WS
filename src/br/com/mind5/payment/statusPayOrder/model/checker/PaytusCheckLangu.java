package br.com.mind5.payment.statusPayOrder.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class PaytusCheckLangu extends ModelCheckerTemplateForward<PaytusInfo, LanguInfo> {
	
	public PaytusCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PaytusInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
