package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import br.com.mind5.business.masterData.info.common.Paypar;
import br.com.mind5.info.InfoSetterTemplate;


public final class CusmoipSetterPaypar extends InfoSetterTemplate<CusmoipInfo> {
	
	@Override protected CusmoipInfo setAttrHook(CusmoipInfo recordInfo) {	
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();
		return recordInfo;
	}
}
