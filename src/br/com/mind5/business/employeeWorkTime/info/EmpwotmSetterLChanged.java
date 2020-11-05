package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmpwotmSetterLChanged extends InfoSetterTemplate<EmpwotmInfo> {
	
	@Override protected EmpwotmInfo setAttrHook(EmpwotmInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
