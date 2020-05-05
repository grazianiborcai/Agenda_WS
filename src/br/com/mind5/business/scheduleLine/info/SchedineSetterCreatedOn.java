package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SchedineSetterCreatedOn extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
