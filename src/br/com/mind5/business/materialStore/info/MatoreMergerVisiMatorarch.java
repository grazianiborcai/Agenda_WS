package br.com.mind5.business.materialStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatoreMergerVisiMatorarch extends InfoMergerVisitorTemplate<MatoreInfo, MatorarchInfo> {

	@Override public boolean shouldMerge(MatoreInfo baseInfo, MatorarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatoreInfo> merge(MatoreInfo baseInfo, MatorarchInfo selectedInfo) {
		List<MatoreInfo> results = new ArrayList<>();
		
		MatoreInfo result = MatoreInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
