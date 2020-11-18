package br.com.mind5.business.calendarCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDateAvailability.info.CalatityInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class CalgueVisiMergeCalatity extends InfoMergerVisitorTemplate<CalgueInfo, CalatityInfo> {
	
	@Override public List<CalgueInfo> beforeMerge(List<CalgueInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalgueInfo baseInfo, CalatityInfo selectedInfo) {
		return (baseInfo.year  == selectedInfo.year && 
				baseInfo.month == selectedInfo.month	);
	}
	
	
	
	@Override public List<CalgueInfo> merge(CalgueInfo baseInfo, CalatityInfo selectedInfo) {
		List<CalgueInfo> results = new ArrayList<>();
		
		baseInfo.calatitys.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
		
	@Override public InfoUniquifier<CalgueInfo> getUniquifier() {
		return null;
	}
}
