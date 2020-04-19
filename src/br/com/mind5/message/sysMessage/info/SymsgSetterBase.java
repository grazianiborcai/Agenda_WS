package br.com.mind5.message.sysMessage.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SymsgSetterBase extends InfoSetterTemplate<SymsgInfo> {
	
	@Override protected SymsgInfo setAttrHook(SymsgInfo recordInfo) {
		recordInfo.codLanguageBase = recordInfo.codLanguage;		
		return recordInfo;
	}
}
