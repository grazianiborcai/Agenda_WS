package br.com.mind5.payment.payOrderItemSearch.model.checker;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class PayormarchCheckLangu extends ModelCheckerTemplateForward<PayormarchInfo, LanguInfo> {
	
	public PayormarchCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(PayormarchInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
