package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;

public final class MultmoipSetterPaypar extends InfoSetterTemplate<MultmoipInfo> {
	
	@Override protected MultmoipInfo setAttrHook(MultmoipInfo recordInfo) {
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		
		return recordInfo;
	}	
}
