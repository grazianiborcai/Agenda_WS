package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;

final class StoreVisiMergeTimezone implements InfoMergerVisitorV3<StoreInfo, TimezoneInfo> {
	
	@Override public List<StoreInfo> beforeMerge(List<StoreInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StoreInfo baseInfo, TimezoneInfo selectedInfo) {
		return (baseInfo.codTimezone.equals(selectedInfo.codTimezone));
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, TimezoneInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StoreInfo> getUniquifier() {
		return new StoreUniquifier();
	}
}
