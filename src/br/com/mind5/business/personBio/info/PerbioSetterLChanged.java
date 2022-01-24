package br.com.mind5.business.personBio.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PerbioSetterLChanged extends InfoSetterTemplate<PerbioInfo> {
	
	@Override protected PerbioInfo setAttrHook(PerbioInfo recordInfo) {	
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
