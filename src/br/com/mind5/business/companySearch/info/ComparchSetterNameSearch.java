package br.com.mind5.business.companySearch.info;

import br.com.mind5.common.StringUtil;
import br.com.mind5.info.InfoSetterTemplate;

public final class ComparchSetterNameSearch extends InfoSetterTemplate<ComparchInfo> {
	
	@Override protected ComparchInfo setAttrHook(ComparchInfo recordInfo) {
		recordInfo.nameSearch = StringUtil.normalizeSearch(recordInfo.nameSearch);		
		
		return recordInfo;
	}
}
