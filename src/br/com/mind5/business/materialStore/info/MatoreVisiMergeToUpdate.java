package br.com.mind5.business.materialStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatoreVisiMergeToUpdate extends InfoMergerVisitorTemplate<MatoreInfo, MatoreInfo> {

	@Override public boolean shouldMerge(MatoreInfo baseInfo, MatoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codMat   == selectedInfo.codMat   &&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<MatoreInfo> merge(MatoreInfo baseInfo, MatoreInfo selectedInfo) {
		List<MatoreInfo> results = new ArrayList<>();
		
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.createdOn = selectedInfo.createdOn;
		
		results.add(baseInfo);
		return results;
	}
}
