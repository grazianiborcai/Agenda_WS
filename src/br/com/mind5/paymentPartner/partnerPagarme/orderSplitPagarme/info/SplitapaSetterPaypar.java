package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;


public final class SplitapaSetterPaypar extends InfoSetterTemplate<SplitapaInfo> {
	
	@Override protected SplitapaInfo setAttrHook(SplitapaInfo recordInfo) {	
		recordInfo.codPayPartner = Paypar.PAGARME.getCodPayPartner();
		return recordInfo;
	}
}
