package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CustamonMergerVisiCuslis extends InfoMergerVisitorTemplate<CustamonInfo, CuslisInfo> {

	@Override public boolean shouldMerge(CustamonInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codCustomer == selectedInfo.codCustomer);
	}
	
	
	
	@Override public List<CustamonInfo> merge(CustamonInfo baseInfo, CuslisInfo selectedInfo) {
		List<CustamonInfo> results = new ArrayList<>();
		
		baseInfo.codStore   = selectedInfo.codStore;
/*		baseInfo.codCountry = "N/A";
		baseInfo.txtCountry = "N/A";
		baseInfo.codState 	= "N/A";
		baseInfo.txtState 	= "N/A";
		baseInfo.city 		= "N/A";
		
		
		if (selectedInfo.persolisData != null) {
			baseInfo.codCountry = selectedInfo.persolisData.codCountry;
			baseInfo.txtCountry = selectedInfo.addressData.txtCountry;
			baseInfo.codState 	= selectedInfo.addressData.codState;
			baseInfo.txtState 	= selectedInfo.addressData.txtState;
			baseInfo.city 		= "N/A";
		}*/
		
		results.add(baseInfo);
		return results;
	}
}
