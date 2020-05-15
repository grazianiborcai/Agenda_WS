package br.com.mind5.business.refundPolicy.info;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class RefupolSetterRHour extends InfoSetterTemplate<RefupolInfo> {
	
	@Override protected RefupolInfo setAttrHook(RefupolInfo recordInfo) {
		LocalDateTime now = DefaultValue.localDateTimeNow();
		LocalDateTime beginDateTime = LocalDateTime.of(recordInfo.date, recordInfo.beginTime);
		
		recordInfo.remainingHour = ChronoUnit.HOURS.between(now, beginDateTime);
		return recordInfo;
	}
}
