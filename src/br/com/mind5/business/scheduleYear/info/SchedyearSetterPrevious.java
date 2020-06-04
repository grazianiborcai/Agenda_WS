package br.com.mind5.business.scheduleYear.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SchedyearSetterPrevious extends InfoSetterTemplate<SchedyearInfo> {
	
	@Override protected SchedyearInfo setAttrHook(SchedyearInfo recordInfo) {
		recordInfo.year = recordInfo.year - 1;
		
		return recordInfo;
	}
}
