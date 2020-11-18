package br.com.mind5.business.materialStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;


final class MatoreVisiMergeMatock extends InfoMergerVisitorTemplate<MatoreInfo, MatockInfo> {
	
	@Override public List<MatoreInfo> beforeMerge(List<MatoreInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatoreInfo baseInfo, MatockInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatoreInfo> merge(MatoreInfo baseInfo, MatockInfo selectedInfo) {
		List<MatoreInfo> results = new ArrayList<>();
		
		baseInfo.quantityStock = selectedInfo.quantityStock;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatoreInfo> getUniquifier() {
		return null;
	}
}
