package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatlisMergerVisiSytotauh extends InfoMergerVisitorTemplate<MatlisInfo, SytotauhInfo> {
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, SytotauhInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
