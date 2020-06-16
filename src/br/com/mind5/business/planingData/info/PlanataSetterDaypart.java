package br.com.mind5.business.planingData.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.dayParting.info.Daypart;

public final class PlanataSetterDaypart extends InfoSetterTemplate<PlanataInfo> {
	
	@Override protected PlanataInfo setAttrHook(PlanataInfo recordInfo) {		
		if (recordInfo.beginTime != null)
			recordInfo.codDaypart = Daypart.of(recordInfo.beginTime).getCodDaypart();
		
		return recordInfo;
	}
}
