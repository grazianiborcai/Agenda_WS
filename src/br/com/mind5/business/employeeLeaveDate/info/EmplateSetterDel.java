package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.business.masterData.info.common.RecordMode;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmplateSetterDel extends InfoSetterTemplate<EmplateInfo> {
	
	@Override protected EmplateInfo setAttrHook(EmplateInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
