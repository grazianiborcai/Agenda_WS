package br.com.mind5.payment.creditCard.model.checker;

import br.com.mind5.business.phoneSnapshot.info.PhonapCopier;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckPhonap extends ModelCheckerTemplateForward<CrecardInfo, PhonapInfo> {
	
	public CrecardCheckPhonap(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PhonapInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhonapCheckExist(option);
	}
	
	
	
	@Override protected PhonapInfo toForwardClass(CrecardInfo baseRecord) {
		return PhonapCopier.copyFromCrecard(baseRecord);
	}
}
