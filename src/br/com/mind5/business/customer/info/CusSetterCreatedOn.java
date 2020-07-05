package br.com.mind5.business.customer.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CusSetterCreatedOn extends InfoSetterTemplate<CusInfo> {
	
	@Override protected CusInfo setAttrHook(CusInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
