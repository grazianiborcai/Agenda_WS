package br.com.mind5.business.storeLunchTime.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StuntmSetterCreatedBy extends InfoSetterTemplate<StuntmInfo> {
	
	@Override protected StuntmInfo setAttrHook(StuntmInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
