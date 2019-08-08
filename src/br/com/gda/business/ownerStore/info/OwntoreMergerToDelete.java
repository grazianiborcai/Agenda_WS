package br.com.gda.business.ownerStore.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OwntoreMergerToDelete extends InfoMergerTemplate<OwntoreInfo, OwntoreInfo> {

	@Override protected InfoMergerVisitor<OwntoreInfo, OwntoreInfo> getVisitorHook() {
		return new OwntoreVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<OwntoreInfo> getUniquifierHook() {
		return new OwntoreUniquifier();
	}
}
