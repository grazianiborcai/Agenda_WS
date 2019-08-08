package br.com.gda.business.storeList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StolisMergerToSelect extends InfoMergerTemplate<StolisInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, StolisInfo> getVisitorHook() {
		return new StolisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
