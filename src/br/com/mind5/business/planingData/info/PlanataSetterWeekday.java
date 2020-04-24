package br.com.mind5.business.planingData.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PlanataSetterWeekday extends InfoSetterTemplate<PlanataInfo> {
	
	@Override protected PlanataInfo setAttrHook(PlanataInfo recordInfo) {
		recordInfo.codWeekday = recordInfo.date.getDayOfWeek().getValue();		
		return recordInfo;
	}
}
