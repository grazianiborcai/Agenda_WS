package br.com.mind5.business.storeProspectCounter.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoprosouSetterStopros extends InfoSetterTemplate<StoprosouInfo> {
	
	@Override protected StoprosouInfo setAttrHook(StoprosouInfo recordInfo) {
		recordInfo.stoproses = null;
		return recordInfo;
	}
}
