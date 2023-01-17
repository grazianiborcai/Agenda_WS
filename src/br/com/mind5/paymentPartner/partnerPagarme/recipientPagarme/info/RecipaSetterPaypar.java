package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;


public final class RecipaSetterPaypar extends InfoSetterTemplate<RecipaInfo> {
	
	@Override protected RecipaInfo setAttrHook(RecipaInfo recordInfo) {	
		recordInfo.codPayPartner = Paypar.PAGARME.getCodPayPartner();
		return recordInfo;
	}
}
