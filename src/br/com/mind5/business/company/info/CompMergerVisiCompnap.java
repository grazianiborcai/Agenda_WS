package br.com.mind5.business.company.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CompMergerVisiCompnap extends InfoMergerVisitorTemplate<CompInfo, CompnapInfo> {

	@Override public boolean shouldMerge(CompInfo baseInfo, CompnapInfo selectedInfo) {
		return (baseInfo.codOwner	== selectedInfo.codOwner	&&
				baseInfo.codCompany == selectedInfo.codCompany);
	}
	
	
	
	@Override public List<CompInfo> merge(CompInfo baseInfo, CompnapInfo selectedInfo) {
		List<CompInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
