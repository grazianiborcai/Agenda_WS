package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedmonMergerStolis extends InfoMergerTemplate<SchedmonInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<SchedmonInfo, StolisInfo> getVisitorHook() {
		return new SchedmonVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
