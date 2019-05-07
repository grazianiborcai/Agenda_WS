package br.com.gda.business.owner.info;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerComp extends InfoMergerTemplate<OwnerInfo, CompInfo> {

	@Override protected InfoMergerVisitorV2<OwnerInfo, CompInfo> getVisitorHook() {
		return new OwnerVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
