package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerTimezone extends InfoMergerTemplate<StorapInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, TimezoneInfo> getVisitorHook() {
		return new StorapVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
