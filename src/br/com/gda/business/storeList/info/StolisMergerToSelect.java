package br.com.gda.business.storeList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StolisMergerToSelect extends InfoMergerTemplate<StolisInfo, StolisInfo> {

	@Override protected InfoMergerVisitorV2<StolisInfo, StolisInfo> getVisitorHook() {
		return new StolisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
