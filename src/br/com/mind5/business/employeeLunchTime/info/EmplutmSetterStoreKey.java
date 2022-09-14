package br.com.mind5.business.employeeLunchTime.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmplutmSetterStoreKey extends InfoSetterTemplate<EmplutmInfo> {
	
	@Override protected EmplutmInfo setAttrHook(EmplutmInfo recordInfo) {
		EmplutmInfo result = new EmplutmInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codStore = recordInfo.codStore;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
