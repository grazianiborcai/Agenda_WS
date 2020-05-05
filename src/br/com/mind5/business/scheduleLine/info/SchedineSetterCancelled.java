package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.masterData.info.common.ScheduleStatus;
import br.com.mind5.info.InfoSetterTemplate;

public final class SchedineSetterCancelled extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		recordInfo.codScheduleStatus = ScheduleStatus.CANCELLED.getCodStatus();
		return recordInfo;
	}
}
