package br.com.mind5.business.materialSearch.info;

import br.com.mind5.business.masterData.info.common.MatCateg;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatarchSetterMatCategProduct extends InfoSetterTemplate<MatarchInfo> {
	
	@Override protected MatarchInfo setAttrHook(MatarchInfo recordInfo) {
		recordInfo.codMatCateg = MatCateg.PRODUCT.getCodMatCateg();		
		return recordInfo;
	}
}
