package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatMergerVisiMatext extends InfoMergerVisitorTemplate<MatInfo, MatextInfo> {

	@Override public boolean shouldMerge(MatInfo baseInfo, MatextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codMat   == selectedInfo.codMat			);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatextInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.matextes.add(selectedInfo);	
		
		results.add(baseInfo);
		return results;
	}
}
