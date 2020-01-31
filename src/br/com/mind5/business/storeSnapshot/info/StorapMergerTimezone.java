package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapMergerTimezone extends InfoMergerTemplate_<StorapInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, TimezoneInfo> getVisitorHook() {
		return new StorapVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
