package br.com.mind5.business.person.info;

import java.text.Normalizer;

import br.com.mind5.info.InfoSetterTemplate;

public final class PersonSetterNameSearch extends InfoSetterTemplate<PersonInfo> {
	
	@Override protected PersonInfo setAttrHook(PersonInfo recordInfo) {
		if (recordInfo.name == null)
			return recordInfo;
		
		
		recordInfo.nameSearch = recordInfo.name.toUpperCase();
		recordInfo.nameSearch = Normalizer.normalize(recordInfo.nameSearch, Normalizer.Form.NFD);
		recordInfo.nameSearch = recordInfo.nameSearch.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		
		return recordInfo;
	}
}
