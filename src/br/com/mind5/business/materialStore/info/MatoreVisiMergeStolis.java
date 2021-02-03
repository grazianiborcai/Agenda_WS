package br.com.mind5.business.materialStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatoreVisiMergeStolis extends InfoMergerVisitorTemplate<MatoreInfo, StolisInfo> {

	@Override public boolean shouldMerge(MatoreInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<MatoreInfo> merge(MatoreInfo baseInfo, StolisInfo selectedInfo) {
		List<MatoreInfo> results = new ArrayList<>();
		
		baseInfo.stolisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
