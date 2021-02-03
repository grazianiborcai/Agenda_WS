package br.com.mind5.business.materialMovement.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatmovVisiMergeMatlis extends InfoMergerVisitorTemplate<MatmovInfo, MatlisInfo> {

	@Override public boolean shouldMerge(MatmovInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codMat   == selectedInfo.codMat			);
	}
	
	
	
	@Override public List<MatmovInfo> merge(MatmovInfo baseInfo, MatlisInfo selectedInfo) {
		List<MatmovInfo> results = new ArrayList<>();
		
		baseInfo.matlisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
