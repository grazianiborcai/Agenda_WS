package br.com.gda.business.owner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerToDelete extends InfoMergerTemplate<OwnerInfo, OwnerInfo> {

	@Override protected InfoMergerVisitorV2<OwnerInfo, OwnerInfo> getVisitorHook() {
		return new OwnerVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
