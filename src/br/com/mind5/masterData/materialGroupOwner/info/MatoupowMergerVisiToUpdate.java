package br.com.mind5.masterData.materialGroupOwner.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatoupowMergerVisiToUpdate extends InfoMergerVisitorTemplate<MatoupowInfo, MatoupowInfo> {

	@Override public boolean shouldMerge(MatoupowInfo baseInfo, MatoupowInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codGroup == selectedInfo.codGroup		);
	}
	
	
	
	@Override public List<MatoupowInfo> merge(MatoupowInfo baseInfo, MatoupowInfo selectedInfo) {
		List<MatoupowInfo> results = new ArrayList<>();
		
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.isLocked = selectedInfo.isLocked;
		
		results.add(baseInfo);
		return results;
	}
}
