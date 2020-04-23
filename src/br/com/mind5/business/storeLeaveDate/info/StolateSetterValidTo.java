package br.com.mind5.business.storeLeaveDate.info;

import java.time.LocalDateTime;

import br.com.mind5.info.InfoSetterTemplate;

public final class StolateSetterValidTo extends InfoSetterTemplate<StolateInfo> {
	
	@Override protected StolateInfo setAttrHook(StolateInfo recordInfo) {
		recordInfo.validTo = LocalDateTime.of(recordInfo.dateValidTo, recordInfo.timeValidTo);
		return recordInfo;
	}
}
