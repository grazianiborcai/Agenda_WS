package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StowotmSetterIsDeletedOn extends InfoSetterTemplate<StowotmInfo> {
	
	@Override protected StowotmInfo setAttrHook(StowotmInfo recordInfo) {
		recordInfo.isDeleted = true;
		return recordInfo;
	}
}
