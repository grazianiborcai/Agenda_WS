package br.com.mind5.security.userSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class UserapVisiMergeToSelect extends InfoMergerVisitorTemplate<UserapInfo, UserapInfo> {

	@Override public boolean shouldMerge(UserapInfo baseInfo, UserapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<UserapInfo> merge(UserapInfo baseInfo, UserapInfo selectedInfo) {
		List<UserapInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UserapInfo> getUniquifier() {
		return new UserapUniquifier();
	}
}
