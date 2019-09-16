package br.com.gda.business.owner.info;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerOwnerap extends InfoMergerTemplate<OwnerInfo, OwnerapInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, OwnerapInfo> getVisitorHook() {
		return new OwnerVisiMergeOwnerap();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
