package br.com.mind5.discount.discountStore.info;

import java.time.LocalDateTime;

import br.com.mind5.info.InfoSetterTemplate;

public final class DisoreSetterValidToMax extends InfoSetterTemplate<DisoreInfo> {
	
	@Override protected DisoreInfo setAttrHook(DisoreInfo recordInfo) {
		recordInfo.validTo = LocalDateTime.of(9999, 12, 31, 0, 0);
		return recordInfo;
	}
}
