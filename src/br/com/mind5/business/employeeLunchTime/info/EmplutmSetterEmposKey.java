package br.com.mind5.business.employeeLunchTime.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmplutmSetterEmposKey extends InfoSetterTemplate<EmplutmInfo> {
	
	@Override protected EmplutmInfo setAttrHook(EmplutmInfo recordInfo) {
		EmplutmInfo result = new EmplutmInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codEmployee = recordInfo.codEmployee;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
