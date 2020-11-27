package br.com.mind5.business.customerSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CusarchSetterPerson extends InfoSetterTemplate<CusarchInfo> {
	
	@Override protected CusarchInfo setAttrHook(CusarchInfo recordInfo) {	
		if (recordInfo.persolisData == null)
			return recordInfo;	
		
		recordInfo.persolisData.codOwner = recordInfo.codOwner;	
		recordInfo.persolisData.codLanguage = recordInfo.codLanguage;
		recordInfo.persolisData.username = recordInfo.username;
		
		return recordInfo;
	}	
}
