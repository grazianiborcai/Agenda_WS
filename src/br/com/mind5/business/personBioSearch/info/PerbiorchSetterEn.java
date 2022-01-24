package br.com.mind5.business.personBioSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.language.info.Langu;

public final class PerbiorchSetterEn extends InfoSetterTemplate<PerbiorchInfo> {
	
	@Override protected PerbiorchInfo setAttrHook(PerbiorchInfo recordInfo) {
		PerbiorchInfo result = new PerbiorchInfo();
		
		result.codLanguage = Langu.ENGLISH.getCod();
		
		return result;
	}
}
