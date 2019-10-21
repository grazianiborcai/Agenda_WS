package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerOrdist extends InfoMergerTemplate<SchedineInfo, OrdistInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, OrdistInfo> getVisitorHook() {
		return new SchedineVisiMergeOrdist();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}	
}
