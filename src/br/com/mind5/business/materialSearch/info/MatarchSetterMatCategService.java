package br.com.mind5.business.materialSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.materialCategory.info.Mateg;

public final class MatarchSetterMatCategService extends InfoSetterTemplate<MatarchInfo> {
	
	@Override protected MatarchInfo setAttrHook(MatarchInfo recordInfo) {
		recordInfo.codMatCateg = Mateg.SERVICE.getCodMatCateg();		
		return recordInfo;
	}
}
