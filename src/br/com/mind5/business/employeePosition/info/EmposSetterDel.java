package br.com.mind5.business.employeePosition.info;

import br.com.mind5.business.masterData.info.common.RecordMode;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmposSetterDel extends InfoSetterTemplate<EmposInfo> {
	
	@Override protected EmposInfo setAttrHook(EmposInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
