package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import br.com.mind5.business.masterData.info.common.Paypar;
import br.com.mind5.info.InfoSetter;


public final class CremoipSetterPaypar implements InfoSetter<CremoipInfo> {
	
	public CremoipInfo setAttr(CremoipInfo recordInfo) {		
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		return recordInfo;
	}
}
