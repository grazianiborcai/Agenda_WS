package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StolateSetterCreatedBy extends InfoSetterTemplate<StolateInfo> {
	
	@Override protected StolateInfo setAttrHook(StolateInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;	
		return recordInfo;
	}
}
