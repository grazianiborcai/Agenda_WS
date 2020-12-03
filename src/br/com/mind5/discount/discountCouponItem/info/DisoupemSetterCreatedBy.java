package br.com.mind5.discount.discountCouponItem.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class DisoupemSetterCreatedBy extends InfoSetterTemplate<DisoupemInfo> {
	
	@Override protected DisoupemInfo setAttrHook(DisoupemInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
