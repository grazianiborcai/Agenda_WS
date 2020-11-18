package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekVisiMergeSchedeekdat extends InfoMergerVisitorTemplate<SchedeekInfo, SchedeekdatInfo> {
	
	@Override public List<SchedeekInfo> beforeMerge(List<SchedeekInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedeekInfo baseInfo, SchedeekdatInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner  && 
				baseInfo.codStore 	== selectedInfo.codStore  &&
				baseInfo.weekYear  == selectedInfo.weekYear	);
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, SchedeekdatInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.schedeekdates.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedeekInfo> getUniquifier() {
		return null;
	}
}
