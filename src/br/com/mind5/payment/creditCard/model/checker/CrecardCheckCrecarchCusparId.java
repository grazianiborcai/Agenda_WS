package br.com.mind5.payment.creditCard.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.checker.CrecarchCheckExistCusparId;

public final class CrecardCheckCrecarchCusparId extends ModelCheckerTemplateForward<CrecardInfo, CrecarchInfo> {
	
	public CrecardCheckCrecarchCusparId(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CrecarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CrecarchCheckExistCusparId(option);
	}
	
	
	
	@Override protected CrecarchInfo toForwardClass(CrecardInfo baseRecord) {
		return CrecarchInfo.copyFrom(baseRecord);
	}
}
