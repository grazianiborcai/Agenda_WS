package br.com.mind5.business.materialStock.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatockMergerVisiToUpdate extends InfoMergerVisitorTemplate<MatockInfo, MatockInfo> {

	@Override public boolean shouldMerge(MatockInfo baseInfo, MatockInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&& 
				baseInfo.codStore == selectedInfo.codStore	&&
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatockInfo> merge(MatockInfo baseInfo, MatockInfo selectedInfo) {
		List<MatockInfo> results = new ArrayList<>();
		
		selectedInfo.quantityToUpdate = baseInfo.quantityToUpdate;
		selectedInfo.codMatmovType = baseInfo.codMatmovType;
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
