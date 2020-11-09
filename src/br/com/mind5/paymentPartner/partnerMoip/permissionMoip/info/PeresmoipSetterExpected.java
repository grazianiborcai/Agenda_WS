package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PeresmoipSetterExpected extends InfoSetterTemplate<PeresmoipInfo> {
	
	@Override protected PeresmoipInfo setAttrHook(PeresmoipInfo recordInfo) {
		recordInfo.isExpected = true;
		return recordInfo;
	}
}
