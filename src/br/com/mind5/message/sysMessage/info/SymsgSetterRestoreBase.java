package br.com.mind5.message.sysMessage.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SymsgSetterRestoreBase extends InfoSetterTemplate<SymsgInfo> {
	
	@Override protected SymsgInfo setAttrHook(SymsgInfo recordInfo) {
		recordInfo.codLanguage = recordInfo.codLanguageBase;		
		return recordInfo;
	}
}
