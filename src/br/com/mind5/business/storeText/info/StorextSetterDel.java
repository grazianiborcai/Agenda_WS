package br.com.mind5.business.storeText.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class StorextSetterDel extends InfoSetterTemplate<StorextInfo> {
	
	@Override protected StorextInfo setAttrHook(StorextInfo recordInfo) {	
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
