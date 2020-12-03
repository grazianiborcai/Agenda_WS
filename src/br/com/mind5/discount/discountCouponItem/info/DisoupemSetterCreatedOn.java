package br.com.mind5.discount.discountCouponItem.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class DisoupemSetterCreatedOn extends InfoSetterTemplate<DisoupemInfo> {
	
	@Override protected DisoupemInfo setAttrHook(DisoupemInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}	
}
