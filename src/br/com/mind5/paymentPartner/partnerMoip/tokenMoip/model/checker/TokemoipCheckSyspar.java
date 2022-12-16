package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.marketplacePartner.model.checker.MktparCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class TokemoipCheckSyspar extends ModelCheckerTemplateForward<TokemoipInfo, MktparInfo> {
	
	public TokemoipCheckSyspar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MktparInfo> getCheckerHook(ModelCheckerOption option) {
		return new MktparCheckExist(option);
	}
	
	
	
	@Override protected MktparInfo toForwardClass(TokemoipInfo baseRecord) {
		return MktparInfo.copyFrom(baseRecord);
	}
}
