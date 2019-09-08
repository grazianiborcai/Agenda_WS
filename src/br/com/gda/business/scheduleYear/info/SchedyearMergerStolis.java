package br.com.gda.business.scheduleYear.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedyearMergerStolis extends InfoMergerTemplate<SchedyearInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<SchedyearInfo, StolisInfo> getVisitorHook() {
		return new SchedyearVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyearInfo> getUniquifierHook() {
		return new SchedyearUniquifier();
	}
}
