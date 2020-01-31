package br.com.mind5.business.scheduleMonth.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedmonMergerStolis extends InfoMergerTemplate_<SchedmonInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<SchedmonInfo, StolisInfo> getVisitorHook() {
		return new SchedmonVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedmonInfo> getUniquifierHook() {
		return new SchedmonUniquifier();
	}
}
