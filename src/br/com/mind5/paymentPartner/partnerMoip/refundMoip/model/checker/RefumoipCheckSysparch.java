package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.marketplacePartnerSearch.info.MktpararchCopier;
import br.com.mind5.payment.marketplacePartnerSearch.info.MktpararchInfo;
import br.com.mind5.payment.marketplacePartnerSearch.model.checker.MktpararchCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckSysparch extends ModelCheckerTemplateForward<RefumoipInfo, MktpararchInfo> {
	
	public RefumoipCheckSysparch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MktpararchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MktpararchCheckExist(option);
	}
	
	
	
	@Override protected MktpararchInfo toForwardClass(RefumoipInfo baseRecord) {
		return MktpararchCopier.copyFromRefumoip(baseRecord);
	}
}
