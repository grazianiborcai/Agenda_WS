package br.com.mind5.business.owner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerMergerToDelete extends InfoMergerTemplate_<OwnerInfo, OwnerInfo> {

	@Override protected InfoMergerVisitor_<OwnerInfo, OwnerInfo> getVisitorHook() {
		return new OwnerVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
