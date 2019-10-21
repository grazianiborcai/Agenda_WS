package br.com.mind5.business.store.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerTimezone extends InfoMergerTemplate<StoreInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, TimezoneInfo> getVisitorHook() {
		return new StoreVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
