package br.com.mind5.business.person.info;

import br.com.mind5.business.masterData.info.common.EntityCateg;
import br.com.mind5.info.InfoSetterTemplate;

public final class PersonSetterCategCus extends InfoSetterTemplate<PersonInfo> {
	
	@Override protected PersonInfo setAttrHook(PersonInfo recordInfo) {
		recordInfo.codEntityCateg = EntityCateg.CUSTOMER.getCodEntityCateg();
		return recordInfo;
	}
}
