package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerStolis extends InfoMergerTemplate<SchedineInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, StolisInfo> getVisitorHook() {
		return new SchedineVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
