package br.com.mind5.business.scheduleYear.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SchedyearSetterNow extends InfoSetterTemplate<SchedyearInfo> {
	
	@Override protected SchedyearInfo setAttrHook(SchedyearInfo recordInfo) {
		recordInfo.year = DefaultValue.localDateNow().getYear();
		
		return recordInfo;
	}
}
