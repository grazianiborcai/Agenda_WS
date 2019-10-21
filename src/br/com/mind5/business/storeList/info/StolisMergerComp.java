package br.com.mind5.business.storeList.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerComp extends InfoMergerTemplate<StolisInfo, CompInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, CompInfo> getVisitorHook() {
		return new StolisVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
