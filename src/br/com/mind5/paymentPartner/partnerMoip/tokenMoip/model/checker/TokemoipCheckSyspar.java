package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.checker.SysparCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class TokemoipCheckSyspar extends ModelCheckerTemplateForward<TokemoipInfo, SysparInfo> {
	
	public TokemoipCheckSyspar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SysparInfo> getCheckerHook(ModelCheckerOption option) {
		return new SysparCheckExist(option);
	}
	
	
	
	@Override protected SysparInfo toForwardClass(TokemoipInfo baseRecord) {
		return SysparInfo.copyFrom(baseRecord);
	}
}
