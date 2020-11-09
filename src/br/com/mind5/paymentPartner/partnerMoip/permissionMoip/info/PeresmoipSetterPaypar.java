package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;

public final class PeresmoipSetterPaypar extends InfoSetterTemplate<PeresmoipInfo> {
	
	@Override protected PeresmoipInfo setAttrHook(PeresmoipInfo recordInfo) {
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();		
		return recordInfo;
	}
}
