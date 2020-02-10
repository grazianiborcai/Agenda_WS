package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import br.com.mind5.business.masterData.info.common.Paypar;
import br.com.mind5.info.InfoSetter;


public final class CusmoipSetterPayPartner implements InfoSetter<CusmoipInfo> {
	
	public CusmoipInfo setAttr(CusmoipInfo recordInfo) {		
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		return recordInfo;
	}
}
