package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineMergerScheduleStatus extends InfoMergerTemplate_<SchedineInfo, ScheduleStatusInfo> {

	@Override protected InfoMergerVisitor_<SchedineInfo, ScheduleStatusInfo> getVisitorHook() {
		return new SchedineVisiMergeScheduleStatus();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
