package br.com.mind5.business.personSearch.info;

import br.com.mind5.common.StringUtil;
import br.com.mind5.info.InfoSetterTemplate;

public final class PerarchSetterNameSearch extends InfoSetterTemplate<PerarchInfo> {
	
	@Override protected PerarchInfo setAttrHook(PerarchInfo recordInfo) {
		recordInfo.nameSearch = StringUtil.normalizeSearch(recordInfo.nameSearch);		
		return recordInfo;
	}
}
