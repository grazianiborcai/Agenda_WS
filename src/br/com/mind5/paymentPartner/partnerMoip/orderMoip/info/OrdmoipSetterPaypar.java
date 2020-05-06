package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import br.com.mind5.business.masterData.info.common.Paypar;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrdmoipSetterPaypar extends InfoSetterTemplate<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo setAttrHook(OrdmoipInfo recordInfo) {
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		
		return recordInfo;
	}
}
