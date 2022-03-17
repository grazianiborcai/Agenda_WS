package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerVisiCompnap extends InfoMergerVisitorTemplate<StorapInfo, CompnapInfo> {

	@Override public boolean shouldMerge(StorapInfo baseInfo, CompnapInfo selectedInfo) {
		return (baseInfo.codOwner   		== selectedInfo.codOwner	&&
				baseInfo.codCompany 		== selectedInfo.codCompany	&&
				baseInfo.codCompanySnapshot == selectedInfo.codSnapshot		);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, CompnapInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.companyData = CompInfo.copyFrom(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StorapInfo> uniquifyHook(List<StorapInfo> results) {
		InfoUniquifier<StorapInfo> uniquifier = new StorapUniquifier();		
		return uniquifier.uniquify(results);
	}
}
