package br.com.gda.business.owner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerToUpdate extends InfoMergerTemplate<OwnerInfo, OwnerInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, OwnerInfo> getVisitorHook() {
		return new OwnerVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
