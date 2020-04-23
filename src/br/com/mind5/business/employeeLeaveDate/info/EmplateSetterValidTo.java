package br.com.mind5.business.employeeLeaveDate.info;

import java.time.LocalDateTime;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmplateSetterValidTo extends InfoSetterTemplate<EmplateInfo> {
	
	@Override protected EmplateInfo setAttrHook(EmplateInfo recordInfo) {
		recordInfo.validTo = LocalDateTime.of(recordInfo.dateValidTo, recordInfo.timeValidTo);
		return recordInfo;
	}
}
