package br.com.mind5.business.employee.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmpSetterObfuscate extends InfoSetterTemplate<EmpInfo> {
	
	@Override protected EmpInfo setAttrHook(EmpInfo recordInfo) {
		EmpInfo result = new EmpInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}	
}
