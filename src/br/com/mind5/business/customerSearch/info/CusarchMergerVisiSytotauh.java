package br.com.mind5.business.customerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusarchVisiMergeSytotauh extends InfoMergerVisitorTemplate<CusarchInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(CusarchInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusarchInfo> merge(CusarchInfo baseInfo, SytotauhInfo selectedInfo) {
		List<CusarchInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
