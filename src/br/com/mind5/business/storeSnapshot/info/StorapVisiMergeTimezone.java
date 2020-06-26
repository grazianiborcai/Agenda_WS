package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;

final class StorapVisiMergeTimezone implements InfoMergerVisitorV3<StorapInfo, TimezoneInfo> {

	@Override public List<StorapInfo> beforeMerge(List<StorapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(StorapInfo baseInfo, TimezoneInfo selectedInfo) {
		return (baseInfo.codTimezone.equals(selectedInfo.codTimezone));
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, TimezoneInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<StorapInfo> getUniquifier() {
		return new StorapUniquifier();
	}
}
