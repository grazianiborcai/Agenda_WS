package br.com.mind5.business.employeeLunchTime.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class EmplutmSetterDel extends InfoSetterTemplate<EmplutmInfo> {
	
	@Override protected EmplutmInfo setAttrHook(EmplutmInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
