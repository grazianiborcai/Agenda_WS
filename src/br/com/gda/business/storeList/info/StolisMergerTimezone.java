package br.com.gda.business.storeList.info;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StolisMergerTimezone extends InfoMergerTemplate<StolisInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, TimezoneInfo> getVisitorHook() {
		return new StolisVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
