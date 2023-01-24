package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckExist;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;

public final class CrecapaCheckCuspar extends ModelCheckerTemplateForward<CrecapaInfo, CusparInfo> {
	
	public CrecapaCheckCuspar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusparInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusparCheckExist(option);
	}
	
	
	
	@Override protected CusparInfo toForwardClass(CrecapaInfo baseRecord) {
		return CusparInfo.copyFrom(baseRecord);
	}
}
