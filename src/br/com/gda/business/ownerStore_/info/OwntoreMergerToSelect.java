package br.com.gda.business.ownerStore_.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OwntoreMergerToSelect extends InfoMergerTemplate<OwntoreInfo, OwntoreInfo> {

	@Override protected InfoMergerVisitor<OwntoreInfo, OwntoreInfo> getVisitorHook() {
		return new OwntoreVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OwntoreInfo> getUniquifierHook() {
		return new OwntoreUniquifier();
	}
}
