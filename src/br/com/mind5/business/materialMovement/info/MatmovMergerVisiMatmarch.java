package br.com.mind5.business.materialMovement.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatmovMergerVisiMatmarch extends InfoMergerVisitorTemplate<MatmovInfo, MatmarchInfo> {

	@Override public boolean shouldMerge(MatmovInfo baseInfo, MatmarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatmovInfo> merge(MatmovInfo baseInfo, MatmarchInfo selectedInfo) {
		List<MatmovInfo> results = new ArrayList<>();
		MatmovInfo result;
		
		result = MatmovInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
