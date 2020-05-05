package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SchedineSetterWeekday extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		recordInfo.codWeekday = recordInfo.date.getDayOfWeek().getValue();		
		return recordInfo;
	}
}
