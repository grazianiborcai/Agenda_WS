package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;

final class CusMergerVisiCutefilon extends InfoMergerVisitorTemplate<CusInfo, CutefilonInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, CutefilonInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codCustomer == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, CutefilonInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.cutefilonData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
