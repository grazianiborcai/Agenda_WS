package br.com.mind5.security.user.info;

import br.com.mind5.business.masterData.info.common.EntityCateg;
import br.com.mind5.info.InfoSetterTemplate;

public final class UserSetterPersonKey extends InfoSetterTemplate<UserInfo> {
	
	@Override protected UserInfo setAttrHook(UserInfo recordInfo) {
		recordInfo.personData.codOwner = recordInfo.codOwner;
		recordInfo.personData.codPerson = recordInfo.codPerson;
		recordInfo.personData.codEntityCateg = EntityCateg.USER.getCodEntityCateg();
		recordInfo.personData.codLanguage = recordInfo.codLanguage;
		recordInfo.personData.username = recordInfo.username;
		
		return recordInfo;
	}
}
