package br.com.gda.business.storeSnapshot.info;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StorapMergerTimezone extends InfoMergerTemplate<StorapInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, TimezoneInfo> getVisitorHook() {
		return new StorapVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
