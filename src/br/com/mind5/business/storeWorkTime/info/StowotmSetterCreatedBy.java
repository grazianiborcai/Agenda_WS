package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StowotmSetterCreatedBy extends InfoSetterTemplate<StowotmInfo> {
	
	@Override protected StowotmInfo setAttrHook(StowotmInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
