package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class StowotmSetterDel extends InfoSetterTemplate<StowotmInfo> {
	
	@Override protected StowotmInfo setAttrHook(StowotmInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
