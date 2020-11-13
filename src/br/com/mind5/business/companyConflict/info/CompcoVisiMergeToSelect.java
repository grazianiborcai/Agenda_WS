package br.com.mind5.business.companyConflict.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CompcoVisiMergeToSelect implements InfoMergerVisitor<CompcoInfo, CompcoInfo> {
	
	@Override public List<CompcoInfo> beforeMerge(List<CompcoInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CompcoInfo baseInfo, CompcoInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CompcoInfo> merge(CompcoInfo baseInfo, CompcoInfo selectedInfo) {
		List<CompcoInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;

		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CompcoInfo> getUniquifier() {
		return null;
	}
}
