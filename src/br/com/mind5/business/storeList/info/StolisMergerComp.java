package br.com.mind5.business.storeList.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolisMergerComp extends InfoMergerTemplate_<StolisInfo, CompInfo> {

	@Override protected InfoMergerVisitor_<StolisInfo, CompInfo> getVisitorHook() {
		return new StolisVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
