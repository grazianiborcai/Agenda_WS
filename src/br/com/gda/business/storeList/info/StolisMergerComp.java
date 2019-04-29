package br.com.gda.business.storeList.info;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StolisMergerComp extends InfoMergerTemplate<StolisInfo, CompInfo> {

	@Override protected InfoMergerVisitorV2<StolisInfo, CompInfo> getVisitorHook() {
		return new StolisVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
