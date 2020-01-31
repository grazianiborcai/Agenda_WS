package br.com.mind5.business.storeList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolisMergerToSelect extends InfoMergerTemplate_<StolisInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<StolisInfo, StolisInfo> getVisitorHook() {
		return new StolisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
