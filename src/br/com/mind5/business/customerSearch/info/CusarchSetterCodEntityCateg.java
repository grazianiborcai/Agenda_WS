package br.com.mind5.business.customerSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.entityCategory.info.Entiteg;

public final class CusarchSetterCodEntityCateg extends InfoSetterTemplate<CusarchInfo> {
	
	@Override protected CusarchInfo setAttrHook(CusarchInfo recordInfo) {	
		recordInfo.codEntityCateg = Entiteg.CUSTOMER.getCodEntityCateg();
		return recordInfo;
	}	
}
