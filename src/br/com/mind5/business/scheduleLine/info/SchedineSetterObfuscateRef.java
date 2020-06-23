package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class SchedineSetterObfuscateRef extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		recordInfo.codScheduleRef = DefaultValue.number();
		return recordInfo;
	}	
}
