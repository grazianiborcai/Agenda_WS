package br.com.mind5.business.employeeWorkTimeSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmpwotarchSetterEmpKey extends InfoSetterTemplate<EmpwotarchInfo> {
	
	@Override protected EmpwotarchInfo setAttrHook(EmpwotarchInfo recordInfo) {
		EmpwotarchInfo result = new EmpwotarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codEmployee = recordInfo.codEmployee;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;

		return result;
	}
}
