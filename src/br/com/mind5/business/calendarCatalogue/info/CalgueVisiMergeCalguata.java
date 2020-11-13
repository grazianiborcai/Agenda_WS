package br.com.mind5.business.calendarCatalogue.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CalgueVisiMergeCalguata implements InfoMergerVisitor<CalgueInfo, CalguataInfo> {
	
	@Override public List<CalgueInfo> beforeMerge(List<CalgueInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalgueInfo baseInfo, CalguataInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner 	&&
				baseInfo.codStore == selectedInfo.codStore 	&&
				baseInfo.codMat   == selectedInfo.codMat 	&&
				baseInfo.year     == selectedInfo.year 		&& 
				baseInfo.month    == selectedInfo.month			);
	}
	
	
	
	@Override public List<CalgueInfo> merge(CalgueInfo baseInfo, CalguataInfo selectedInfo) {
		List<CalgueInfo> results = new ArrayList<>();
		
		baseInfo.calguatas.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
		
	@Override public InfoUniquifier<CalgueInfo> getUniquifier() {
		return null;
	}
}
