package br.com.mind5.business.scheduleYear.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedyearMergerStolis extends InfoMergerTemplate<SchedyearInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<SchedyearInfo, StolisInfo> getVisitorHook() {
		return new SchedyearVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedyearInfo> getUniquifierHook() {
		return new SchedyearUniquifier();
	}
}
