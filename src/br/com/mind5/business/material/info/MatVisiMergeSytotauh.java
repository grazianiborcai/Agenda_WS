package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatVisiMergeSytotauh extends InfoMergerVisitorTemplate<MatInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(MatInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<MatInfo> merge(MatInfo baseInfo, SytotauhInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
