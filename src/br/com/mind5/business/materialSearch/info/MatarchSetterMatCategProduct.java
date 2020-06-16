package br.com.mind5.business.materialSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.materialCategory.info.Mateg;

public final class MatarchSetterMatCategProduct extends InfoSetterTemplate<MatarchInfo> {
	
	@Override protected MatarchInfo setAttrHook(MatarchInfo recordInfo) {
		recordInfo.codMatCateg = Mateg.PRODUCT.getCodMatCateg();		
		return recordInfo;
	}
}
