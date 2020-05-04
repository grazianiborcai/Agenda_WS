package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker;

import br.com.mind5.business.phoneSnapshot.info.PhonapCopier;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.checker.PhonapCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckPhonap extends ModelCheckerTemplateForwardV2<CusmoipInfo, PhonapInfo> {
	
	public CusmoipCheckPhonap(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PhonapInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhonapCheckExist(option);
	}
	
	
	
	@Override protected PhonapInfo toForwardClass(CusmoipInfo baseRecord) {
		return PhonapCopier.copyFromCusmoip(baseRecord);
	}
}
