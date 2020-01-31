package br.com.mind5.business.scheduleList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedistMergerToSelect extends InfoMergerTemplate_<SchedistInfo, SchedistInfo> {

	@Override protected InfoMergerVisitor_<SchedistInfo, SchedistInfo> getVisitorHook() {
		return new SchedistVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedistInfo> getUniquifierHook() {
		return new SchedistUniquifier();
	}
}
