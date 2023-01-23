package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.config.payPartnerCustomerCreation.info.PayrcucreInfo;
import br.com.mind5.config.payPartnerCustomerCreation.model.checker.PayrcucreCheckEnabled;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckPayrcucre extends ModelCheckerTemplateForward<CusparInfo, PayrcucreInfo> {
	
	public CusparCheckPayrcucre(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PayrcucreInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayrcucreCheckEnabled(option);
	}
	
	
	
	@Override protected PayrcucreInfo toForwardClass(CusparInfo baseRecord) {
		return PayrcucreInfo.copyFrom(baseRecord);
	}
}
