package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import br.com.mind5.business.masterData.info.common.Paypar;
import br.com.mind5.info.InfoSetterTemplate;


public final class CremoipSetterPaypar extends InfoSetterTemplate<CremoipInfo> {
	
	@Override protected CremoipInfo setAttrHook(CremoipInfo recordInfo) {	
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		return recordInfo;
	}
}
