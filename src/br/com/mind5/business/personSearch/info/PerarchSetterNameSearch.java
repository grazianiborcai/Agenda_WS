package br.com.mind5.business.personSearch.info;

import br.com.mind5.common.StringUtil;
import br.com.mind5.info.InfoSetterTemplate;

public final class PerarchSetterNameSearch extends InfoSetterTemplate<PerarchInfo> {
	
	@Override protected PerarchInfo setAttrHook(PerarchInfo recordInfo) {
		String nameToSearch =  getNameToSearch(recordInfo);		
		recordInfo.nameSearch = StringUtil.normalizeSearch(nameToSearch);		
		
		return recordInfo;
	}
	
	
	
	private String getNameToSearch(PerarchInfo recordInfo) {
		String result = recordInfo.nameSearch;
		
		if (result == null)
			result = recordInfo.name;
		
		return result;
	}
}
