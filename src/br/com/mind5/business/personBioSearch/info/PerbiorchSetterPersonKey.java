package br.com.mind5.business.personBioSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PerbiorchSetterPersonKey extends InfoSetterTemplate<PerbiorchInfo> {
	
	@Override protected PerbiorchInfo setAttrHook(PerbiorchInfo recordInfo) {
		PerbiorchInfo result = new PerbiorchInfo();
		
		result.codLanguage = null;
		
		return result;
	}
}
