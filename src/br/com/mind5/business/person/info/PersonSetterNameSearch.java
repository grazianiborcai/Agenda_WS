package br.com.mind5.business.person.info;

import br.com.mind5.common.StringUtil;
import br.com.mind5.info.InfoSetterTemplate;

public final class PersonSetterNameSearch extends InfoSetterTemplate<PersonInfo> {
	
	@Override protected PersonInfo setAttrHook(PersonInfo recordInfo) {
		recordInfo.nameSearch = StringUtil.normalizeSearch(recordInfo.nameSearch);		
		return recordInfo;
	}
}
