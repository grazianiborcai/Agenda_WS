package br.com.mind5.business.employeeMaterialSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmpmarchSetterEmpKey extends InfoSetterTemplate<EmpmarchInfo> {
	
	@Override protected EmpmarchInfo setAttrHook(EmpmarchInfo recordInfo) {
		EmpmarchInfo enforcedRecord = new EmpmarchInfo();
		
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codEmployee = recordInfo.codEmployee;
		enforcedRecord.codLanguage = recordInfo.codLanguage;
		enforcedRecord.username = recordInfo.username;
		
		return enforcedRecord;
	}
}
