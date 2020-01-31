package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineMergerStolis extends InfoMergerTemplate_<SchedineInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<SchedineInfo, StolisInfo> getVisitorHook() {
		return new SchedineVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
