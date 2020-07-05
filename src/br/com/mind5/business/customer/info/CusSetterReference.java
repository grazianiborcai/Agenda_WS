package br.com.mind5.business.customer.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CusSetterReference extends InfoSetterTemplate<CusInfo> {
	
	@Override protected CusInfo setAttrHook(CusInfo recordInfo) {
		recordInfo.codUser = DefaultValue.number();
		recordInfo.codPerson = DefaultValue.number();	
		
		return recordInfo;
	}
}
