package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedineMergerOrdist extends InfoMergerTemplate<SchedineInfo, OrdistInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, OrdistInfo> getVisitorHook() {
		return new SchedineVisiMergeOrdist();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}	
}
