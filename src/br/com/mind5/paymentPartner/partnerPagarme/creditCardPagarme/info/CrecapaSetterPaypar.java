package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;


public final class CrecapaSetterPaypar extends InfoSetterTemplate<CrecapaInfo> {
	
	@Override protected CrecapaInfo setAttrHook(CrecapaInfo recordInfo) {	
		recordInfo.codPayPartner = Paypar.PAGARME.getCodPayPartner();
		return recordInfo;
	}
}
