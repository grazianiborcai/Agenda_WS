package br.com.mind5.business.storeLunchTime.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class StuntmSetterDel extends InfoSetterTemplate<StuntmInfo> {
	
	@Override protected StuntmInfo setAttrHook(StuntmInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
