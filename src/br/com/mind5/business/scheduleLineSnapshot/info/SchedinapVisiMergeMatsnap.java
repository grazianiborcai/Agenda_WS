package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class SchedinapVisiMergeMatsnap extends InfoMergerVisitorTemplate<SchedinapInfo, MatsnapInfo> {
	
	@Override public List<SchedinapInfo> beforeMerge(List<SchedinapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedinapInfo baseInfo, MatsnapInfo selectedInfo) {
		return (baseInfo.codOwner 		== selectedInfo.codOwner && 
				baseInfo.codMat  		== selectedInfo.codMat   &&
				baseInfo.codMatSnapshot == selectedInfo.codSnapshot);
	}
	
	
	
	@Override public List<SchedinapInfo> merge(SchedinapInfo baseInfo, MatsnapInfo selectedInfo) {
		List<SchedinapInfo> results = new ArrayList<>();
		
		baseInfo.matData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedinapInfo> getUniquifier() {
		return null;
	}
}
