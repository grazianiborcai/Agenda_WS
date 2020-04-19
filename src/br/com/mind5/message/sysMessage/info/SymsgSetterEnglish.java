package br.com.mind5.message.sysMessage.info;

import br.com.mind5.business.masterData.info.common.Langu;
import br.com.mind5.info.InfoSetterTemplate;

public final class SymsgSetterEnglish extends InfoSetterTemplate<SymsgInfo> {
	
	@Override protected SymsgInfo setAttrHook(SymsgInfo recordInfo) {
		recordInfo.codLanguage = Langu.ENGLISH.getCod();		
		return recordInfo;
	}
}
