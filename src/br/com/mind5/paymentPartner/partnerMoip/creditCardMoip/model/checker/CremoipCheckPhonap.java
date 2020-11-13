package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker;

import br.com.mind5.business.phoneSnapshot.info.PhonapCopier;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckPhonap extends ModelCheckerTemplateForward<CremoipInfo, PhonapInfo> {
	
	public CremoipCheckPhonap(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PhonapInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhonapCheckExist(option);
	}
	
	
	
	@Override protected PhonapInfo toForwardClass(CremoipInfo baseRecord) {
		return PhonapCopier.copyFromCremoip(baseRecord);
	}
}
