package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerVisiComplis extends InfoMergerVisitorTemplate<StorapInfo, ComplisInfo> {

	@Override public boolean shouldMerge(StorapInfo baseInfo, ComplisInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner	&&
				baseInfo.codCompany == selectedInfo.codCompany		);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, ComplisInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.codCompanySnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StorapInfo> uniquifyHook(List<StorapInfo> results) {
		InfoUniquifier<StorapInfo> uniquifier = new StorapUniquifier();		
		return uniquifier.uniquify(results);
	}
}
