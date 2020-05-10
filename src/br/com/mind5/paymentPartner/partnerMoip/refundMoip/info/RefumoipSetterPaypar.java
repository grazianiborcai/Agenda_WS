package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import br.com.mind5.business.masterData.info.common.Paypar;
import br.com.mind5.info.InfoSetterTemplate;

public final class RefumoipSetterPaypar extends InfoSetterTemplate<RefumoipInfo> {
	
	@Override protected RefumoipInfo setAttrHook(RefumoipInfo recordInfo) {
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		
		return recordInfo;
	}
}
