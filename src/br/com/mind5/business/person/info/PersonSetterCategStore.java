package br.com.mind5.business.person.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.entityCategory.info.Entiteg;

public final class PersonSetterCategStore extends InfoSetterTemplate<PersonInfo> {
	
	@Override protected PersonInfo setAttrHook(PersonInfo recordInfo) {
		recordInfo.codEntityCateg = Entiteg.STORE.getCodEntityCateg();
		return recordInfo;
	}
}
