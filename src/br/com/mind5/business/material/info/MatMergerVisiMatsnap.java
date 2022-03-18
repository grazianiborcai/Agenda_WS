package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatMergerVisiMatsnap extends InfoMergerVisitorTemplate<MatInfo, MatsnapInfo> {

	@Override public boolean shouldMerge(MatInfo baseInfo, MatsnapInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner	&&
				baseInfo.codMat 	== selectedInfo.codMat			);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatsnapInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
