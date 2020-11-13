package br.com.mind5.business.materialMovement.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class MatmovVisiMergeMatlis implements InfoMergerVisitorV3<MatmovInfo, MatlisInfo> {
	
	@Override public List<MatmovInfo> beforeMerge(List<MatmovInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<MatmovInfo> getUniquifier() {
		return null;
	}
}
