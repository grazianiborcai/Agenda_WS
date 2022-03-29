package br.com.mind5.business.ownerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OwnelisMergerVisiComplis extends InfoMergerVisitorTemplate<OwnelisInfo, ComplisInfo> {

	@Override public boolean shouldMerge(OwnelisInfo baseInfo, ComplisInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner &&
				baseInfo.codCompany == selectedInfo.codCompany	);
	}
	
	
	
	@Override public List<OwnelisInfo> merge(OwnelisInfo baseInfo, ComplisInfo selectedInfo) {
		List<OwnelisInfo> results = new ArrayList<>();
		
		baseInfo.complisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
