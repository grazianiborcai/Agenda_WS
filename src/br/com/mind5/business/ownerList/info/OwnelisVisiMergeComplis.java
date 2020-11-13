package br.com.mind5.business.ownerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnelisVisiMergeComplis implements InfoMergerVisitor<OwnelisInfo, ComplisInfo> {
	
	@Override public List<OwnelisInfo> beforeMerge(List<OwnelisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OwnelisInfo> getUniquifier() {
		return null;
	}
}
