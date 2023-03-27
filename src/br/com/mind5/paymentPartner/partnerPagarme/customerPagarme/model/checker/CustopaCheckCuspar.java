package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckExist;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;

public final class CustopaCheckCuspar extends ModelCheckerTemplateForward<CustopaInfo, CusparInfo> {
	
	public CustopaCheckCuspar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusparInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusparCheckExist(option);
	}
	
	
	
	@Override protected CusparInfo toForwardClass(CustopaInfo baseRecord) {
		return CusparInfo.copyFrom(baseRecord);
	}
}
