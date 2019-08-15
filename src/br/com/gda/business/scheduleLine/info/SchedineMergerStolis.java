package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedineMergerStolis extends InfoMergerTemplate<SchedineInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, StolisInfo> getVisitorHook() {
		return new SchedineVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
