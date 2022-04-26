package br.com.mind5.business.employeeLunchTimeSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmplutmarchSetterEmposKey extends InfoSetterTemplate<EmplutmarchInfo> {
	
	@Override protected EmplutmarchInfo setAttrHook(EmplutmarchInfo recordInfo) {
		EmplutmarchInfo result = new EmplutmarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codEmployee = recordInfo.codEmployee;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;

		return result;
	}
}
