package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StolisVisiMergeTimezone implements InfoMergerVisitorV3<StolisInfo, TimezoneInfo> {
	
	@Override public List<StolisInfo> beforeMerge(List<StolisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StolisInfo baseInfo, TimezoneInfo selectedInfo) {
		return (baseInfo.codTimezone.equals(selectedInfo.codTimezone));
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, TimezoneInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StolisInfo> getUniquifier() {
		return new StolisUniquifier();
	}
}
