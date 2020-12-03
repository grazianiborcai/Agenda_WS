package br.com.mind5.discount.discountStore.info;

import java.time.LocalDateTime;

import br.com.mind5.info.InfoSetterTemplate;

public final class DisoreSetterValidFromMin extends InfoSetterTemplate<DisoreInfo> {
	
	@Override protected DisoreInfo setAttrHook(DisoreInfo recordInfo) {
		recordInfo.validFrom = LocalDateTime.of(1900, 1, 1, 0, 0);
		return recordInfo;
	}
}
