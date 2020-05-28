package br.com.mind5.business.scheduleWeekData.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SchedeekdatSetterWeekday extends InfoSetterTemplate<SchedeekdatInfo> {
	
	public SchedeekdatInfo setAttr(SchedeekdatInfo recordInfo) {
		recordInfo.codWeekday = recordInfo.date.getDayOfWeek().getValue();		
		return recordInfo;
	}
}
