package br.com.gda.business.scheduleList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedistMergerToSelect extends InfoMergerTemplate<SchedistInfo, SchedistInfo> {

	@Override protected InfoMergerVisitor<SchedistInfo, SchedistInfo> getVisitorHook() {
		return new SchedistVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedistInfo> getUniquifierHook() {
		return new SchedistUniquifier();
	}
}
