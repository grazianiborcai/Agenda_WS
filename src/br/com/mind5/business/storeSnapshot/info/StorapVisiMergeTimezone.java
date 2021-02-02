package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;

final class StorapVisiMergeTimezone extends InfoMergerVisitorTemplate<StorapInfo, TimezoneInfo> {

	@Override public boolean shouldMerge(StorapInfo baseInfo, TimezoneInfo selectedInfo) {
		return (baseInfo.codTimezone.equals(selectedInfo.codTimezone));
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, TimezoneInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StorapInfo> uniquifyHook(List<StorapInfo> results) {
		InfoUniquifier<StorapInfo> uniquifier = new StorapUniquifier();		
		return uniquifier.uniquify(results);
	}
}
