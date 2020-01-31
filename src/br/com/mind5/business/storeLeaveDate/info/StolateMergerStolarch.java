package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolateMergerStolarch extends InfoMergerTemplate_<StolateInfo, StolarchInfo> {

	@Override protected InfoMergerVisitor_<StolateInfo, StolarchInfo> getVisitorHook() {
		return new StolateVisiMergeStolarch();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
