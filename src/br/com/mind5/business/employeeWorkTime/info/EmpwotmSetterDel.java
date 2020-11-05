package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class EmpwotmSetterDel extends InfoSetterTemplate<EmpwotmInfo> {
	
	@Override protected EmpwotmInfo setAttrHook(EmpwotmInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
