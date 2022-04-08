package br.com.mind5.business.materialStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatoreMergerVisiToDelete extends InfoMergerVisitorTemplate<MatoreInfo, MatoreInfo> {

	@Override public boolean shouldMerge(MatoreInfo baseInfo, MatoreInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codMat   == selectedInfo.codMat   &&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<MatoreInfo> merge(MatoreInfo baseInfo, MatoreInfo selectedInfo) {
		List<MatoreInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
