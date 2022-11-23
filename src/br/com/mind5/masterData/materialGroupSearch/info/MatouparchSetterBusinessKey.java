package br.com.mind5.masterData.materialGroupSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatouparchSetterBusinessKey extends InfoSetterTemplate<MatouparchInfo> {
	
	@Override protected MatouparchInfo setAttrHook(MatouparchInfo recordInfo) {
		MatouparchInfo result = new MatouparchInfo();
				
				
		result.codLanguage 	= recordInfo.codLanguage;
		result.codBusiness 	= recordInfo.codBusiness;
		
		return result;
	}
}
