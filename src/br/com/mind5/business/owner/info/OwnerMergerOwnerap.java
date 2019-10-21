package br.com.mind5.business.owner.info;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnerMergerOwnerap extends InfoMergerTemplate<OwnerInfo, OwnerapInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, OwnerapInfo> getVisitorHook() {
		return new OwnerVisiMergeOwnerap();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
