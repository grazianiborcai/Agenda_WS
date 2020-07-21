package br.com.mind5.business.ownerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class OwnerapVisiMergeComplis implements InfoMergerVisitorV3<OwnerapInfo, ComplisInfo> {
	
	@Override public List<OwnerapInfo> beforeMerge(List<OwnerapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OwnerapInfo> getUniquifier() {
		return null;
	}
}
