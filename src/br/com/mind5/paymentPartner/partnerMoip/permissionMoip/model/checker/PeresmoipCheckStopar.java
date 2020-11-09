package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipCheckStopar extends ModelCheckerTemplateForwardV2<PeresmoipInfo, StoparInfo> {
	
	public PeresmoipCheckStopar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoparInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoparCheckExist(option);
	}
	
	
	
	@Override protected StoparInfo toForwardClass(PeresmoipInfo baseRecord) {
		return StoparInfo.copyFrom(baseRecord);
	}
}
