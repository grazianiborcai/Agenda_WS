package br.com.mind5.business.personSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.entityCategory.info.Entiteg;

public final class PerarchSetterCategCus extends InfoSetterTemplate<PerarchInfo> {
	
	@Override protected PerarchInfo setAttrHook(PerarchInfo recordInfo) {
		recordInfo.codEntityCateg = Entiteg.CUSTOMER.getCodEntityCateg();
		return recordInfo;
	}	
}
