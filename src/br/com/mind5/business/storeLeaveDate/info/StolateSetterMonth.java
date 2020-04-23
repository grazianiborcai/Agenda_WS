package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StolateSetterMonth extends InfoSetterTemplate<StolateInfo> {
	
	@Override protected StolateInfo setAttrHook(StolateInfo recordInfo) {
		recordInfo.monthValidFrom = recordInfo.dateValidFrom.getMonth().getValue();
		return recordInfo;
	}
}
