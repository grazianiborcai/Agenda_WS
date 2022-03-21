package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CustamoniveMergerVisiSytotauh extends InfoMergerVisitorTemplate<CustamoniveInfo, SytotauhInfo> {

	@Override public boolean shouldMerge(CustamoniveInfo baseInfo, SytotauhInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	

	@Override public List<CustamoniveInfo> merge(CustamoniveInfo baseInfo, SytotauhInfo selectedInfo) {
		List<CustamoniveInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		
		results.add(baseInfo);
		return results;
	}
}
