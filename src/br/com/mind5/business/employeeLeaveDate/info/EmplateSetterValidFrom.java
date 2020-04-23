package br.com.mind5.business.employeeLeaveDate.info;

import java.time.LocalDateTime;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmplateSetterValidFrom extends InfoSetterTemplate<EmplateInfo> {
	
	@Override protected EmplateInfo setAttrHook(EmplateInfo recordInfo) {
		recordInfo.validFrom = LocalDateTime.of(recordInfo.dateValidFrom, recordInfo.timeValidFrom);
		return recordInfo;
	}
}
