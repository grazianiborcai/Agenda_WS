package br.com.mind5.security.username.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class UsernameMergerVisiToSelect extends InfoMergerVisitorTemplate<UsernameInfo, UsernameInfo> {

	@Override public boolean shouldMerge(UsernameInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<UsernameInfo> merge(UsernameInfo baseInfo, UsernameInfo selectedInfo) {
		List<UsernameInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public List<UsernameInfo> uniquifyHook(List<UsernameInfo> results) {
		InfoUniquifier<UsernameInfo> uniquifier = new UsernameUniquifier();		
		return uniquifier.uniquify(results);
	}
}
