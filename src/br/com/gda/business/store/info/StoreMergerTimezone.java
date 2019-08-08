package br.com.gda.business.store.info;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerTimezone extends InfoMergerTemplate<StoreInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, TimezoneInfo> getVisitorHook() {
		return new StoreVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
