package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.scheduleStatus.info.Schedatus;

public final class SchedineSetterCancelled extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		recordInfo.codScheduleStatus = Schedatus.CANCELLED.getCodStatus();
		return recordInfo;
	}
}
