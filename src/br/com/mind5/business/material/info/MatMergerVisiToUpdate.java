package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatMergerVisiToUpdate extends InfoMergerVisitorTemplate<MatInfo, MatInfo> {

	@Override public boolean shouldMerge(MatInfo baseInfo, MatInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.codMatCateg = selectedInfo.codMatCateg;
		baseInfo.codStore = selectedInfo.codStore;
		baseInfo.isLocked = selectedInfo.isLocked;
		
		results.add(baseInfo);
		return results;
	}
}
