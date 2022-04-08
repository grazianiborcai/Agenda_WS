package br.com.mind5.business.materialText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatextMergerVisiToDelete extends InfoMergerVisitorTemplate<MatextInfo, MatextInfo> {

	@Override public boolean shouldMerge(MatextInfo baseInfo, MatextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&& 
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatextInfo> merge(MatextInfo baseInfo, MatextInfo selectedInfo) {
		List<MatextInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
