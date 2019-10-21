package br.com.mind5.business.scheduleList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedistMergerToSelect extends InfoMergerTemplate<SchedistInfo, SchedistInfo> {

	@Override protected InfoMergerVisitor<SchedistInfo, SchedistInfo> getVisitorHook() {
		return new SchedistVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedistInfo> getUniquifierHook() {
		return new SchedistUniquifier();
	}
}
