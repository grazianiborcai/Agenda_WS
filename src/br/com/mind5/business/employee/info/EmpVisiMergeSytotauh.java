package br.com.mind5.business.employee.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpVisiMergeSytotauh extends InfoMergerVisitorTemplate<EmpInfo, SytotauhInfo> {
	
	@Override public boolean shouldMerge(EmpInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<EmpInfo> merge(EmpInfo baseInfo, SytotauhInfo selectedInfo) {
		List<EmpInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
