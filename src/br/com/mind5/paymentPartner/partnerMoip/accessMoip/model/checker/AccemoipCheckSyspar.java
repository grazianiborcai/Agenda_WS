package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.checker.SysparCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class AccemoipCheckSyspar extends ModelCheckerTemplateForward<AccemoipInfo, SysparInfo> {
	
	public AccemoipCheckSyspar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SysparInfo> getCheckerHook(ModelCheckerOption option) {
		return new SysparCheckExist(option);
	}
	
	
	
	@Override protected SysparInfo toForwardClass(AccemoipInfo baseRecord) {
		return SysparInfo.copyFrom(baseRecord);
	}
}
