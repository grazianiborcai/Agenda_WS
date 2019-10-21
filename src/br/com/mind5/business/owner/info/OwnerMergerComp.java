package br.com.mind5.business.owner.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnerMergerComp extends InfoMergerTemplate<OwnerInfo, CompInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, CompInfo> getVisitorHook() {
		return new OwnerVisiMergeComp();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
