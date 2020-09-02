package br.com.mind5.business.calendarCatalogueData.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CalguataVisiMergePlanata implements InfoMergerVisitorV3<CalguataInfo, PlanataInfo> {
	
	@Override public List<CalguataInfo> beforeMerge(List<CalguataInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalguataInfo baseInfo, PlanataInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner 	&& 
				baseInfo.codStore == selectedInfo.codStore 	&&
				baseInfo.codMat   == selectedInfo.codMat	&&
				baseInfo.date.isEqual(selectedInfo.date) );
	}
	
	
	
	@Override public List<CalguataInfo> merge(CalguataInfo baseInfo, PlanataInfo selectedInfo) {
		List<CalguataInfo> results = new ArrayList<>();
		
		baseInfo.codDaypart = selectedInfo.codDaypart;
		baseInfo.isAvailable = true;
		
		results.add(baseInfo);
		return results;
	}
	
	
		
	@Override public InfoUniquifier<CalguataInfo> getUniquifier() {
		return null;
	}
}
