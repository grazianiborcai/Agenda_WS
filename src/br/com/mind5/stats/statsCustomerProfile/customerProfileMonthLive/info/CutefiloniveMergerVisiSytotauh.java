package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CutefiloniveMergerVisiSytotauh extends InfoMergerVisitorTemplate<CutefiloniveInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(CutefiloniveInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<CutefiloniveInfo> merge(CutefiloniveInfo baseInfo, SytotauhInfo selectedInfo) {
		List<CutefiloniveInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
