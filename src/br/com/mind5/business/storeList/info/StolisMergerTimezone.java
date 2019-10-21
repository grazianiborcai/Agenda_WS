package br.com.mind5.business.storeList.info;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolisMergerTimezone extends InfoMergerTemplate<StolisInfo, TimezoneInfo> {

	@Override protected InfoMergerVisitor<StolisInfo, TimezoneInfo> getVisitorHook() {
		return new StolisVisiMergeTimezone();
	}
	
	
	
	@Override protected InfoUniquifier<StolisInfo> getUniquifierHook() {
		return new StolisUniquifier();
	}
}
