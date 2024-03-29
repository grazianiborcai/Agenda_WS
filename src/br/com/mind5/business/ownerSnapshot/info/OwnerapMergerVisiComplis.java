package br.com.mind5.business.ownerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OwnerapMergerVisiComplis extends InfoMergerVisitorTemplate<OwnerapInfo, ComplisInfo> {

	@Override public boolean shouldMerge(OwnerapInfo baseInfo, ComplisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codCompany == selectedInfo.codCompany	);
	}
	
	
	
	@Override public List<OwnerapInfo> merge(OwnerapInfo baseInfo, ComplisInfo selectedInfo) {
		List<OwnerapInfo> results = new ArrayList<>();
		
		baseInfo.codCompanySnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
