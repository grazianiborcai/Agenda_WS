package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.checker.SysparCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class AccemoipCheckSyspar extends ModelCheckerTemplateForwardV2<AccemoipInfo, SysparInfo> {
	
	public AccemoipCheckSyspar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SysparInfo> getCheckerHook(ModelCheckerOption option) {
		return new SysparCheckExist(option);
	}
	
	
	
	@Override protected SysparInfo toForwardClass(AccemoipInfo baseRecord) {
		return SysparInfo.copyFrom(baseRecord);
	}
}
