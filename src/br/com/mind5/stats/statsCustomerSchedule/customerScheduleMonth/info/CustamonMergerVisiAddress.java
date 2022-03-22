package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CustamonMergerVisiAddress extends InfoMergerVisitorTemplate<CustamonInfo, AddressInfo> {

	@Override public boolean shouldMerge(CustamonInfo baseInfo, AddressInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codCustomer == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<CustamonInfo> merge(CustamonInfo baseInfo, AddressInfo selectedInfo) {
		List<CustamonInfo> results = new ArrayList<>();
		
		baseInfo.codCountry = selectedInfo.codCountry;
		baseInfo.txtCountry = selectedInfo.txtCountry;
		baseInfo.codState 	= selectedInfo.codState;
		baseInfo.txtState 	= selectedInfo.txtState;
		baseInfo.city 		= "N/A";	
		
		results.add(baseInfo);
		return results;
	}
}
