package br.com.mind5.business.storeLunchTime.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StuntmSetterIsDeletedOn extends InfoSetterTemplate<StuntmInfo> {
	
	@Override protected StuntmInfo setAttrHook(StuntmInfo recordInfo) {
		recordInfo.isDeleted = true;
		return recordInfo;
	}
}
