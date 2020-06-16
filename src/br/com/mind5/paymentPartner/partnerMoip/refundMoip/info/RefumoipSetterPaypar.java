package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;

public final class RefumoipSetterPaypar extends InfoSetterTemplate<RefumoipInfo> {
	
	@Override protected RefumoipInfo setAttrHook(RefumoipInfo recordInfo) {
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		
		return recordInfo;
	}
}
