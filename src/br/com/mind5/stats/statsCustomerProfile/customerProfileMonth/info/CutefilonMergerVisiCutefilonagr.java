package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;

final class CutefilonMergerVisiCutefilonagr extends InfoMergerVisitorTemplate<CutefilonInfo, CutefilonagrInfo> {

	@Override public boolean shouldMerge(CutefilonInfo baseInfo, CutefilonagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<CutefilonInfo> merge(CutefilonInfo baseInfo, CutefilonagrInfo selectedInfo) {
		List<CutefilonInfo> results = new ArrayList<>();
		
		CutefilonInfo result = CutefilonInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
