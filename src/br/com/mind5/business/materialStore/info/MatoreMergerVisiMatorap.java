package br.com.mind5.business.materialStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatoreMergerVisiMatorap extends InfoMergerVisitorTemplate<MatoreInfo, MatorapInfo> {

	@Override public boolean shouldMerge(MatoreInfo baseInfo, MatorapInfo selectedInfo) {
		return (baseInfo.codOwner 	== selectedInfo.codOwner	&&
				baseInfo.codMat 	== selectedInfo.codMat		&&
				baseInfo.codStore 	== selectedInfo.codStore		);
	}
	
	
	
	@Override public List<MatoreInfo> merge(MatoreInfo baseInfo, MatorapInfo selectedInfo) {
		List<MatoreInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
