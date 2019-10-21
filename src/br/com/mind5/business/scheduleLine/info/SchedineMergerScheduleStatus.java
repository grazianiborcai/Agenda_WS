package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerScheduleStatus extends InfoMergerTemplate<SchedineInfo, ScheduleStatusInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, ScheduleStatusInfo> getVisitorHook() {
		return new SchedineVisiMergeScheduleStatus();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
