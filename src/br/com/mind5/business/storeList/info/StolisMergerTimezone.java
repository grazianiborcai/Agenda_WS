package br.com.mind5.business.storeList.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolisMergerTimezone extends InfoMergerTemplate_<StolisInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor_<StolisInfo, TimezoneInfo> getVisitorHook() {
		return new StolisVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
