package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedineMergerOrdist extends InfoMergerTemplate_<SchedineInfo, OrdistInfo> {

	@Override protected InfoMergerVisitor_<SchedineInfo, OrdistInfo> getVisitorHook() {
		return new SchedineVisiMergeOrdist();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}	
}
