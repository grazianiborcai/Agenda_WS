package br.com.mind5.business.calendarCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CalgueVisiMergeCalate implements InfoMergerVisitorV3<CalgueInfo, CalateInfo> {
	
	@Override public List<CalgueInfo> beforeMerge(List<CalgueInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalgueInfo baseInfo, CalateInfo selectedInfo) {
		return (baseInfo.year  == selectedInfo.year && 
				baseInfo.month == selectedInfo.month	);
	}
	
	
	
	@Override public List<CalgueInfo> merge(CalgueInfo baseInfo, CalateInfo selectedInfo) {
		List<CalgueInfo> results = new ArrayList<>();
		
		baseInfo.calates.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
		
	@Override public InfoUniquifier<CalgueInfo> getUniquifier() {
		return null;
	}
}
