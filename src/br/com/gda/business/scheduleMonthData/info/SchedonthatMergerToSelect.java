package br.com.gda.business.scheduleMonthData.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedonthatMergerToSelect extends InfoMergerTemplate<SchedonthatInfo, SchedonthatInfo> {

	@Override protected InfoMergerVisitor<SchedonthatInfo, SchedonthatInfo> getVisitorHook() {
		return new SchedonthatVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedonthatInfo> getUniquifierHook() {
		return new SchedonthatUniquifier();
	}
}
