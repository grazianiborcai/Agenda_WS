package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class EmpmatSetterDel extends InfoSetterTemplate<EmpmatInfo> {
	
	@Override protected EmpmatInfo setAttrHook(EmpmatInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
