package br.com.mind5.business.ownerSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OwnarchSetterBusinessOwnerKey extends InfoSetterTemplate<OwnarchInfo> {
	
	@Override protected OwnarchInfo setAttrHook(OwnarchInfo recordInfo) {
		OwnarchInfo result = new OwnarchInfo();
				
		result.codOwner 	= recordInfo.codOwner;
		result.codBusiness	= recordInfo.codBusiness;
		result.username		= recordInfo.username;
		result.codLanguage	= recordInfo.codLanguage;
		
		return result;
	}
}
