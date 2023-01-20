package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.config.payPartnerStoreCreation.info.PayrsocreInfo;
import br.com.mind5.config.payPartnerStoreCreation.model.checker.PayrsocreCheckEnabled;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckPayrsocre extends ModelCheckerTemplateForward<CusparInfo, PayrsocreInfo> {
	
	public CusparCheckPayrsocre(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayrsocreInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayrsocreCheckEnabled(option);
	}
	
	
	
	@Override protected PayrsocreInfo toForwardClass(CusparInfo baseRecord) {
		return PayrsocreInfo.copyFrom(baseRecord);
	}
}
