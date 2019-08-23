package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.masterData.info.ScheduleStatusInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedineMergerScheduleStatus extends InfoMergerTemplate<SchedineInfo, ScheduleStatusInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, ScheduleStatusInfo> getVisitorHook() {
		return new SchedineVisiMergeScheduleStatus();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
