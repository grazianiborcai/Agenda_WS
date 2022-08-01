package br.com.mind5.masterData.languageSearch.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class LangarchSetterAll extends InfoSetterTemplate<LangarchInfo> {
	
	@Override protected LangarchInfo setAttrHook(LangarchInfo recordInfo) {
		recordInfo.codLanguage = null;
		return recordInfo;
	}
}
