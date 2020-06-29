package br.com.mind5.business.personSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.entityCategory.info.Entiteg;

public final class PerarchSetterCategEmp extends InfoSetterTemplate<PerarchInfo> {
	
	@Override protected PerarchInfo setAttrHook(PerarchInfo recordInfo) {
		recordInfo.codEntityCateg = Entiteg.EMPLOYEE.getCodEntityCateg();
		return recordInfo;
	}	
}
