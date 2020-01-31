package br.com.mind5.business.scheduleYear.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedyearMergerStolis extends InfoMergerTemplate_<SchedyearInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<SchedyearInfo, StolisInfo> getVisitorHook() {
		return new SchedyearVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyearInfo> getUniquifierHook() {
		return new SchedyearUniquifier();
	}
}
