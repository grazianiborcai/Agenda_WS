package br.com.gda.business.scheduleMonth.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedmonMergerStolis extends InfoMergerTemplate<SchedmonInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<SchedmonInfo, StolisInfo> getVisitorHook() {
		return new SchedmonVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
