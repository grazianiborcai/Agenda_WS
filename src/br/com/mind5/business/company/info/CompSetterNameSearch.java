package br.com.mind5.business.company.info;

import br.com.mind5.common.StringUtil;
import br.com.mind5.info.InfoSetterTemplate;

public final class CompSetterNameSearch extends InfoSetterTemplate<CompInfo> {
	
	@Override protected CompInfo setAttrHook(CompInfo recordInfo) {		
		recordInfo.nameSearch = StringUtil.normalizeSearch(recordInfo.name);
		
		return recordInfo;
	}
}
