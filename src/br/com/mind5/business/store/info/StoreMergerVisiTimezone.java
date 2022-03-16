package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;

final class StoreMergerVisiTimezone extends InfoMergerVisitorTemplate<StoreInfo, TimezoneInfo> {

	@Override public boolean shouldMerge(StoreInfo baseInfo, TimezoneInfo selectedInfo) {
		return (baseInfo.codTimezone.equals(selectedInfo.codTimezone));
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, TimezoneInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.txtTimezone = selectedInfo.txtTimezone;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StoreInfo> uniquifyHook(List<StoreInfo> results) {
		InfoUniquifier<StoreInfo> uniquifier = new StoreUniquifier();		
		return uniquifier.uniquify(results);
	}
}
