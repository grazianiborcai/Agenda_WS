package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerVisiComp extends InfoMergerVisitorTemplate<StoreInfo, CompInfo> {

	@Override public boolean shouldMerge(StoreInfo baseInfo, CompInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, CompInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.companyData = selectedInfo;
		baseInfo.codCompany = selectedInfo.codCompany;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StoreInfo> uniquifyHook(List<StoreInfo> results) {
		InfoUniquifier<StoreInfo> uniquifier = new StoreUniquifier();		
		return uniquifier.uniquify(results);
	}
}
