package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolateMergerStolis extends InfoMergerTemplate_<StolateInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<StolateInfo, StolisInfo> getVisitorHook() {
		return new StolateVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
