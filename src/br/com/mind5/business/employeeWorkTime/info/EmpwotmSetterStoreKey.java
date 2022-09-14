package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmpwotmSetterStoreKey extends InfoSetterTemplate<EmpwotmInfo> {
	
	@Override protected EmpwotmInfo setAttrHook(EmpwotmInfo recordInfo) {
		EmpwotmInfo result = new EmpwotmInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
