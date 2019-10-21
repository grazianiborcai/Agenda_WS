package br.com.mind5.business.owner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnerMergerToSelect extends InfoMergerTemplate<OwnerInfo, OwnerInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, OwnerInfo> getVisitorHook() {
		return new OwnerVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
