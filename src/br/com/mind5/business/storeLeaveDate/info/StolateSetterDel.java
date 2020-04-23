package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.business.masterData.info.common.RecordMode;
import br.com.mind5.info.InfoSetterTemplate;

public final class StolateSetterDel extends InfoSetterTemplate<StolateInfo> {
	
	@Override protected StolateInfo setAttrHook(StolateInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
