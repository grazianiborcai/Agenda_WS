package br.com.mind5.business.materialMovement.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class MatmovVisiMergeMatock extends InfoMergerVisitorTemplate<MatmovInfo, MatockInfo> {
	
	@Override public List<MatmovInfo> beforeMerge(List<MatmovInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatmovInfo baseInfo, MatockInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codMat   == selectedInfo.codMat	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<MatmovInfo> merge(MatmovInfo baseInfo, MatockInfo selectedInfo) {
		List<MatmovInfo> results = new ArrayList<>();
		
		baseInfo.quantityStock = selectedInfo.quantityStock;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatmovInfo> getUniquifier() {
		return null;
	}
}
