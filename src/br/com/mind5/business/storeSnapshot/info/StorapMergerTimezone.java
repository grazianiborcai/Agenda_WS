package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;

final class StorapMergerTimezone extends InfoMergerTemplate_<StorapInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, TimezoneInfo> getVisitorHook() {
		return new StorapVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
