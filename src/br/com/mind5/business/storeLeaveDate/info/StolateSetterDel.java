package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class StolateSetterDel extends InfoSetterTemplate<StolateInfo> {
	
	@Override protected StolateInfo setAttrHook(StolateInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
