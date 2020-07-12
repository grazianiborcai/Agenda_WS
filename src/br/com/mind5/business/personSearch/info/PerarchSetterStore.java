package br.com.mind5.business.personSearch.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PerarchSetterStore extends InfoSetterTemplate<PerarchInfo> {
	
	@Override protected PerarchInfo setAttrHook(PerarchInfo recordInfo) {
		recordInfo.codStore = DefaultValue.number();		
		return recordInfo;
	}
}
