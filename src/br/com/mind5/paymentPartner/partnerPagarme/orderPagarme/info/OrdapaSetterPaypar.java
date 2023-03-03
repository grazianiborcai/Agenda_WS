package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;


public final class OrdapaSetterPaypar extends InfoSetterTemplate<OrdapaInfo> {
	
	@Override protected OrdapaInfo setAttrHook(OrdapaInfo recordInfo) {	
		recordInfo.codPayPartner = Paypar.PAGARME.getCodPayPartner();
		return recordInfo;
	}
}
