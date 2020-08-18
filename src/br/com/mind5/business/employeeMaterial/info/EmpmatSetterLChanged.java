package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmpmatSetterLChanged extends InfoSetterTemplate<EmpmatInfo> {
	
	@Override protected EmpmatInfo setAttrHook(EmpmatInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
