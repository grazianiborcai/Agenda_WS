package br.com.mind5.business.employeeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmplisMergerVisiSytotauh extends InfoMergerVisitorTemplate<EmplisInfo, SytotauhInfo> {
	
	@Override public boolean shouldMerge(EmplisInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<EmplisInfo> merge(EmplisInfo baseInfo, SytotauhInfo selectedInfo) {
		List<EmplisInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
