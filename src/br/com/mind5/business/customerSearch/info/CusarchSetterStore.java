package br.com.mind5.business.customerSearch.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CusarchSetterStore extends InfoSetterTemplate<CusarchInfo> {
	
	@Override protected CusarchInfo setAttrHook(CusarchInfo recordInfo) {	
		recordInfo.codStore = DefaultValue.number();
		return recordInfo;
	}	
}
