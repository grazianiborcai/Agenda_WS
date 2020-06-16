package br.com.mind5.business.employeePosition.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class EmposSetterDel extends InfoSetterTemplate<EmposInfo> {
	
	@Override protected EmposInfo setAttrHook(EmposInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
