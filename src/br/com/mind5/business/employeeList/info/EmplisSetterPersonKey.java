package br.com.mind5.business.employeeList.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmplisSetterPersonKey extends InfoSetterTemplate<EmplisInfo> {
	
	@Override protected EmplisInfo setAttrHook(EmplisInfo recordInfo) {
		recordInfo.persolisData.codOwner = recordInfo.codOwner;
		recordInfo.persolisData.codPerson = recordInfo.codPerson;
		recordInfo.persolisData.username = recordInfo.username;
		recordInfo.persolisData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
}
