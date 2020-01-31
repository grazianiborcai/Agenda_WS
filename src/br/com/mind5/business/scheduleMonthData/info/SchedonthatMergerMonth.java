package br.com.mind5.business.scheduleMonthData.info;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedonthatMergerMonth extends InfoMergerTemplate_<SchedonthatInfo, MonthInfo> {

	@Override protected InfoMergerVisitor_<SchedonthatInfo, MonthInfo> getVisitorHook() {
		return new SchedonthatVisiMergeMonth();
	}
	
	
	
	@Override protected InfoUniquifier<SchedonthatInfo> getUniquifierHook() {
		return new SchedonthatUniquifier();
	}
}
