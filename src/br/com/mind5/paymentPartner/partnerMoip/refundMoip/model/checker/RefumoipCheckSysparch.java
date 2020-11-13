package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchCopier;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;
import br.com.mind5.payment.systemPartnerSearch.model.checker.SysparchCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckSysparch extends ModelCheckerTemplateForward<RefumoipInfo, SysparchInfo> {
	
	public RefumoipCheckSysparch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SysparchInfo> getCheckerHook(ModelCheckerOption option) {
		return new SysparchCheckExist(option);
	}
	
	
	
	@Override protected SysparchInfo toForwardClass(RefumoipInfo baseRecord) {
		return SysparchCopier.copyFromRefumoip(baseRecord);
	}
}
