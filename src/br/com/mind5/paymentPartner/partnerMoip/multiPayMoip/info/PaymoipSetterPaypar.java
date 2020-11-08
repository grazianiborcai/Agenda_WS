package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;

public final class PaymoipSetterPaypar extends InfoSetterTemplate<PaymoipInfo> {
	
	@Override protected PaymoipInfo setAttrHook(PaymoipInfo recordInfo) {
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		
		return recordInfo;
	}
}
