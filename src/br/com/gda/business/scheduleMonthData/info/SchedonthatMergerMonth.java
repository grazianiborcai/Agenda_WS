package br.com.gda.business.scheduleMonthData.info;

import br.com.gda.business.masterData.info.MonthInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedonthatMergerMonth extends InfoMergerTemplate<SchedonthatInfo, MonthInfo> {

	@Override protected InfoMergerVisitor<SchedonthatInfo, MonthInfo> getVisitorHook() {
		return new SchedonthatVisiMergeMonth();
	}
	
	
	
	@Override protected InfoUniquifier<SchedonthatInfo> getUniquifierHook() {
		return new SchedonthatUniquifier();
	}
}
