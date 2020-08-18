package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmpmatSetterEmpKey extends InfoSetterTemplate<EmpmatInfo> {
	
	@Override protected EmpmatInfo setAttrHook(EmpmatInfo recordInfo) {
		EmpmatInfo enforcedRecord = new EmpmatInfo();
		
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codEmployee = recordInfo.codEmployee;
		enforcedRecord.codLanguage = recordInfo.codLanguage;
		enforcedRecord.username = recordInfo.username;
		
		return enforcedRecord;
	}
}
