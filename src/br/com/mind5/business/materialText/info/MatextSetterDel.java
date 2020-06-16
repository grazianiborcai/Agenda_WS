package br.com.mind5.business.materialText.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class MatextSetterDel extends InfoSetterTemplate<MatextInfo> {
	
	@Override protected MatextInfo setAttrHook(MatextInfo recordInfo) {	
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
