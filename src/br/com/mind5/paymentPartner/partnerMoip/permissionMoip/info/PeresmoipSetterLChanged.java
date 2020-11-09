package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PeresmoipSetterLChanged extends InfoSetterTemplate<PeresmoipInfo> {
	
	@Override protected PeresmoipInfo setAttrHook(PeresmoipInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
