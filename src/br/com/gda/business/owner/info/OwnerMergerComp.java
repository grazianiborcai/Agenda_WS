package br.com.gda.business.owner.info;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerComp extends InfoMergerTemplate<OwnerInfo, CompInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, CompInfo> getVisitorHook() {
		return new OwnerVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
