package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SchedinapVisiMergeMatlis implements InfoMergerVisitorV3<SchedinapInfo, MatlisInfo> {
	
	@Override public List<SchedinapInfo> beforeMerge(List<SchedinapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedinapInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<SchedinapInfo> merge(SchedinapInfo baseInfo, MatlisInfo selectedInfo) {
		List<SchedinapInfo> results = new ArrayList<>();
		
		baseInfo.codMatSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedinapInfo> getUniquifier() {
		return null;
	}
}
