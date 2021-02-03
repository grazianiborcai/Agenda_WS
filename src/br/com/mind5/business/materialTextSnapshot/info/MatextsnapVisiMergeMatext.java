package br.com.mind5.business.materialTextSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatextsnapVisiMergeMatext extends InfoMergerVisitorTemplate<MatextsnapInfo, MatextInfo> {

	@Override public boolean shouldMerge(MatextsnapInfo baseInfo, MatextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatextsnapInfo> merge(MatextsnapInfo baseInfo, MatextInfo selectedInfo) {
		List<MatextsnapInfo> results = new ArrayList<>();
		
		MatextsnapInfo result = MatextsnapInfo.copyFrom(selectedInfo);		
		result.codSnapshot = baseInfo.codSnapshot;		
		
		results.add(result);
		return results;
	}
}
