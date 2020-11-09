package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;

public final class AccemoipSetterCodPayPartner extends InfoSetterTemplate<AccemoipInfo> {
	
	@Override protected AccemoipInfo setAttrHook(AccemoipInfo recordInfo) {
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();		
		return recordInfo;
	}
}
