package br.com.mind5.business.scheduleMonthData.info;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedonthatMergerMonth extends InfoMergerTemplate<SchedonthatInfo, MonthInfo> {

	@Override protected InfoMergerVisitor<SchedonthatInfo, MonthInfo> getVisitorHook() {
		return new SchedonthatVisiMergeMonth();
	}
	
	
	
	@Override protected InfoUniquifier<SchedonthatInfo> getUniquifierHook() {
		return new SchedonthatUniquifier();
	}
}
