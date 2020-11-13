package br.com.mind5.business.company.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CompVisiMergeCompnap implements InfoMergerVisitor<CompInfo, CompnapInfo> {
	
	@Override public List<CompInfo> beforeMerge(List<CompInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<CompInfo> getUniquifier() {
		return null;
	}
}
