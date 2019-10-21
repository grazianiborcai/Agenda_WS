package br.com.mind5.business.storeList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerToSelect extends InfoMergerTemplate<StolisInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, StolisInfo> getVisitorHook() {
		return new StolisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
