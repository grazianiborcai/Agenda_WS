package br.com.mind5.business.materialStore.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class MatoreSetterDel extends InfoSetterTemplate<MatoreInfo> {
	
	@Override protected MatoreInfo setAttrHook(MatoreInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}	
}
