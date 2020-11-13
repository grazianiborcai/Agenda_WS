package br.com.mind5.business.scheduleYear.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedyearVisiMergeStolis implements InfoMergerVisitor<SchedyearInfo, StolisInfo> {
	
	@Override public List<SchedyearInfo> beforeMerge(List<SchedyearInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedyearInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<SchedyearInfo> merge(SchedyearInfo baseInfo, StolisInfo selectedInfo) {
		List<SchedyearInfo> results = new ArrayList<>();
		
		baseInfo.stolises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedyearInfo> getUniquifier() {
		return null;
	}
}
