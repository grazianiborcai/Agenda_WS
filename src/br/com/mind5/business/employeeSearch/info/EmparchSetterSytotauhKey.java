package br.com.mind5.business.employeeSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmparchSetterSytotauhKey extends InfoSetterTemplate<EmparchInfo> {
	
	@Override protected EmparchInfo setAttrHook(EmparchInfo recordInfo) {
		EmparchInfo result = new EmparchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codEmployee = recordInfo.codEmployee;
		result.codStore = recordInfo.codStore;
		result.username = recordInfo.username;
		result.codLanguage = recordInfo.codLanguage;
		
		return result;
	}
}
