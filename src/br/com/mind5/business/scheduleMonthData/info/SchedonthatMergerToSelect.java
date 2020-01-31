package br.com.mind5.business.scheduleMonthData.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedonthatMergerToSelect extends InfoMergerTemplate_<SchedonthatInfo, SchedonthatInfo> {

	@Override protected InfoMergerVisitor_<SchedonthatInfo, SchedonthatInfo> getVisitorHook() {
		return new SchedonthatVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SchedonthatInfo> getUniquifierHook() {
		return new SchedonthatUniquifier();
	}
}
