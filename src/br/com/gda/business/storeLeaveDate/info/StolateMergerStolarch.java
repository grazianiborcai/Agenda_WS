package br.com.gda.business.storeLeaveDate.info;

import br.com.gda.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StolateMergerStolarch extends InfoMergerTemplate<StolateInfo, StolarchInfo> {

	@Override protected InfoMergerVisitor<StolateInfo, StolarchInfo> getVisitorHook() {
		return new StolateVisiMergeStolarch();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
