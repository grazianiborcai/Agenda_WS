package br.com.mind5.business.personBioSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.language.info.Langu;

public final class PerbiorchSetterPt extends InfoSetterTemplate<PerbiorchInfo> {
	
	@Override protected PerbiorchInfo setAttrHook(PerbiorchInfo recordInfo) {
		recordInfo.codLanguage = Langu.PORTUGUESE_BR.getCod();		
		return recordInfo;
	}	
}
