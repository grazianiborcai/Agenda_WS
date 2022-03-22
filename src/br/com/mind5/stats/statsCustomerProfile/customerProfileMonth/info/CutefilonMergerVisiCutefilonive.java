package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;

final class CutefilonMergerVisiCutefilonive extends InfoMergerVisitorTemplate<CutefilonInfo, CutefiloniveInfo> {

	@Override public boolean shouldMerge(CutefilonInfo baseInfo, CutefiloniveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<CutefilonInfo> merge(CutefilonInfo baseInfo, CutefiloniveInfo selectedInfo) {
		List<CutefilonInfo> results = new ArrayList<>();
		
		CutefilonInfo result = CutefilonInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
