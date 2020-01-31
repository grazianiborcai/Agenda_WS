package br.com.mind5.business.store.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoreMergerTimezone extends InfoMergerTemplate_<StoreInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, TimezoneInfo> getVisitorHook() {
		return new StoreVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
