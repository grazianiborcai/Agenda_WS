package br.com.mind5.business.materialSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class MatsnapVisiMergeMatextsnap extends InfoMergerVisitorTemplate<MatsnapInfo, MatextsnapInfo> {
	
	@Override public List<MatsnapInfo> beforeMerge(List<MatsnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatsnapInfo baseInfo, MatextsnapInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner		&&
				baseInfo.codSnapshot == selectedInfo.codSnapshot	&&
				baseInfo.codMat 	 == selectedInfo.codMat				);
	}
	
	
	
	@Override public List<MatsnapInfo> merge(MatsnapInfo baseInfo, MatextsnapInfo selectedInfo) {
		List<MatsnapInfo> results = new ArrayList<>();
		
		baseInfo.txtMat = selectedInfo.txtMat;
		baseInfo.description = selectedInfo.description;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatsnapInfo> getUniquifier() {
		return null;
	}
}
