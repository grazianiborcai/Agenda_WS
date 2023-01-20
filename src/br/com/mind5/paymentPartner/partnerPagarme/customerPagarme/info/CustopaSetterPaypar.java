package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;


public final class CustopaSetterPaypar extends InfoSetterTemplate<CustopaInfo> {
	
	@Override protected CustopaInfo setAttrHook(CustopaInfo recordInfo) {	
		recordInfo.codPayPartner = Paypar.PAGARME.getCodPayPartner();
		return recordInfo;
	}
}
