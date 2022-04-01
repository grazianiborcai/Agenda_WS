package br.com.mind5.business.calendarCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalgueMergerVisiStolis extends InfoMergerVisitorTemplate<CalgueInfo, StolisInfo> {

	@Override public boolean shouldMerge(CalgueInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
			    baseInfo.codStore == selectedInfo.codStore);
	}
	
	
	
	@Override public List<CalgueInfo> merge(CalgueInfo baseInfo, StolisInfo selectedInfo) {
		List<CalgueInfo> results = new ArrayList<>();
		
		baseInfo.stolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}

}
