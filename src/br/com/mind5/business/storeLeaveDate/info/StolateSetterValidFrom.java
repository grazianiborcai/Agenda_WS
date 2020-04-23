package br.com.mind5.business.storeLeaveDate.info;

import java.time.LocalDateTime;

import br.com.mind5.info.InfoSetterTemplate;

public final class StolateSetterValidFrom extends InfoSetterTemplate<StolateInfo> {
	
	@Override protected StolateInfo setAttrHook(StolateInfo recordInfo) {
		recordInfo.validFrom = LocalDateTime.of(recordInfo.dateValidFrom, recordInfo.timeValidFrom);
		return recordInfo;
	}
}
