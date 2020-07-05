package br.com.mind5.business.customer.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CusSetterCreatedBy extends InfoSetterTemplate<CusInfo> {
	
	@Override protected CusInfo setAttrHook(CusInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
