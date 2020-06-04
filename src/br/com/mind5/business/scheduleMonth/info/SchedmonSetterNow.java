package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SchedmonSetterNow extends InfoSetterTemplate<SchedmonInfo> {
	
	@Override protected SchedmonInfo setAttrHook(SchedmonInfo recordInfo) {
		recordInfo.month = DefaultValue.localDateNow().getMonthValue();
		recordInfo.year = DefaultValue.localDateNow().getYear();
		
		return recordInfo;
	}
}
