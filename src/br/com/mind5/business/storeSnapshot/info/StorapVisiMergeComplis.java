package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class StorapVisiMergeComplis implements InfoMergerVisitorV3<StorapInfo, ComplisInfo> {
	
	@Override public List<StorapInfo> beforeMerge(List<StorapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<StorapInfo> getUniquifier() {
		return new StorapUniquifier();
	}
}