package br.com.mind5.business.materialSearch.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatarchSetterCodStore extends InfoSetterTemplate<MatarchInfo> {
	
	@Override protected MatarchInfo setAttrHook(MatarchInfo recordInfo) {
		recordInfo.codStore = DefaultValue.number();		
		return recordInfo;
	}
}
