package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StolateSetterYear extends InfoSetterTemplate<StolateInfo> {
	
	@Override protected StolateInfo setAttrHook(StolateInfo recordInfo) {
		recordInfo.yearValidFrom = recordInfo.dateValidFrom.getYear();
		return recordInfo;
	}
}
