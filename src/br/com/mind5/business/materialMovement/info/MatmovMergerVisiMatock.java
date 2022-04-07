package br.com.mind5.business.materialMovement.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatmovMergerVisiMatock extends InfoMergerVisitorTemplate<MatmovInfo, MatockInfo> {

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
}
