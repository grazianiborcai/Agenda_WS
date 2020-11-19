package br.com.mind5.business.personList.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PersolisSetterRestricted extends InfoSetterTemplate<PersolisInfo> {
	
	@Override protected PersolisInfo setAttrHook(PersolisInfo recordInfo) {
		PersolisInfo result = new PersolisInfo();
		
		result.codOwner = recordInfo.codOwner;	
		result.codPerson = recordInfo.codPerson;
		result.codSnapshot = recordInfo.codSnapshot;
		result.name = recordInfo.name;
		result.nameDisplay = recordInfo.nameDisplay;
		result.recordMode = recordInfo.recordMode;
		result.username = recordInfo.username;		
		result.codLanguage = recordInfo.codLanguage;	
		
		return result;
	}
}
