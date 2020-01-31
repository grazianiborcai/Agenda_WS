package br.com.mind5.business.owner.info;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerMergerOwnerap extends InfoMergerTemplate_<OwnerInfo, OwnerapInfo> {

	@Override protected InfoMergerVisitor_<OwnerInfo, OwnerapInfo> getVisitorHook() {
		return new OwnerVisiMergeOwnerap();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
