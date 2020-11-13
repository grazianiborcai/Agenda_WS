package br.com.mind5.security.userSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserarchVisiMergeToSelect implements InfoMergerVisitor<UserarchInfo, UserarchInfo> {
	
	@Override public List<UserarchInfo> beforeMerge(List<UserarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UserarchInfo baseInfo, UserarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<UserarchInfo> merge(UserarchInfo baseInfo, UserarchInfo selectedInfo) {
		List<UserarchInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UserarchInfo> getUniquifier() {
		return null;
	}
}
