package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;


public final class CusmoipSetterPaypar extends InfoSetterTemplate<CusmoipInfo> {
	
	@Override protected CusmoipInfo setAttrHook(CusmoipInfo recordInfo) {	
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		return recordInfo;
	}
}
