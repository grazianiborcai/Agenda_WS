package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;

public final class CustopaCheckCus extends ModelCheckerTemplateForward<CustopaInfo, CusInfo> {
	
	public CustopaCheckCus(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusCheckExist(option);
	}
	
	
	
	@Override protected CusInfo toForwardClass(CustopaInfo baseRecord) {
		return CusInfo.copyFrom(baseRecord);
	}
}
