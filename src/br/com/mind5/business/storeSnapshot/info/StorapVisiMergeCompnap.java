package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StorapVisiMergeCompnap implements InfoMergerVisitorV3<StorapInfo, CompnapInfo> {
	
	@Override public List<StorapInfo> beforeMerge(List<StorapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<StorapInfo> getUniquifier() {
		return new StorapUniquifier();
	}
}
