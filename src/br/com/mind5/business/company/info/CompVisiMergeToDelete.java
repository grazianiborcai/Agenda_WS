package br.com.mind5.business.company.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CompVisiMergeToDelete implements InfoMergerVisitorV3<CompInfo, CompInfo> {
	
	@Override public List<CompInfo> beforeMerge(List<CompInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CompInfo baseInfo, CompInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner	&&
				baseInfo.codCompany == selectedInfo.codCompany		);
	}
	
	
	
	@Override public List<CompInfo> merge(CompInfo baseInfo, CompInfo selectedInfo) {
		List<CompInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;

		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CompInfo> getUniquifier() {
		return null;
	}
}
