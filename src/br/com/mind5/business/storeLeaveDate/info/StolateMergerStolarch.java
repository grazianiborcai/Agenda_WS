package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolateMergerStolarch extends InfoMergerTemplate<StolateInfo, StolarchInfo> {

	@Override protected InfoMergerVisitor<StolateInfo, StolarchInfo> getVisitorHook() {
		return new StolateVisiMergeStolarch();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
