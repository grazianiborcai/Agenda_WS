package br.com.mind5.business.scheduleMonthData.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedonthatMergerToSelect extends InfoMergerTemplate<SchedonthatInfo, SchedonthatInfo> {

	@Override protected InfoMergerVisitor<SchedonthatInfo, SchedonthatInfo> getVisitorHook() {
		return new SchedonthatVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedonthatInfo> getUniquifierHook() {
		return new SchedonthatUniquifier();
	}
}
