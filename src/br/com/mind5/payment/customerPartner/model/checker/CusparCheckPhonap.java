package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.business.phoneSnapshot.info.PhonapCopier;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckPhonap extends ModelCheckerTemplateForward<CusparInfo, PhonapInfo> {
	
	public CusparCheckPhonap(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PhonapInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhonapCheckExist(option);
	}
	
	
	
	@Override protected PhonapInfo toForwardClass(CusparInfo baseRecord) {
		return PhonapCopier.copyFromCuspar(baseRecord);
	}
}
