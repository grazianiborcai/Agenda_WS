package br.com.gda.business.owner.info;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerOwntore extends InfoMergerTemplate<OwnerInfo, OwntoreInfo> {

	@Override protected InfoMergerVisitorV2<OwnerInfo, OwntoreInfo> getVisitorHook() {
		return new OwnerVisiMergeOwntore();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
