package br.com.mind5.business.employee.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmpSetterPhoneCod extends InfoSetterTemplate<EmpInfo> {
	
	@Override protected EmpInfo setAttrHook(EmpInfo recordInfo) {
		if (recordInfo.phones == null)
			return recordInfo;
		
		for (PhoneInfo eachRecord : recordInfo.phones) {
			eachRecord.codPhone = DefaultValue.number();
		}
		
		return recordInfo;
	}
}
