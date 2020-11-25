package br.com.mind5.security.userSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class UserarchVisiMergeToSelect extends InfoMergerVisitorTemplate<UserarchInfo, UserarchInfo> {

	@Override public boolean shouldMerge(UserarchInfo baseInfo, UserarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<UserarchInfo> merge(UserarchInfo baseInfo, UserarchInfo selectedInfo) {
		List<UserarchInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
