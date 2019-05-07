package br.com.gda.business.ownerStore.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OwntoreMergerToSelect extends InfoMergerTemplate<OwntoreInfo, OwntoreInfo> {

	@Override protected InfoMergerVisitorV2<OwntoreInfo, OwntoreInfo> getVisitorHook() {
		return new OwntoreVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OwntoreInfo> getUniquifierHook() {
		return new OwntoreUniquifier();
	}
}
