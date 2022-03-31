package br.com.mind5.business.storeNearby.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StorbyMergerVisiComplis extends InfoMergerVisitorTemplate<StorbyInfo, ComplisInfo> {
	
	@Override public boolean shouldMerge(StorbyInfo baseInfo, ComplisInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner 	&&
				baseInfo.codCompany == selectedInfo.codCompany		);
	}
	
	
	
	@Override public List<StorbyInfo> merge(StorbyInfo baseInfo, ComplisInfo selectedInfo) {
		List<StorbyInfo> results = new ArrayList<>();
		
		baseInfo.complisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
